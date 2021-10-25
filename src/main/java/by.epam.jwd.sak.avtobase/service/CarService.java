package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.CarDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarDto> findAllCar() throws ServiceException;

    List<CarDto> findAllFreeDriver() throws ServiceException;

    Long create (CarDto carDto) throws ServiceException;

    Optional<CarDto> findById(Long id) throws ServiceException;

    boolean delete(Long id) throws ServiceException;

    boolean addDriver(Long driverId, Long carId) throws ServiceException;

    Long update (CarDto entity) throws ServiceException;
}
