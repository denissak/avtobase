package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.entity.Role;
import by.epam.jwd.sak.avtobase.dao.RolesDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.dao.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.epam.jwd.sak.avtobase.dao.daoMapping.Mapping.*;

public class RolesDaoImpl implements RolesDao {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String GET_ALL_ROLE = "SELECT * FROM roles";

    @Override
    public List<Role> findAll() throws DAOException {
        List<Role> roles = new ArrayList<>();
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ROLE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                roles.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Find all roles error DAO", e);
            throw new DAOException("Find all roles error DAO", e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return roles;
    }

    private Role buildEntity(ResultSet resultSet) throws SQLException {
        return Role.builder()
                .id(resultSet.getObject(ID, Long.class))
                .name(resultSet.getObject(NAME, String.class))
                .build();
    }
}
