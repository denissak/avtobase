package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.exception.DAOException;

public interface DriversRequestsDao {

    boolean save(Integer driverId, Integer requestId) throws DAOException;
}
