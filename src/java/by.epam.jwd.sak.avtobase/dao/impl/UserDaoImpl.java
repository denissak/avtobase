package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Role;
import by.epam.jwd.sak.avtobase.bean.User;

import by.epam.jwd.sak.avtobase.dao.UserDao;
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

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
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
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public User save(User entity)  {
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
            e.printStackTrace();
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
