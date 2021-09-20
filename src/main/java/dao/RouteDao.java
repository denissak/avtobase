package dao;

import bean.Route;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RouteDao implements Dao<Integer, Route> {

    private static final RouteDao INSTANCE = new RouteDao();

    private static final String FIND_ALL = "SELECT id, start_point, end_point, km_spent , hours_spent FROM  routes";

    private RouteDao() {
    }

    @Override
    public List<Route> findAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Route> routes = new ArrayList<>();
            while (resultSet.next()){
                routes.add(buildRoute(resultSet));
            }
            return routes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Route> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Route entity) {

    }

    @Override
    public Route save(Route entity) {
        return null;
    }

    public static RouteDao getInstance() {
        return INSTANCE;
    }

    private Route buildRoute(ResultSet resultSet) throws SQLException {
        return new Route(
                resultSet.getObject("id", Integer.class),
                resultSet.getObject("strart_point", Integer.class),
                resultSet.getObject("end_point", Integer.class),
                resultSet.getObject("km_spent", Integer.class),
                resultSet.getObject("hours_spent", Integer.class)

      );
    }

}
