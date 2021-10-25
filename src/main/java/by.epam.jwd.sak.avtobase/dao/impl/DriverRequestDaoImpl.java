package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.DriverRequest;
import by.epam.jwd.sak.avtobase.bean.Request;
import by.epam.jwd.sak.avtobase.bean.Role;
import by.epam.jwd.sak.avtobase.bean.StatusRequest;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dao.DriverRequestDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.epam.jwd.sak.avtobase.dao.daoMapping.Mapping.*;
import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class DriverRequestDaoImpl implements DriverRequestDao {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SAVE_USER = "INSERT INTO drivers_requests (request_id, user_id)" +
            " VALUES " + "(?,?)";

    private static final String ALL_REQUEST_BY_DRIVER = "SELECT * FROM drivers_requests as dr JOIN requests r on dr.request_id = r.id JOIN avtobase.users u on r.user_id = u.id WHERE dr.user_id = ?";


    @Override
    public List<DriverRequest> findAllRequestByDriver(Long driverId) throws DAOException {
        List<DriverRequest> requests = new ArrayList<>();
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ALL_REQUEST_BY_DRIVER)) {
            preparedStatement.setObject(1, driverId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                requests.add(buildEntityById(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e.getMessage(), e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return requests;
    }

    @Override
    public boolean save(Long driverId, Long requestId) throws DAOException {
        int result;
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, requestId);
            preparedStatement.setObject(2, driverId);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result == 1;
    }

    private DriverRequest buildEntityById(ResultSet resultSet) throws SQLException {

        Role role = new Role(

        );


        User user = new User(
                resultSet.getObject("u.id", Long.class),
                resultSet.getObject(LOGIN, String.class),
                resultSet.getObject(PASSWORD, String.class),
                resultSet.getObject(NAME, String.class),
                resultSet.getObject(SURNAME, String.class),
                resultSet.getObject(PHONE_NUMBER, String.class),
                role

        );

        Request request = new Request(

                resultSet.getObject("r.id", Long.class),
                user,
                resultSet.getObject(DATE_CREATE, Timestamp.class).toLocalDateTime(),
                resultSet.getObject(START_ADDRESS, String.class),
                resultSet.getObject(END_ADDRESS, String.class),
                resultSet.getObject(DATE_DEPARTURE, Date.class).toLocalDate(),
                StatusRequest.valueOf(resultSet.getObject(STATUS_REQUEST, String.class)),
                TypeTransport.valueOf(resultSet.getObject(TYPE_TRANSPORT, String.class)),
                resultSet.getObject(DETAIL_REQUEST, String.class)
        );

        return DriverRequest.builder()
                .driver(null)
                .request(request)
                .build();
    }
}

