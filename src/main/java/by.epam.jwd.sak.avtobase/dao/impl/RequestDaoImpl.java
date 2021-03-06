package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.entity.Request;
import by.epam.jwd.sak.avtobase.entity.Role;
import by.epam.jwd.sak.avtobase.entity.StatusRequest;
import by.epam.jwd.sak.avtobase.entity.TypeTransport;
import by.epam.jwd.sak.avtobase.entity.User;
import by.epam.jwd.sak.avtobase.dao.RequestDao;
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

/**
 * Provides methods for working with Requests table and entities {@link Request},
 */

public class RequestDaoImpl implements RequestDao {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String GET_ALL_REQUEST_BY_CAR_ID = "SELECT * FROM requests as r JOIN users as u on u.id = r.user_id WHERE car_id = ? ORDER BY r.status_request = 'COMPLETE' , r.date_departure";
    private static final String GET_ALL_REQUEST_BY_USER_ID = "SELECT * FROM requests WHERE user_id = ? ORDER BY date_departure";
    private static final String GET_ALL_REQUEST = "SELECT * FROM requests as r join users as u  on u.id = r.user_id ORDER BY r.status_request = 'COMPLETE' , r.date_departure";
    private static final String SAVE_REQUEST = "INSERT INTO requests (user_id, date_create, start_address, end_address, date_departure, status_request, type_transport, details_request) VALUES (?,?,?,?,?,?,?,?)";
    private static final String GET_REQUEST_BY_ID = "SELECT * FROM requests WHERE id = ?";
    private static final String UPDATE_REQUEST = "UPDATE requests SET start_address = ?, end_address = ?, date_departure = ?, status_request = ?, type_transport = ?, details_request = ? WHERE id = ?";
    private static final String UPDATE_STATUS = "UPDATE requests SET status_request = ? WHERE id = ?";
    private static final String DELETE_REQUEST = "DELETE FROM requests WHERE id = ?";
    private static final String ADD_DRIVER_ON_REQUEST = "UPDATE requests SET car_id = ? WHERE id = ?";

    /**
     * Add driver on request.
     *
     * @throws DAOException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean addDriverOnRequest(Long carId, Long requestId) throws DAOException {
        int result;
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_DRIVER_ON_REQUEST, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, carId);
            preparedStatement.setObject(2, requestId);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Add driver on request error DAO", e);
            throw new DAOException("Add driver on request error DAO", e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result > 0;
    }

    /**
     * Search all requests.
     *
     * @throws DAOException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public List<Request> findAll() throws DAOException {
        List<Request> requests = new ArrayList<>();
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_REQUEST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                requests.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("All requests output error DAO", e);
            throw new DAOException("All requests output error DAO", e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return requests;
    }

    /**
     * Delete request.
     *
     * @throws DAOException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean delete(Long id) throws DAOException {
        int result;
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_REQUEST, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Delete request error DAO", e);
            throw new DAOException("Delete request error DAO", e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result > 0;
    }

    /**
     * Update request's fields.
     *
     * @throws DAOException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean update(Request entity) throws DAOException {
        int result;
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REQUEST, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getStartAddress());
            preparedStatement.setObject(2, entity.getEndAddress());
            preparedStatement.setObject(3, entity.getDateDeparture());
            preparedStatement.setObject(4, entity.getStatusRequest().name());
            preparedStatement.setObject(5, entity.getTypeTransport().name());
            preparedStatement.setObject(6, entity.getDetailsRequest());
            preparedStatement.setObject(7, entity.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Update request error DAO", e);
            throw new DAOException("Update request error DAO", e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result > 0;
    }

    /**
     * Update status request by id.
     *
     * @throws DAOException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean updateStatusById(Long id, String status) throws DAOException {
        int result;
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, status);
            preparedStatement.setObject(2, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Update status request error DAO", e);
            throw new DAOException("Update status request error DAO", e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result > 0;
    }

    /**
     * Find request by id.
     *
     * @throws DAOException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public Optional<Request> findById(Long id) throws DAOException {
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_REQUEST_BY_ID)) {
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Request request = null;
            if (resultSet.next()) {
                request = buildEntityById(resultSet);
            }
            return Optional.ofNullable(request);
        } catch (SQLException e) {
            LOGGER.error("Find request by user id error DAO", e);
            throw new DAOException("Find request by user id error DAO", e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
    }

    /**
     * Save request.
     *
     * @throws DAOException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean save(Request entity) throws DAOException {
        int result;
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE_REQUEST, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getUser().getId());
            preparedStatement.setObject(2, entity.getDateCreate());
            preparedStatement.setObject(3, entity.getStartAddress());
            preparedStatement.setObject(4, entity.getEndAddress());
            preparedStatement.setObject(5, entity.getDateDeparture());
            preparedStatement.setObject(6, StatusRequest.CREATED.name());
            preparedStatement.setObject(7, entity.getTypeTransport().name());
            preparedStatement.setObject(8, entity.getDetailsRequest());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Save request error DAO", e);
            throw new DAOException("Save request error DAO", e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result > 0;
    }

    /**
     * Search all requests by user id.
     *
     * @throws DAOException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public List<Request> findAllByUserId(Long userId) throws DAOException {
        List<Request> requests = new ArrayList<>();
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_REQUEST_BY_USER_ID)) {
            preparedStatement.setObject(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                requests.add(buildEntityById(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Find all requests by user id error DAO", e);
            throw new DAOException("Find all requests by user id error DAO", e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return requests;
    }

    /**
     * Search all requests by car id.
     *
     * @throws DAOException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public List<Request> findAllByCarId(Long carId) throws DAOException {
        List<Request> requests = new ArrayList<>();
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_REQUEST_BY_CAR_ID)) {
            preparedStatement.setObject(1, carId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                requests.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Find all requests by car id error DAO", e);
            throw new DAOException("Find all requests by car id error DAO", e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return requests;
    }

    /**
     * Build entities.
     *
     * @throws DAOException If problem occurs during interaction with DAO-layer.
     */

    private Request buildEntityById(ResultSet resultSet) throws SQLException {

        return Request.builder()
                .id(resultSet.getObject(ID, Long.class))
                .dateCreate(resultSet.getObject(DATE_CREATE, Timestamp.class).toLocalDateTime())
                .startAddress(resultSet.getObject(START_ADDRESS, String.class))
                .endAddress(resultSet.getObject(END_ADDRESS, String.class))
                .dateDeparture(resultSet.getObject(DATE_DEPARTURE, Date.class).toLocalDate())
                .statusRequest(StatusRequest.valueOf(resultSet.getObject(STATUS_REQUEST, String.class)))
                .typeTransport(TypeTransport.valueOf(resultSet.getObject(TYPE_TRANSPORT, String.class)))
                .detailsRequest(resultSet.getObject(DETAIL_REQUEST, String.class))
                .build();
    }

    private Request buildEntity(ResultSet resultSet) throws SQLException {

        Role role = new Role(
                resultSet.getObject(ID, Long.class),
                resultSet.getObject(NAME, String.class)
        );

        User user = new User(
                resultSet.getObject(ID, Long.class),
                resultSet.getObject(LOGIN, String.class),
                resultSet.getObject(PASSWORD, String.class),
                resultSet.getObject(NAME, String.class),
                resultSet.getObject(SURNAME, String.class),
                resultSet.getObject(PHONE_NUMBER, String.class),
                role
        );
        return Request.builder()
                .id(resultSet.getObject(ID, Long.class))
                .user(user)
                .dateCreate(resultSet.getObject(DATE_CREATE, Timestamp.class).toLocalDateTime())
                .startAddress(resultSet.getObject(START_ADDRESS, String.class))
                .endAddress(resultSet.getObject(END_ADDRESS, String.class))
                .dateDeparture(resultSet.getObject(DATE_DEPARTURE, Date.class).toLocalDate())
                .statusRequest(StatusRequest.valueOf(resultSet.getObject(STATUS_REQUEST, String.class)))
                .typeTransport(TypeTransport.valueOf(resultSet.getObject(TYPE_TRANSPORT, String.class)))
                .detailsRequest(resultSet.getObject(DETAIL_REQUEST, String.class))
                .build();
    }
}
