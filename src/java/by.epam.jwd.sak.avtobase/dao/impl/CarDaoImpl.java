package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Car;
import by.epam.jwd.sak.avtobase.bean.Role;
import by.epam.jwd.sak.avtobase.bean.StatusCar;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dao.CarDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class CarDaoImpl implements CarDao {

    private static final String SAVE_CAR = "INSERT INTO cars (user_id, mark, model, release_date, type, lifting_capacity, cargo_capacity, passenger_capacity, inspection_permission, status_car, car_description) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_CAR_BY_ID = "SELECT * FROM cars WHERE id = ?";
    private static final String GET_ALL_CAR = "SELECT * FROM cars as c join users as u on u.id = c.user_id";
    private static final String DELETE_CAR = "DELETE FROM cars WHERE id = ?";
    private static final String ADD_DRIVER = "UPDATE cars SET user_id = ? WHERE id = ?";

    @Override
    public boolean addDriver(Integer driverId) throws DAOException {
        int result;
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_DRIVER, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, driverId);
            result = preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DAOException();
        }
        return result==1;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        int result;

            try (Connection connection = ConnectionManager.get();
                 PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR, RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, id);
                result = preparedStatement.executeUpdate();
            }
        catch (SQLException e) {
            throw new DAOException();
        }
        return result==1;
    }

    @Override
    public Optional<Car> findById(Integer id) throws DAOException {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CAR_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Car car = null;
            if (resultSet.next()) {
                car = buildEntity(resultSet);
            }
            return Optional.ofNullable(car);
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    @Override
    public List<Car> findAll() throws DAOException {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CAR)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cars.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
        return cars;
    }

    @Override
    public Car save(Car entity) throws DAOException {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CAR, RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, entity.getUser().getId());
            preparedStatement.setObject(2, entity.getMark());
            preparedStatement.setObject(3, entity.getModel());
            preparedStatement.setObject(4, entity.getReleaseDate());
            preparedStatement.setObject(5, entity.getTypeTransport().name());
            preparedStatement.setObject(6, entity.getLiftingCapacity());
            preparedStatement.setObject(7, entity.getCargoCapacity());
            preparedStatement.setObject(8, entity.getPassengerCapacity());
            preparedStatement.setObject(9, entity.getInspectionPermission());
            preparedStatement.setObject(10, entity.getStatusCar().name());
            preparedStatement.setObject(11, entity.getCarDescription());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
        return entity;
    }

    private Car buildEntity(ResultSet resultSet) throws SQLException {

        Role role = new Role(
                resultSet.getObject("id", Integer.class),
                resultSet.getObject("name", String.class)
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
        return Car.builder()

                .id(resultSet.getObject("id", Integer.class))
                .user(user)
                .mark(resultSet.getObject("mark", String.class))
                .model(resultSet.getObject("model", String.class))
                .releaseDate(resultSet.getObject("release_date", Timestamp.class).toLocalDateTime())
                .typeTransport(TypeTransport.valueOf(resultSet.getObject("type", String.class)))
                .liftingCapacity(resultSet.getObject("lifting_capacity", Integer.class))
                .cargoCapacity(resultSet.getObject("cargo_capacity", Integer.class))
                .passengerCapacity(resultSet.getObject("passenger_capacity", Integer.class))
                .releaseDate(resultSet.getObject("inspection_permission", Timestamp.class).toLocalDateTime())
                .statusCar(StatusCar.valueOf(resultSet.getObject("status_car", String.class)))
                .carDescription((resultSet.getObject("car_description", String.class)))
                .build();
    }

}
