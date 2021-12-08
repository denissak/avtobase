package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.dto.CarDto;

import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;


class CarServiceImplTest {

    private FactoryService factoryService = FactoryService.getInstance();

    @Test
    void carsEmptyIfNoCarAdded() throws ServiceException {

        List<CarDto> cars = factoryService.getCarService().findAllCar();
        assertFalse(cars.isEmpty());
    }
}
