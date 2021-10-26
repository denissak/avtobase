package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.bean.Car;
import by.epam.jwd.sak.avtobase.exception.DAOException;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface CarDao {

    Car findByUserId(Long id) throws DAOException;

    Car findById(Long id) throws DAOException;

    List<Car> findAll() throws DAOException;

    List<Car> findAllFreeDriver() throws DAOException;

    Car save(Car entity) throws DAOException;

    boolean delete(Long id) throws DAOException;

    boolean addDriver(Long driverId, Long carId) throws DAOException;

    boolean update(Car entity) throws DAOException;
}
