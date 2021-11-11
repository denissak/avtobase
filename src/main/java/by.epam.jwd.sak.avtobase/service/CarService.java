package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.CarDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.util.List;

public interface CarService {

    List<CarDto> findAllCar() throws ServiceException;

    List<CarDto> findAllFreeDriver() throws ServiceException;

    boolean create(CarDto carDto) throws ServiceException;

    CarDto findByUserId(Long id) throws ServiceException;

    CarDto findById(Long id) throws ServiceException;

    boolean delete(Long id) throws ServiceException;

    boolean addDriver(Long driverId, Long carId) throws ServiceException;

    boolean update(CarDto entity) throws ServiceException;

    boolean updateStatusById(Long id, String status) throws ServiceException;
}
