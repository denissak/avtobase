package dao;

import bean.Address;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressDao implements Dao<Integer, Address>{

    private static final AddressDao INSTANCE = new AddressDao();

    private static final String FIND_ALL = "SELECT id, country, city, street, building_number FROM  addresses";

    private AddressDao() {
    }

    @Override
    public List<Address> findAll() {
        try (Connection connection = ConnectionManager.get();
                 PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)){
                 ResultSet resultSet = preparedStatement.executeQuery();
                 List<Address> addresses = new ArrayList<>();
                 while (resultSet.next()){
                     addresses.add(buildAddress(resultSet));
                 }

            return addresses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<Address> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Address entity) {

    }

    @Override
    public Address save(Address entity) {
        return null;
    }

    public static AddressDao getInstance() {
        return INSTANCE;
    }

    private Address buildAddress(ResultSet resultSet) throws SQLException {
        return new Address(
                resultSet.getObject("id", Integer.class),
                resultSet.getObject("country", String.class),
                resultSet.getObject("city", String.class),
                resultSet.getObject("street", String.class),
                resultSet.getObject("building_number", Integer.class)
        );
    }
}
