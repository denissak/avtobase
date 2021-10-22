package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.DriverRequestDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.util.List;

public interface DriverRequestService {

    boolean save(Integer driverId, Integer requestId) throws ServiceException;

    List<DriverRequestDto> findAllRequestByDriver(Integer driverId) throws ServiceException;
}
