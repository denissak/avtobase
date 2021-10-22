package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.DriverRequestDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.DriverRequestService;

import java.util.List;

public class DriverRequestServiceImpl implements DriverRequestService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<DriverRequestDto> findAllRequestByDriver(Integer driverId) throws ServiceException {
        return null;
    }

    @Override
    public boolean save(Integer driverId, Integer requestId) throws ServiceException {
        try {
            return daoFactory.getDriversRequestsDao().save(driverId, requestId);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
