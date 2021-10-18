package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

public interface DriversRequestsService {

    boolean save(Integer driverId, Integer requestId) throws ServiceException, DAOException;
}
