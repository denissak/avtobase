package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Role;
import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dao.UserDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static by.epam.jwd.sak.avtobase.dao.daoMapping.Mapping.*;

public class UserDaoImpl implements UserDao {

    private static final int USER_ROLE_ID = 4;

    private static final String GET_ALL_USER = "SELECT * FROM users as u join roles as r  on r.id = u.role_id";

    private static final String GET_ALL_DRIVERS = "SELECT * FROM users as u join roles as r  on r.id = u.role_id WHERE r.id = 3";

    private static final String SAVE_USER = "INSERT INTO users (login, password, role_id, name, surname, phone_number)" +
            " VALUES " + "(?,?,?,?,?,?)";
    private static final String GET_BY_LOGIN = "SELECT * FROM users as u join roles as r on r.id = u.role_id WHERE login = ?";

    private static final String GET_USER_BY_ID = "SELECT * FROM users as u join roles as r on r.id = u.role_id WHERE u.id = ?";

    private static final String UPDATE_USER = "UPDATE users SET login = ?, role_id = ?, name = ?, surname = ?, phone_number = ? WHERE id = ?";

    private static final String UPDATE_PASSWORD_USER = "UPDATE users SET password = ? WHERE id = ?";

    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?";

    @Override
    public Optional<User> findById(Integer id) throws DAOException {
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = buildEntity(resultSet);
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        int result;

        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER, RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result == 1;
    }

    @Override
    public User update(User entity) throws DAOException {
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getLogin());
            preparedStatement.setObject(2, entity.getRole().getId());
            preparedStatement.setObject(3, entity.getName());
            preparedStatement.setObject(4, entity.getSurname());
            preparedStatement.setObject(5, entity.getPhoneNumber());
            preparedStatement.setObject(6, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        if (!entity.getPassword().equals("")) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD_USER, RETURN_GENERATED_KEYS)) {
                preparedStatement.setObject(1, entity.getPassword());
                preparedStatement.setObject(2, entity.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException();
            } finally {
                ConnectionManager.returnConnection(connection);
            }
        }
        return entity;
    }


    @Override
    public List<User> findAll() throws DAOException {
        List<User> users = new ArrayList<>();
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(buildEntity(resultSet));
            }

        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return users;
    }

    @Override
    public List<User> findAllDrivers() throws DAOException {
        List<User> users = new ArrayList<>();
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DRIVERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return users;
    }

    @Override
    public User findByLogin(String login) throws DAOException {
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            /*preparedStatement.setString(2, password);*/
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = buildEntity(resultSet);
            }
            return user;
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
    }

    @Override
    public User save(User entity) throws DAOException {
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getLogin());
            preparedStatement.setObject(2, entity.getPassword());
            preparedStatement.setObject(3, USER_ROLE_ID);
            preparedStatement.setObject(4, entity.getName());
            preparedStatement.setObject(5, entity.getSurname());
            preparedStatement.setObject(6, entity.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return entity;
    }

    private User buildEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject(ID, Integer.class))
                .login(resultSet.getObject(LOGIN, String.class))
                .password(resultSet.getObject(PASSWORD, String.class))
                .name(resultSet.getObject(NAME, String.class))
                .surname(resultSet.getObject(SURNAME, String.class))
                .phoneNumber(resultSet.getObject(PHONE_NUMBER, String.class))
                .role(new Role(resultSet.getObject(ROLE_ID, Integer.class), resultSet.getObject("r.name", String.class)))
                .build();
    }
}
