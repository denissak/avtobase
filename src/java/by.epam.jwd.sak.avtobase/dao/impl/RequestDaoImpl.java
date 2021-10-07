package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Request;
import by.epam.jwd.sak.avtobase.bean.StatusRequest;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dao.RequestDao;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDaoImpl implements RequestDao {

    private static final String GET_ALL_REQUEST_BY_USERID =
            "SELECT * FROM requests WHERE user_id = ?";


    @Override
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
