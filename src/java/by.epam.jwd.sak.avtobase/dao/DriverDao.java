package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.bean.Driver;
import by.epam.jwd.sak.avtobase.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface DriverDao {

    Optional<Driver> findById(Integer id) throws DAOException;

    List<Driver> findAll() throws DAOException;

    Driver save(Driver entity) throws DAOException;
}
