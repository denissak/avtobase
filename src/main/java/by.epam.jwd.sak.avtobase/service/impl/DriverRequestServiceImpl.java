package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.bean.Comment;
import by.epam.jwd.sak.avtobase.bean.DriverRequest;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.DriverRequestDto;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.DriverRequestService;
import by.epam.jwd.sak.avtobase.service.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class DriverRequestServiceImpl implements DriverRequestService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<DriverRequestDto> findAllRequestByDriver(Integer driverId) throws ServiceException {
        try {
            return daoFactory.getDriversRequestsDao().findAllRequestByDriver(driverId).stream()
                    .map(this::convertToDriverRequestDto).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean save(Integer driverId, Integer requestId) throws ServiceException {
        try {
            return daoFactory.getDriversRequestsDao().save(driverId, requestId);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    private DriverRequestDto convertToDriverRequestDto(DriverRequest driverRequest) {
        UserDto userDto = new UserDto();
        RequestDto requestDto;/* = new RequestDto();*/
/*        if (driverRequest.getDriver() != null) {
            userDto = Mapper.convertToUserDto(driverRequest.getDriver());
            requestDto = Mapper.convertToRequestDto(driverRequest.getRequest());
        }*/
        requestDto = Mapper.convertToRequestDto(driverRequest.getRequest());

        return DriverRequestDto.builder()
                .userDto(userDto)
                .requestDto(requestDto)
                .build();
    }
}
