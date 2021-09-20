import dao.AddressDao;
import dao.RouteDao;
import service.RouteService;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Class<Driver> driverClass = Driver.class;
        try (var connection = ConnectionManager.get()){
            System.out.println(connection.getTransactionIsolation());
//            connection = open();
            //AddressDao addressDao = new AddressDao();
            //addressDao.findAll();
            RouteService routeService = RouteService.getInstance();
            routeService.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
