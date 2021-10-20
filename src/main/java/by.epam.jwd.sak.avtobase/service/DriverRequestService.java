package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.exception.ServiceException;

public interface DriverRequestService {

    boolean save(Integer driverId, Integer requestId) throws ServiceException;
}
