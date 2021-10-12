package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Role;
import by.epam.jwd.sak.avtobase.bean.User;

import by.epam.jwd.sak.avtobase.dao.UserDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDaoImpl implements UserDao {

    private static final int USER_ROLE_ID = 4;

    private static final String GET_ALL_USER = "SELECT * FROM users as u join roles as r  on r.id = u.role_id";

    private static final String SAVE_USER = "INSERT INTO users (login, password, role_id, name, surname, phone_number)" +
            " VALUES " + "(?,?,?,?,?,?)";
    private static final String GET_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users as u join roles as r on r.id = u.role_id WHERE login = ? AND password = ?";

    private static final String GET_USER_BY_ID = "SELECT * FROM users as u join roles as r on r.id = u.role_id WHERE u.id = ?";

    @Override
    public Optional<User> findById(Integer id) throws DAOException {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = buildEntity(resultSet);
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    @Override
    public User update (User entity) throws DAOException { //TODO
        try {
            try (Connection connection = ConnectionManager.get();
                 PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER, RETURN_GENERATED_KEYS)) {
                preparedStatement.setObject(1, entity.getLogin());
                preparedStatement.setObject(2, entity.getPassword());
                preparedStatement.setObject(3, entity.getRole());
                //preparedStatement.setObject(4, entity.getName());
                //preparedStatement.setObject(5, entity.getSurname());
                //preparedStatement.setObject(6, entity.getPhoneNumber());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return entity;
    }

    @Override
    public List<User> findAll() throws DAOException {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return users;
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) throws DAOException {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_LOGIN_AND_PASSWORD)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = buildEntity(resultSet);
            }

            return Optional.ofNullable(user);


        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    @Override
    public User save(User entity) throws DAOException {
        try {
            try (Connection connection = ConnectionManager.get();
                 PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER, RETURN_GENERATED_KEYS)) {
                preparedStatement.setObject(1, entity.getLogin());
                preparedStatement.setObject(2, entity.getPassword());
                preparedStatement.setObject(3, USER_ROLE_ID);
                preparedStatement.setObject(4, entity.getName());
                preparedStatement.setObject(5, entity.getSurname());
                preparedStatement.setObject(6, entity.getPhoneNumber());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return entity;
    }

    private User buildEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject("id", Integer.class))
                .login(resultSet.getObject("login", String.class))
                .password(resultSet.getObject("password", String.class))
                .name(resultSet.getObject("name", String.class))
                .surname(resultSet.getObject("surname", String.class))
                .phoneNumber(resultSet.getObject("phone_number", String.class))
                .role(new Role(resultSet.getObject("role_id", Integer.class ), resultSet.getObject("r.name", String.class)))
                .build();
    }

}
