package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Car;
import by.epam.jwd.sak.avtobase.bean.Role;
import by.epam.jwd.sak.avtobase.bean.StatusCar;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dao.CarDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static by.epam.jwd.sak.avtobase.dao.daoMapping.Mapping.*;

public class CarDaoImpl implements CarDao {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SAVE_CAR = "INSERT INTO cars (user_id, mark, model, release_date, type, lifting_capacity, cargo_capacity, passenger_capacity, inspection_permission, status_car, car_description) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_CAR_BY_ID = "SELECT * FROM cars WHERE id = ?";
    private static final String GET_ALL_CAR = "SELECT * FROM cars as c join users as u on u.id = c.user_id";
    private static final String DELETE_CAR = "DELETE FROM cars WHERE id = ?";
    private static final String ADD_DRIVER = "UPDATE cars SET user_id = ? WHERE id = ?";
    private static final String UPDATE_CAR = "UPDATE cars SET mark = ?, model = ?, release_date = ?, release_date = ?, type = ?, lifting_capacity = ?, cargo_capacity = ?, passenger_capacity = ?, inspection_permission = ?, status_car = ?, car_description = ? WHERE id = ?";

    @Override
    public boolean update(Car entity) throws DAOException {
        int result;
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAR, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getMark());
            preparedStatement.setObject(2, entity.getModel());
            preparedStatement.setObject(3, entity.getReleaseDate());
            preparedStatement.setObject(4, entity.getTypeTransport());
            preparedStatement.setObject(5, entity.getLiftingCapacity());
            preparedStatement.setObject(6, entity.getCargoCapacity());
            preparedStatement.setObject(7, entity.getPassengerCapacity());
            preparedStatement.setObject(8, entity.getInspectionPermission());
            preparedStatement.setObject(9, entity.getStatusCar());
            preparedStatement.setObject(10, entity.getCarDescription());
            preparedStatement.setObject(11, entity.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e.getMessage(), e);
        } finally {

            ConnectionManager.returnConnection(connection);
        }
        return result == 1;
    }

    @Override
    public boolean addDriver(Integer driverId, Integer carId) throws DAOException {
        int result;
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_DRIVER, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, driverId);
            preparedStatement.setObject(2, carId);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e.getMessage(), e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result == 1;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        int result;
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR, RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result == 1;
    }

    @Override
    public Optional<Car> findById(Integer id) throws DAOException {
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CAR_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Car car = null;
            if (resultSet.next()) {
                car = buildEntity(resultSet);
            }
            return Optional.ofNullable(car);
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
    }

    @Override
    public List<Car> findAll() throws DAOException {
        List<Car> cars = new ArrayList<>();
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CAR)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cars.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e.getMessage(), e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return cars;
    }

    @Override
    public Car save(Car entity) throws DAOException {
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CAR, RETURN_GENERATED_KEYS)) {
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
            LOGGER.error(e);
            throw new DAOException(e.getMessage(), e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return entity;
    }

    private Car buildEntity(ResultSet resultSet) throws SQLException {

        Role role = new Role(
                resultSet.getObject(ID, Integer.class),
                resultSet.getObject(NAME, String.class)
        );

        User user = new User(
                resultSet.getObject(ID, Integer.class),
                resultSet.getObject(LOGIN, String.class),
                resultSet.getObject(PASSWORD, String.class),
                resultSet.getObject(NAME, String.class),
                resultSet.getObject(SURNAME, String.class),
                resultSet.getObject(PHONE_NUMBER, String.class),
                role
        );
        return Car.builder()

                .id(resultSet.getObject(ID, Integer.class))
                .user(user)
                .mark(resultSet.getObject(MARK, String.class))
                .model(resultSet.getObject(MODEL, String.class))
                .releaseDate(resultSet.getObject(RELEASE_DATE, Date.class).toLocalDate())
                .typeTransport(TypeTransport.valueOf(resultSet.getObject(TYPE, String.class)))
                .liftingCapacity(resultSet.getObject(LIFTING_CAPACITY, Integer.class))
                .cargoCapacity(resultSet.getObject(CARGO_CAPACITY, Integer.class))
                .passengerCapacity(resultSet.getObject(PASSENGER_CAPACITY, Integer.class))
                .releaseDate(resultSet.getObject(INSPECTION_PERMISSION, Date.class).toLocalDate())
                .statusCar(StatusCar.valueOf(resultSet.getObject(STATUS_CAR, String.class)))
                .carDescription((resultSet.getObject(CAR_DESCRIPTION, String.class)))
                .build();
    }

}
