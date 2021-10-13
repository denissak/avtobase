package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.bean.Car;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.CarDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.CarService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public boolean delete(Integer id) throws ServiceException {
        try {
            return daoFactory.getCarDao().delete(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public List<CarDto> findAllCar() throws ServiceException {

        try {
            return daoFactory.getCarDao().findAll().stream().map(this::convertToCarDto).collect(Collectors.toList());
        } catch (DAOException e) {
           throw new ServiceException();
        }
    }

    @Override
    public Integer create(CarDto carDto) throws ServiceException {
        Car carBean = convertToCar(carDto);
        try {
            daoFactory.getCarDao().save(carBean);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return carBean.getId();
    }

    @Override
    public Optional<CarDto> findById(Integer id) throws ServiceException {
        try {
            return daoFactory.getCarDao().findById(id).map(this::convertToCarDto);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    private CarDto convertToCarDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
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
