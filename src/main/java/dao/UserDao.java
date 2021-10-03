package dao;

import bean.Role;
import bean.User;
import util.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDao implements Dao<Integer, User>{

    private static final UserDao INSTANCE = new UserDao();
    private static final int USER_ROLE_ID = 4;

    private static final String SAVE_USER = "INSERT INTO users (login, password, role_id, name, surname, phone_number)" +
            " VALUES " + "(?,?,?,?,?,?)";
    private static final String GET_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users as u join roles as r on r.id = u.role_id WHERE login = ? AND password = ?";


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
                preparedStatement.setObject(3, USER_ROLE_ID);
                preparedStatement.setObject(4, entity.getName());
                preparedStatement.setObject(5, entity.getSurname());
                preparedStatement.setObject(6, entity.getPhoneNumber());
                preparedStatement.executeUpdate();

/*                preparedStatement.executeQuery();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                generatedKeys.next();
                entity.setId(generatedKeys.getObject("id", Integer.class));*/

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
