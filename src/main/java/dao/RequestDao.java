package dao;

import bean.Request;
import bean.StatusRequest;
import bean.TypeTransport;
import bean.User;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestDao implements Dao <Integer, Request> {

    private static final RequestDao INSTANCE = new RequestDao();

    private static final String GET_ALL_REQUEST_BY_USERID =
            "SELECT * FROM requests WHERE user_id = ?";

    private RequestDao() {
    }

    @Override
    public List<Request> findAll() {
        return null;
    }

    @Override
    public Optional<Request> findById(Integer id) {
        return Optional.empty();
    }

    public List<Request> findAllByUserId(Integer userId) {
        List<Request> requests = new ArrayList<>();

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_REQUEST_BY_USERID)) {
            preparedStatement.setObject(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                requests.add(buildEntityById(resultSet));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

        @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Request entity) {

    }

    @Override
    public Request save(Request entity) {
        return null;
    }

    public static RequestDao getInstance() {
        return INSTANCE;
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
}
