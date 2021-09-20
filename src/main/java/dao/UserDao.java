package dao;

import bean.User;
import util.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDao implements Dao<Integer, User>{

    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE_USER = "INSERT INTO users (login, password, role_id, name, surname, phone_number)" +
            " VALUES " + "(?,?,?,?,?,?)";

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public User save(User entity)  {
        try {
            try (Connection connection = ConnectionManager.get();
                 PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER, RETURN_GENERATED_KEYS)) {
                preparedStatement.setObject(1, entity.getLogin());
                preparedStatement.setObject(2, entity.getPassword());
                preparedStatement.setObject(3, entity.getRole().getName());
                preparedStatement.setObject(4, entity.getName());
                preparedStatement.setObject(5, entity.getSurname());
                preparedStatement.setObject(6, entity.getPhone_number());

                preparedStatement.executeQuery();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                generatedKeys.next();
                entity.setId(generatedKeys.getObject("id", Integer.class));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
