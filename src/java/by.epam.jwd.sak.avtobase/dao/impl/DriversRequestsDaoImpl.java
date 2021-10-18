package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.DriversRequests;
import by.epam.jwd.sak.avtobase.dao.DriversRequestsDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class DriversRequestsDaoImpl implements DriversRequestsDao {

    private static final String SAVE_USER = "INSERT INTO drivers_requests (request_id, user_id)" +
            " VALUES " + "(?,?)";

    @Override
    public boolean save(Integer driverId, Integer requestId) throws DAOException {
        int result;
        try {
            try (Connection connection = ConnectionManager.get();
                 PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER, RETURN_GENERATED_KEYS)) {
                preparedStatement.setObject(1, requestId);
                preparedStatement.setObject(2, driverId);
                result = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return result==1;
    }
}
