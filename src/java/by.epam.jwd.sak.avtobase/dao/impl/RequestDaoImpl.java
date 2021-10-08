package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Request;
import by.epam.jwd.sak.avtobase.bean.StatusRequest;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dao.RequestDao;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class RequestDaoImpl implements RequestDao {

    private static final String GET_ALL_REQUEST_BY_USERID = "SELECT * FROM requests WHERE user_id = ?";
    private static final String SAVE_REQUEST = "SELECT * FROM requests";

    @Override
    public Request save(Request entity) {
        try (Connection connection = ConnectionManager.get();
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_REQUEST, RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, entity.getUser().getId());
            preparedStatement.setObject(2 , entity.getDateDeparture().toLocalDate());
            preparedStatement.setObject(3, entity.getStartAddress());
            preparedStatement.setObject(4, entity.getEndAddress());
            preparedStatement.setObject(5, entity.getDateDeparture());
            preparedStatement.setObject(6, StatusRequest.PROCESSING);
            preparedStatement.setObject(7, entity.getTypeTransport());
            preparedStatement.setObject(8, entity.getDetailsRequest());
            preparedStatement.executeUpdate();

            preparedStatement.executeQuery();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

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
