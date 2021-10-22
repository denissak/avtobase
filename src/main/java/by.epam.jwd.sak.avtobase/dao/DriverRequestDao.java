package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.bean.DriverRequest;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.util.List;

public interface DriverRequestDao {

    boolean save(Integer driverId, Integer requestId) throws DAOException;

    List<DriverRequest> findAllRequestByDriver(Integer driverId) throws DAOException;
}
