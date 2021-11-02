package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.bean.Car;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.CarDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.CarService;
import by.epam.jwd.sak.avtobase.service.Mapper;
import by.epam.jwd.sak.avtobase.service.validator.CarValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    private static final Logger LOGGER = LogManager.getLogger();
    private final DaoFactory daoFactory = DaoFactory.getInstance();


    @Override
    public List<CarDto> findAllFreeDriver() throws ServiceException {
        try {
            return daoFactory.getCarDao().findAllFreeDriver().stream().map(this::convertToCarDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(CarDto carDto) throws ServiceException {
        if (carDto == null
                || !(CarValidation.isCorrectModel(carDto.getModel())
                || CarValidation.isCorrectMark(carDto.getMark())
                || CarValidation.isCorrectDate(String.valueOf(carDto.getReleaseDate()))
                || CarValidation.isCorrectDate(String.valueOf(carDto.getInspectionPermission()))
                || CarValidation.isCorrectCapacity(carDto.getLiftingCapacity())
                || CarValidation.isCorrectCapacity(carDto.getCargoCapacity())
                || CarValidation.isCorrectCapacity(carDto.getPassengerCapacity()))) {
            return false;
        }
        Car car = convertToCar(carDto);
        try {
            daoFactory.getCarDao().update(car);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e.getMessage(), e);
        }
        return true;
    }

    @Override
    public boolean addDriver(Long driverId, Long carId) throws ServiceException {
        try {
            return daoFactory.getCarDao().addDriver(driverId, carId);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(Long id) throws ServiceException {
        try {
            return daoFactory.getCarDao().delete(id);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateStatusById(Long id, String status) throws ServiceException {
        try {
            return daoFactory.getCarDao().updateStatusById(id, status);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<CarDto> findAllCar() throws ServiceException {

        try {
            return daoFactory.getCarDao().findAll().stream().map(this::convertToCarDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean create(CarDto carDto) throws ServiceException {
        if (carDto == null
                || !(CarValidation.isCorrectModel(carDto.getModel())
                || CarValidation.isCorrectMark(carDto.getMark())
                || CarValidation.isCorrectDate(String.valueOf(carDto.getReleaseDate()))
                || CarValidation.isCorrectDate(String.valueOf(carDto.getInspectionPermission()))
                || CarValidation.isCorrectCapacity(carDto.getLiftingCapacity())
                || CarValidation.isCorrectCapacity(carDto.getCargoCapacity())
                || CarValidation.isCorrectCapacity(carDto.getPassengerCapacity()))) {
            return false;
        }
        Car carBean = convertToCar(carDto);
        try {
            daoFactory.getCarDao().save(carBean);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e.getMessage(), e);
        }
        return true;
    }

    @Override
    public CarDto findByUserId(Long id) throws ServiceException {
        try {
            return convertToCarDto(daoFactory.getCarDao().findByUserId(id));
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public CarDto findById(Long id) throws ServiceException {
        try {
            return convertToCarDto(daoFactory.getCarDao().findById(id));
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private CarDto convertToCarDto(Car car) {
        UserDto userDto = new UserDto();
        if (car.getUser() != null) {
            userDto = Mapper.convertToUserDto(car.getUser());
        }
        return CarDto.builder()
                .id(car.getId())
                .userDto(userDto)
                .mark(car.getMark())
                .model(car.getModel())
                .releaseDate(car.getReleaseDate())
                .typeTransport(car.getTypeTransport())
                .liftingCapacity(car.getLiftingCapacity())
                .cargoCapacity(car.getCargoCapacity())
                .passengerCapacity(car.getPassengerCapacity())
                .inspectionPermission(car.getInspectionPermission())
                .statusCar(car.getStatusCar())
                .carDescription(car.getCarDescription())
                .build();
    }

    private Car convertToCar(CarDto carDto) {
        return Car.builder()
                .id(carDto.getId())
//                .user(Mapper.convertToUser(carDto.getUserDto()))
                .mark(carDto.getMark())
                .model(carDto.getModel())
                .releaseDate(carDto.getReleaseDate())
                .typeTransport(carDto.getTypeTransport())
                .liftingCapacity(carDto.getLiftingCapacity())
                .cargoCapacity(carDto.getCargoCapacity())
                .passengerCapacity(carDto.getPassengerCapacity())
                .inspectionPermission(carDto.getInspectionPermission())
                .statusCar(carDto.getStatusCar())
                .carDescription(carDto.getCarDescription())
                .build();
    }
}
