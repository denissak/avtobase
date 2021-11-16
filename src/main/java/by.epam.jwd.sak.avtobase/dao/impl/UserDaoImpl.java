package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.entity.Role;
import by.epam.jwd.sak.avtobase.entity.User;
import by.epam.jwd.sak.avtobase.dao.UserDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.dao.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static by.epam.jwd.sak.avtobase.dao.daoMapping.Mapping.*;

public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final int USER_ROLE_ID = 4;
    private static final int ENABLED = 1;
    private static final int DISABLED = 0;

    private static final String GET_ALL_USER = "SELECT * FROM users as u join roles as r  on r.id = u.role_id WHERE is_active = '1' ORDER BY u.id ";
    private static final String GET_ALL_DISABLED_USER = "SELECT * FROM users as u join roles as r  on r.id = u.role_id WHERE is_active = '0' ORDER BY u.id ";
    private static final String GET_ALL_FREE_DRIVERS = "SELECT * FROM users as u JOIN cars as c on u.id = c.user_id WHERE c.status_car != 'BROKEN'\n" +
            "                                      AND c.id != (SELECT car_id FROM requests as r WHERE r.date_departure = ? \n" +
            "                                      AND r.car_id IN (SELECT c.id FROM users as u JOIN cars as c on u.id = c.user_id WHERE c.status_car != 'BROKEN'))";
    private static final String GET_ALL_DRIVERS = "SELECT * FROM users as u join roles as r  on r.id = u.role_id WHERE r.id = 3 ORDER BY u.surname";
    private static final String SAVE_USER = "INSERT INTO users (login, password, role_id, name, surname, phone_number, is_active)" +
            " VALUES " + "(?,?,?,?,?,?,?)";
    private static final String GET_BY_LOGIN = "SELECT * FROM users as u join roles as r on r.id = u.role_id WHERE login = ?";
    private static final String GET_USER_BY_ID = "SELECT * FROM users as u join roles as r on r.id = u.role_id WHERE u.id = ?";
    private static final String UPDATE_USER = "UPDATE users SET login = ?, role_id = ?, name = ?, surname = ?, phone_number = ? WHERE id = ?";
    private static final String UPDATE_PASSWORD_USER = "UPDATE users SET password = ? WHERE id = ?";
    private static final String DELETE_USER = "UPDATE users SET is_active = ? WHERE id = ?";
    private static final String RESTORE_USER = "UPDATE users SET is_active = ? WHERE id = ?";
//    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?";

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
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return users;
    }

    @Override
    public Optional<User> findById(Long id) throws DAOException {
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID)) {
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = buildEntity(resultSet);
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        int result;

        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, DISABLED);
            preparedStatement.setObject(2, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result > 0;
    }

    @Override
    public boolean restore(Long id) throws DAOException {
        int result;

        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(RESTORE_USER, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, ENABLED);
            preparedStatement.setObject(2, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result > 0;
    }

    @Override
    public boolean update(User entity) throws DAOException {
        int result;
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getLogin());
            preparedStatement.setObject(2, entity.getRole().getId());
            preparedStatement.setObject(3, entity.getName());
            preparedStatement.setObject(4, entity.getSurname());
            preparedStatement.setObject(5, entity.getPhoneNumber());
            preparedStatement.setObject(6, entity.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        if (!entity.getPassword().equals("")) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD_USER, RETURN_GENERATED_KEYS)) {
                preparedStatement.setObject(1, entity.getPassword());
                preparedStatement.setObject(2, entity.getId());
                result = preparedStatement.executeUpdate();
            } catch (SQLException e) {
                LOGGER.error(e);
                throw new DAOException(e.getMessage(), e);
            } finally {
                ConnectionManager.returnConnection(connection);
            }
        }
        return result > 0;
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
            LOGGER.error(e);
            throw new DAOException(e.getMessage(), e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return users;
    }

    @Override
    public List<User> findAllDisabledUser() throws DAOException {
        List<User> users = new ArrayList<>();
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DISABLED_USER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(buildEntity(resultSet));
            }

        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e.getMessage(), e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return users;
    }

    @Override
    public List<User> findAllFreeDrivers(Date date) throws DAOException {
        List<User> users = new ArrayList<>();
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_FREE_DRIVERS)) {
            preparedStatement.setObject(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e.getMessage(), e);
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
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = buildEntity(resultSet);
            }
            return user;
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e.getMessage(), e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
    }

    @Override
    public boolean save(User entity) throws DAOException {
        int result;
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getLogin());
            preparedStatement.setObject(2, entity.getPassword());
            preparedStatement.setObject(3, USER_ROLE_ID);
            preparedStatement.setObject(4, entity.getName());
            preparedStatement.setObject(5, entity.getSurname());
            preparedStatement.setObject(6, entity.getPhoneNumber());
            preparedStatement.setObject(7, ENABLED);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e.getMessage(), e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result > 0;
    }

    private User buildEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject(ID, Long.class))
                .login(resultSet.getObject(LOGIN, String.class))
                .password(resultSet.getObject(PASSWORD, String.class))
                .name(resultSet.getObject(NAME, String.class))
                .surname(resultSet.getObject(SURNAME, String.class))
                .phoneNumber(resultSet.getObject(PHONE_NUMBER, String.class))
                .role(new Role(resultSet.getObject(ROLE_ID, Long.class), resultSet.getObject("r.name", String.class)))
                .build();
    }
}
