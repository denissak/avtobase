package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.dao.CarDao;
import by.epam.jwd.sak.avtobase.dto.CarDto;

import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.entity.Car;
import by.epam.jwd.sak.avtobase.entity.StatusCar;
import by.epam.jwd.sak.avtobase.entity.TypeTransport;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.reflect.internal.WhiteboxImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CarServiceImplTest {

    private CarDao carDao;
    private CarService carService = new CarServiceImpl();
    private CarDto carDto;
    private List<Car> carList = new ArrayList<>();
    private Car car;

    @BeforeEach
    void prepare() {
        carDao = Mockito.mock(CarDao.class);
        WhiteboxImpl.setInternalState(carService, "carDao", carDao);
        carDto = CarDto.builder()
                .id(1L)
                .userDto(UserDto.builder()
                        .id(1L)
                        .login("admin123")
                        .name("Denis")
                        .surname("Sak")
                        .password("Zz123")
                        .phoneNumber("+375294561221")
                        .build())
                .mark("volvo")
                .model("123")
                .releaseDate(LocalDate.now())
                .typeTransport(TypeTransport.FREIGHT)
                .liftingCapacity(21)
                .cargoCapacity(12)
                .passengerCapacity(0)
                .inspectionPermission(LocalDate.now())
                .statusCar(StatusCar.READY)
                .carDescription("Best car")
                .build();
        carList.add(Car.builder()
                .id(1L)
                .mark("volvo")
                .model("123")
                .releaseDate(LocalDate.now())
                .typeTransport(TypeTransport.PASSENGER)
                .liftingCapacity(0)
                .cargoCapacity(0)
                .passengerCapacity(20)
                .inspectionPermission(LocalDate.now())
                .statusCar(StatusCar.READY)
                .carDescription("Best car")
                .build());
        carList.add(Car.builder()
                .id(1L)
                .mark("volvo")
                .model("123")
                .releaseDate(LocalDate.now())
                .typeTransport(TypeTransport.FREIGHT)
                .liftingCapacity(21)
                .cargoCapacity(12)
                .passengerCapacity(0)
                .inspectionPermission(LocalDate.now())
                .statusCar(StatusCar.BROKEN)
                .carDescription("Best car")
                .build());
        car = Car.builder()
                .id(1L)
                .mark("volvo")
                .model("123")
                .releaseDate(LocalDate.now())
                .typeTransport(TypeTransport.FREIGHT)
                .liftingCapacity(21)
                .cargoCapacity(12)
                .passengerCapacity(0)
                .inspectionPermission(LocalDate.now())
                .statusCar(StatusCar.READY)
                .carDescription("Best car")
                .build();
    }

    @Test
    void testShowAllFreeDriver () throws ServiceException, DAOException {
        Mockito.doReturn(carList).when(carDao).findAllFreeDriver();
        var allFreeDriverResult = carService.findAllFreeDriver();
        assertEquals(2, allFreeDriverResult.size());
    }

    @Test
    void testShowAllCar () throws ServiceException, DAOException {
        Mockito.doReturn(carList).when(carDao).findAll();
        var allCarResult = carService.findAllCar();
        assertEquals(2, allCarResult.size());
    }

    @Test
    void testUpdateCar () throws ServiceException, DAOException {
        Mockito.doReturn(true).when(carDao).update(Mockito.any());
        var updateResult = carService.update(carDto);
        assertThat(updateResult).isTrue();
    }


    @Test
    void testAddDriverOnCar () throws ServiceException, DAOException{
        Mockito.doReturn(true).when(carDao).addDriver(Mockito.any(), Mockito.any());
        var addResult = carService.addDriver(carDto.getId(), carDto.getUserDto().getId());
        assertThat(addResult).isTrue();
    }

    @Test
    void testDeleteCar() throws ServiceException, DAOException {
        Mockito.doReturn(true).when(carDao).delete(Mockito.any());
        var deleteResult = carService.delete(carDto.getId());
        assertThat(deleteResult).isTrue();
    }

    @Test
    void testUpdateStatusById () throws ServiceException, DAOException{
        Mockito.doReturn(true).when(carDao).updateStatusById(Mockito.any(), Mockito.any());
        var updateStatusResult = carService.updateStatusById(carDto.getId(), carDto.getStatusCar().name());
        assertThat(updateStatusResult).isTrue();
    }

    @Test
    void testCreateCar() throws ServiceException, DAOException {
        Mockito.doReturn(true).when(carDao).save(Mockito.any());
        var saveResult = carService.create(carDto);
        assertThat(saveResult).isTrue();
    }



}
