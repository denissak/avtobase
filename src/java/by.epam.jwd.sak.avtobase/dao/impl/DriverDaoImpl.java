package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Car;
import by.epam.jwd.sak.avtobase.bean.Comment;
import by.epam.jwd.sak.avtobase.bean.Driver;
import by.epam.jwd.sak.avtobase.bean.Role;
import by.epam.jwd.sak.avtobase.bean.StatusCar;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dao.DriverDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class DriverDaoImpl implements DriverDao {

    private static final String SAVE_DRIVER = "INSERT INTO drivers (id, car_id, doctor_stamp, car_id) VALUES (?,?,?,?)";
    private static final String GET_DRIVER_BY_ID = "SELECT * FROM drivers as d " +
            "JOIN users as u on d.user_id = u.id\n" +
            "JOIN cars c on d.car_id = c.id\n" +
            "JOIN roles r on u.role_id = r.id WHERE u.id = ?";
    private static final String GET_ALL_DRIVER = "SELECT * FROM drivers as d " +
            "JOIN users as u on d.user_id = u.id\n" +
            "JOIN cars c on d.car_id = c.id\n" +
            "JOIN roles r on u.role_id = r.id";

    private static final String DELETE_DRIVER = "DELETE FROM drivers WHERE id = ?";

    @Override
    public boolean delete(Integer id) throws DAOException {
        int result;
        try {
            try (Connection connection = ConnectionManager.get();
                 PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DRIVER, RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, id);
                result = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return result==1;
    }

    @Override
    public Optional<Driver> findById(Integer userId) throws DAOException {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_DRIVER_BY_ID)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = buildEntity(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    @Override
    public List<Driver> findAll() throws DAOException {
        List<Driver> drivers = new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DRIVER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return drivers;
    }

    @Override
    public Driver save(Driver entity) throws DAOException {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_DRIVER, RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, entity.getUserId());
            preparedStatement.setObject(2,entity.getUserId().getId());
            preparedStatement.setObject(2, entity.getDoctorStamp());
            preparedStatement.setObject(3, entity.getCarId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException();
        }
        return entity;
    }


    private Driver buildEntity(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver(

        );
        Car car = new Car(

                resultSet.getObject("id", Integer.class),
                driver,
                resultSet.getObject("mark", String.class),
                resultSet.getObject("model", String.class),
                resultSet.getObject("release_date", Timestamp.class).toLocalDateTime(),
                TypeTransport.valueOf(resultSet.getObject("type", String.class)),
                resultSet.getObject("lifting_capacity", Integer.class),
                resultSet.getObject("date_departure", Integer.class),
                resultSet.getObject("status_request", Integer.class),
                resultSet.getObject("inspection_permission", Timestamp.class).toLocalDateTime(),
                StatusCar.valueOf(resultSet.getObject("details_request", String.class)),
                resultSet.getObject("car_description", String.class)

        );
        Role role = new Role(
                resultSet.getObject("id", Integer.class),
                resultSet.getObject("name", String.class)
        );
        Comment comment = new Comment(
/*                resultSet.getObject("id", Integer.class),
                resultSet.getObject("comment_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("mark", Integer.class),
                resultSet.getObject("message", String.class)*/
        );
        User user = new User(
                resultSet.getObject("id", Integer.class),
                resultSet.getObject("login", String.class),
                resultSet.getObject("password", String.class),
                resultSet.getObject("name", String.class),
                resultSet.getObject("surname", String.class),
                resultSet.getObject("phone_number", String.class),
                role
        );
        return Driver.builder()
                .id(resultSet.getObject("id", Integer.class))
                .user(user)
                /*.userId(resultSet.getObject("user_id", Integer.class))*/
                .doctorStamp(resultSet.getObject("doctor_stamp", Timestamp.class).toLocalDateTime())
                .car(car)
                .build();
    }

}
