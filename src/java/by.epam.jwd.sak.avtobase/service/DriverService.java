package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.DriverDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface DriverService {

    List<DriverDto> findAllDriver () throws ServiceException;

    Integer create (DriverDto driverDto) throws ServiceException;

    Optional<DriverDto> findById (Integer id) throws ServiceException;

    boolean delete (Integer id) throws ServiceException;

}
