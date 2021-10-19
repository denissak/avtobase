package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.bean.Car;
import by.epam.jwd.sak.avtobase.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface CarDao {

    Optional<Car> findById(Integer id) throws DAOException;

    List<Car> findAll() throws DAOException;

    Car save(Car entity) throws DAOException;

    boolean delete(Integer id) throws DAOException;

    boolean addDriver(Integer driverId, Integer carId) throws DAOException;

    boolean update(Car entity) throws DAOException;
}
