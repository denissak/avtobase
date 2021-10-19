package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.DriversRequestsService;

public class DriversRequestsServiceImpl implements DriversRequestsService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public boolean save(Integer driverId, Integer requestId) throws ServiceException {
        try {
            return daoFactory.getDriversRequestsDao().save(driverId, requestId);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
