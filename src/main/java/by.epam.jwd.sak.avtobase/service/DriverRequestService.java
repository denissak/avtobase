package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.DriverRequestDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.util.List;

public interface DriverRequestService {

    boolean save(Long driverId, Long requestId) throws ServiceException;

    List<DriverRequestDto> findAllRequestByDriver(Long driverId) throws ServiceException;
}
