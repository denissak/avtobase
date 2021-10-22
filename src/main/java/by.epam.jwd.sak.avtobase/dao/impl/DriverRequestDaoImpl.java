package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.DriverRequest;
import by.epam.jwd.sak.avtobase.dao.DriverRequestDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class DriverRequestDaoImpl implements DriverRequestDao {

    private static final String SAVE_USER = "INSERT INTO drivers_requests (request_id, user_id)" +
            " VALUES " + "(?,?)";

    private static final String ALL_REQUEST_BY_DRIVER = "SELECT * FROM drivers_requests as dr JOIN requests r on dr.request_id = r.id WHERE dr.user_id = ?";


    @Override
    public List<DriverRequest> findAllRequestByDriver(Integer driverId) throws DAOException {
        List<DriverRequest> requests = new ArrayList<>();
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ALL_REQUEST_BY_DRIVER)) {
            preparedStatement.setObject(1, driverId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                requests.add(buildEntityById(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return requests;
    }

    @Override
    public boolean save(Integer driverId, Integer requestId) throws DAOException {
        int result;
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, requestId);
            preparedStatement.setObject(2, driverId);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result == 1;
    }

    private DriverRequest buildEntityById(ResultSet resultSet) throws SQLException {

        return DriverRequest.builder()
                .driverId(resultSet.getObject("user_id", Integer.class))
                .requestsId(resultSet.getObject("request_id", Integer.class))
                .build();
    }
}

