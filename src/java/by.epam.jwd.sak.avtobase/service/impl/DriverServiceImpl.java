package by.epam.jwd.sak.avtobase.service.impl;


import by.epam.jwd.sak.avtobase.bean.Driver;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.DriverDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.DriverService;
import by.epam.jwd.sak.avtobase.service.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DriverServiceImpl implements DriverService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public boolean delete(Integer id) throws ServiceException {
        try {
            return daoFactory.getDriverDao().delete(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public List<DriverDto> findAllDriver() throws ServiceException {
        try {
            return daoFactory.getDriverDao().findAll().stream().map(this::convertToDriverDto).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Integer create(DriverDto driverDto) throws ServiceException {
        Driver driverBean = convertToDriver(driverDto);
        try {
            daoFactory.getDriverDao().save(driverBean);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return driverBean.getId();
    }

    @Override
    public Optional<DriverDto> findById(Integer id) throws ServiceException {
        try {
            return daoFactory.getDriverDao().findById(id).map(this::convertToDriverDto);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    private DriverDto convertToDriverDto(Driver driver) { //TODO
        return DriverDto.builder()
                .id(driver.getId())
                .doctorStamp(driver.getDoctorStamp())
/*              .startAddress(request.getStartAddress())
                .endAddress(request.getEndAddress())
                .dateDeparture(request.getDateDeparture())
                .statusRequest(request.getStatusRequest())
                .typeTransport(request.getTypeTransport())
                .detailsRequest(request.getDetailsRequest())*/
                .build();
    }

    private Driver convertToDriver(DriverDto driverDto) {
        return Driver.builder()
                .user(Mapper.convertToUser(driverDto.getUserDto()))
                .doctorStamp(driverDto.getDoctorStamp())
                .build();
    }
}
