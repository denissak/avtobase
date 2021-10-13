package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dao.CarDao;
import by.epam.jwd.sak.avtobase.dto.CarDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarDto> findAllCar () throws ServiceException;

    Integer create (CarDto carDto) throws ServiceException;

    Optional<CarDto> findById (Integer id) throws ServiceException;

    boolean delete (Integer id) throws ServiceException;
}
