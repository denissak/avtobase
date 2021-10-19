package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Role;
import by.epam.jwd.sak.avtobase.dao.RolesDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolesDaoImpl implements RolesDao {

    private static final String GET_ALL_ROLE = "SELECT * FROM roles";

    @Override
    public List<Role> findAll() throws DAOException {
        List<Role> roles = new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ROLE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                roles.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return roles;
    }

    private Role buildEntity(ResultSet resultSet) throws SQLException {
        return Role.builder()
                .id(resultSet.getObject("id", Integer.class))
                .name(resultSet.getObject("name", String.class))
                .build();
    }
}
