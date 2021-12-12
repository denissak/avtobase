package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.dao.CarDao;
import by.epam.jwd.sak.avtobase.entity.Car;
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

import java.util.List;
import java.util.stream.Collectors;


/**
 * Provides access to {@link CarDao} and support for working with entities
 * {@link Car}.
 */

public class CarServiceImpl implements CarService {

    private static final Logger LOGGER = LogManager.getLogger();
    private final CarDao carDao = DaoFactory.getInstance().getCarDao();

    /**
     * Search all free drivers.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public List<CarDto> findAllFreeDriver() throws ServiceException {
        try {
            return carDao.findAllFreeDriver().stream().map(this::convertToCarDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error("Find all free drivers error service", e);
            throw new ServiceException("Find all free drivers error service", e);
        }
    }

    /**
     * Update car's fields.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean update(CarDto carDto) throws ServiceException {
        if (carDto == null || !(CarValidation.isCarValid(carDto))) {
            return false;
        }
        Car car = convertToCar(carDto);
        try {
            carDao.update(car);
        } catch (DAOException e) {
            LOGGER.error("Update car error service", e);
            throw new ServiceException("Update car error service", e);
        }
        return true;
    }

    /**
     * Add driver on car.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean addDriver(Long driverId, Long carId) throws ServiceException {
        try {
            return carDao.addDriver(driverId, carId);
        } catch (DAOException e) {
            LOGGER.error("Add driver on car error service", e);
            throw new ServiceException("Add driver on car error service", e);
        }
    }

    /**
     * Delete car.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean delete(Long id) throws ServiceException {
        try {
            return carDao.delete(id);
        } catch (DAOException e) {
            LOGGER.error("Delete car error service", e);
            throw new ServiceException("Delete car error service", e);
        }
    }

    /**
     * Update status car by car id.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean updateStatusById(Long id, String status) throws ServiceException {
        try {
            return carDao.updateStatusById(id, status);
        } catch (DAOException e) {
            LOGGER.error("Update status car error service", e);
            throw new ServiceException("Update status car error service", e);
        }
    }

    /**
     * Search all cars.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public List<CarDto> findAllCar() throws ServiceException {

        try {
            return carDao.findAll().stream().map(this::convertToCarDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error("Find all cars error service", e);
            throw new ServiceException("Find all cars error service", e);
        }
    }

    /**
     * Create car.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean create(CarDto carDto) throws ServiceException {
        if (carDto == null || !(CarValidation.isCarValid(carDto))) {
            return false;
        }
        Car carBean = convertToCar(carDto);
        try {
            carDao.save(carBean);
        } catch (DAOException e) {
            LOGGER.error("Create car error service", e);
            throw new ServiceException("Create car error service", e);
        }
        return true;
    }

    /**
     * Find car by user id.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public CarDto findByUserId(Long id) throws ServiceException {
        try {
            return convertToCarDto(carDao.findByUserId(id));
        } catch (DAOException e) {
            LOGGER.error("Find car by user id error service", e);
            throw new ServiceException("Find car by user id error service", e);
        }
    }

    /**
     * Find car by car id.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public CarDto findById(Long id) throws ServiceException {
        try {
            return convertToCarDto(carDao.findById(id));
        } catch (DAOException e) {
            LOGGER.error("Find car by id error service", e);
            throw new ServiceException("Find car by id error service", e);
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
