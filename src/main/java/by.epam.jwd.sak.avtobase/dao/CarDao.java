package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.entity.Car;
import by.epam.jwd.sak.avtobase.exception.DAOException;

import java.util.List;

public interface CarDao {

    Car findByUserId(Long id) throws DAOException;

    Car findById(Long id) throws DAOException;

    List<Car> findAll() throws DAOException;

    List<Car> findAllFreeDriver() throws DAOException;

    boolean save(Car entity) throws DAOException;

    boolean delete(Long id) throws DAOException;

    boolean addDriver(Long driverId, Long carId) throws DAOException;

    boolean update(Car entity) throws DAOException;

    boolean updateStatusById(Long id, String status) throws DAOException;
}
