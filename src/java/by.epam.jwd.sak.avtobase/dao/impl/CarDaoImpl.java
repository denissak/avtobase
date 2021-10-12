package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Car;
import by.epam.jwd.sak.avtobase.bean.StatusCar;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dao.CarDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class CarDaoImpl implements CarDao {

    private static final String SAVE_CAR = "INSERT INTO cars (mark, model, release_date, type, lifting_capacity, cargo_capacity, passenger_capacity, inspection_permission, status_car, car_description) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_CAR_BY_ID = "SELECT * FROM cars WHERE id = ?";
    private static final String GET_ALL_CAR = "SELECT * FROM cars";

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
            throw new DAOException();
        }
        return cars;
    }

    @Override
    public Car save(Car entity) throws DAOException {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CAR, RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, entity.getMark());
            preparedStatement.setObject(2, entity.getModel());
            preparedStatement.setObject(3, entity.getReleaseDate());
            preparedStatement.setObject(4, entity.getTypeTransport().name());
            preparedStatement.setObject(5, entity.getLiftingCapacity());
            preparedStatement.setObject(6, entity.getCargoCapacity());
            preparedStatement.setObject(7, entity.getPassengerCapacity());
            preparedStatement.setObject(8, entity.getInspectionPermission());
            preparedStatement.setObject(9, entity.getStatusCar().name());
            preparedStatement.setObject(10, entity.getCarDescription());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException();
        }
        return entity;
    }

    private Car buildEntity(ResultSet resultSet) throws SQLException {

        return Car.builder()

                .mark(resultSet.getObject("mark", String.class))
                .model(resultSet.getObject("model", String.class))
                .releaseDate(resultSet.getObject("release_date", Timestamp.class).toLocalDateTime())
                .typeTransport(TypeTransport.valueOf(resultSet.getObject("type", String.class)))
                .liftingCapacity(resultSet.getObject("lifting_capacity", Integer.class))
                .cargoCapacity(resultSet.getObject("date_departure", Integer.class))
                .passengerCapacity(resultSet.getObject("status_request", Integer.class))
                .releaseDate(resultSet.getObject("inspection_permission", Timestamp.class).toLocalDateTime())
                .statusCar(StatusCar.valueOf(resultSet.getObject("details_request", String.class)))
                .carDescription((resultSet.getObject("car_description", String.class)))
                .build();
    }

}
