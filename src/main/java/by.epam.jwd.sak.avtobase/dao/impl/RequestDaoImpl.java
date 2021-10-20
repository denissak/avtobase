package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Request;
import by.epam.jwd.sak.avtobase.bean.Role;
import by.epam.jwd.sak.avtobase.bean.StatusRequest;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dao.RequestDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class RequestDaoImpl implements RequestDao {

    private static final String GET_ALL_REQUEST_BY_USER_ID = "SELECT * FROM requests WHERE user_id = ?";
    private static final String GET_ALL_REQUEST = "SELECT * FROM requests as r join users as u  on u.id = r.user_id";
    private static final String SAVE_REQUEST = "INSERT INTO requests (user_id, date_create, start_address, end_address, date_departure, status_request, type_transport, details_request) VALUES (?,?,?,?,?,?,?,?)";
    private static final String GET_REQUEST_BY_ID = "SELECT * FROM requests WHERE id = ?";
    private static final String UPDATE_REQUEST = "UPDATE requests SET start_address = ?, end_address = ?, date_departure = ?, status_request = ?, type_transport = ?, details_request = ? WHERE id = ?";
    private static final String UPDATE_STATUS = "UPDATE requests SET status_request = ? WHERE id = ?";
    private static final String DELETE_REQUEST = "DELETE FROM requests WHERE id = ?";

    @Override
    public List<Request> findAll() throws DAOException {
        List<Request> requests = new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_REQUEST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                requests.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return requests;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        int result;

            try (Connection connection = ConnectionManager.get();
                 PreparedStatement preparedStatement = connection.prepareStatement(DELETE_REQUEST, RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, id);
                result = preparedStatement.executeUpdate();
            }
        catch (SQLException e) {
            throw new DAOException();
        }
        return result==1;
    }

    @Override
    public Request update(Request entity) throws DAOException {


            try (Connection connection = ConnectionManager.get();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REQUEST, RETURN_GENERATED_KEYS)) {
                preparedStatement.setObject(1, entity.getStartAddress());
                preparedStatement.setObject(2, entity.getEndAddress());
                preparedStatement.setObject(3, entity.getDateDeparture());
                preparedStatement.setObject(4, entity.getStatusRequest().name());
                preparedStatement.setObject(5, entity.getTypeTransport().name());
                preparedStatement.setObject(6, entity.getDetailsRequest());
                preparedStatement.setObject(7, entity.getId());
                preparedStatement.executeUpdate();
            }
        catch (SQLException e) {
            throw new DAOException();
        }
        return entity;
    }

    @Override
    public boolean updateStatusById(Integer id, String status) throws DAOException {
        int result;
        try (Connection connection = ConnectionManager.get();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS, RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, status);
                preparedStatement.setInt(2, id);
                result = preparedStatement.executeUpdate();
            }
        catch (SQLException e) {
            throw new DAOException();
        }
        return result==1;
    }

    @Override
    public Optional<Request> findById(Integer id) throws DAOException {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_REQUEST_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Request request = null;
            if (resultSet.next()) {
                request = buildEntityById(resultSet);
            }
            return Optional.ofNullable(request);
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    @Override
    public Request save(Request entity) throws DAOException {
        try (Connection connection = ConnectionManager.get();
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_REQUEST, RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, entity.getUser().getId());
            preparedStatement.setObject(2, entity.getDateCreate());
            preparedStatement.setObject(3, entity.getStartAddress());
            preparedStatement.setObject(4, entity.getEndAddress());
            preparedStatement.setObject(5, entity.getDateDeparture());
            preparedStatement.setObject(6, StatusRequest.PROCESSING.name());
            preparedStatement.setObject(7, entity.getTypeTransport().name());
            preparedStatement.setObject(8, entity.getDetailsRequest());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException();
        }
        return entity;
    }

    @Override
    public List<Request> findAllByUserId(Integer userId) throws DAOException {
        List<Request> requests = new ArrayList<>();

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_REQUEST_BY_USER_ID)) {
            preparedStatement.setObject(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                requests.add(buildEntityById(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return requests;
    }

    private Request buildEntityById(ResultSet resultSet) throws SQLException {

        return Request.builder()
                .id(resultSet.getObject("id", Integer.class))
                .dateCreate(resultSet.getObject("date_create", Timestamp.class).toLocalDateTime())
                .startAddress(resultSet.getObject("start_address", String.class))
                .endAddress(resultSet.getObject("end_address", String.class))
                .dateDeparture(resultSet.getObject("date_departure", Timestamp.class).toLocalDateTime())
                .statusRequest(StatusRequest.valueOf(resultSet.getObject("status_request", String.class)))
                .typeTransport(TypeTransport.valueOf(resultSet.getObject("type_transport", String.class)))
                .detailsRequest(resultSet.getObject("details_request", String.class))
                .build();
    }

    private Request buildEntity (ResultSet resultSet) throws SQLException {

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
        return Request.builder()
                .id(resultSet.getObject("id", Integer.class))
                .user(user)
                .dateCreate(resultSet.getObject("date_create", Timestamp.class).toLocalDateTime())
                .startAddress(resultSet.getObject("start_address", String.class))
                .endAddress(resultSet.getObject("end_address", String.class))
                .dateDeparture(resultSet.getObject("date_departure", Timestamp.class).toLocalDateTime())
                .statusRequest(StatusRequest.valueOf(resultSet.getObject("status_request", String.class)))
                .typeTransport(TypeTransport.valueOf(resultSet.getObject("type_transport", String.class)))
                .detailsRequest(resultSet.getObject("details_request", String.class))
                .build();
    }
}
