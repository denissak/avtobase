package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.dao.RequestDao;
import by.epam.jwd.sak.avtobase.entity.Request;
import by.epam.jwd.sak.avtobase.entity.User;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.Mapper;
import by.epam.jwd.sak.avtobase.service.RequestService;
import by.epam.jwd.sak.avtobase.service.validator.RequestValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Provides access to {@link RequestDao} and support for working with entities
 * {@link Request}.
 */

public class RequestServiceImpl implements RequestService {

    private static final Logger LOGGER = LogManager.getLogger();
    private final RequestDao requestDao = DaoFactory.getInstance().getRequestDao();


    /**
     * Add driver in request.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean addDriverOnRequest(Long carId, Long requestId) throws ServiceException {
        try {
            return requestDao.addDriverOnRequest(carId, requestId);
        } catch (DAOException e) {
            LOGGER.error("Add driver on request error service", e);
            throw new ServiceException("Add driver on request error service", e);
        }
    }

    /**
     * Search all requests.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public List<RequestDto> findAllRequest() throws ServiceException {
        try {
            return requestDao.findAll().stream().map(this::convertToRequestDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error("Find all requests error service", e);
            throw new ServiceException("Find all requests error service", e);
        }
    }

    /**
     * Delete request.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean delete(Long id) throws ServiceException {
        try {
            return requestDao.delete(id);
        } catch (DAOException e) {
            LOGGER.error("Delete request error service", e);
            throw new ServiceException("Delete request error service", e);
        }
    }

    /**
     * Update request.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean update(RequestDto requestDto) throws ServiceException {
        if (requestDto == null || !(RequestValidation.isRequestValid(requestDto))) {
            return false;
        }
        Request requestBean = convertToRequest(requestDto);
        try {
            requestDao.update(requestBean);
        } catch (DAOException e) {
            LOGGER.error("Update request error service", e);
            throw new ServiceException("Update request error service", e);
        }
        return true;
    }

    /**
     * Update status request by request id.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean updateStatusById(Long id, String status) throws ServiceException {
        try {
            return requestDao.updateStatusById(id, status);
        } catch (DAOException e) {
            LOGGER.error("Update status request by id error service", e);
            throw new ServiceException("Update status request by id error service", e);
        }
    }

    /**
     * Find request by id.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public Optional<RequestDto> findById(Long id) throws ServiceException {
        try {
            return requestDao.findById(id).map(this::convertToRequestDto);
        } catch (DAOException e) {
            LOGGER.error("Find request by id error service", e);
            throw new ServiceException("Find request by id error service", e);
        }
    }

    /**
     * Create request.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public boolean create(RequestDto requestDto) throws ServiceException {
        if (requestDto == null || !(RequestValidation.isRequestValid(requestDto))) {
            return false;
        }
        Request requestBean = convertToRequest(requestDto);
        try {
            requestDao.save(requestBean);
        } catch (DAOException e) {
            LOGGER.error("Create request error service",e );
            throw new ServiceException("Create request error service", e);
        }
        return true;
    }

    /**
     * Search all requests by car id.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public List<RequestDto> findAllByCarId(Long carId) throws ServiceException {
        try {
            return requestDao.findAllByCarId(carId).stream()
                    .map(this::convertToRequestDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error("Find all requests by car id error service", e);
            throw new ServiceException("Find all requests by car id error service", e);
        }
    }

    /**
     * Search all requests by user id.
     *
     * @throws ServiceException If problem occurs during interaction with DAO-layer.
     */

    @Override
    public List<RequestDto> findAllRequestByUser(Long userId) throws ServiceException {
        try {
            return requestDao.findAllByUserId(userId).stream()
                    .map(this::convertToRequestDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error("Find all request by user id error service", e);
            throw new ServiceException("Find all request by user id error service", e);
        }
    }

    private RequestDto convertToRequestDto(Request request) {
        UserDto userDto = new UserDto();
        if (request.getUser() != null) {
            userDto = Mapper.convertToUserDto(request.getUser());
        }
        return RequestDto.builder()
                .id(request.getId())
                .userDto(userDto)
                .dateCreate(request.getDateCreate())
                .startAddress(request.getStartAddress())
                .endAddress(request.getEndAddress())
                .dateDeparture(request.getDateDeparture())
                .statusRequest(request.getStatusRequest())
                .typeTransport(request.getTypeTransport())
                .detailsRequest(request.getDetailsRequest())
                .build();
    }

    private Request convertToRequest(RequestDto requestDto) {
        User user = new User();
        if (requestDto.getUserDto() != null) {
            user = Mapper.convertToUser(requestDto.getUserDto());
        }
        return Request.builder()
                .id(requestDto.getId())
                .user(user)
                .dateCreate(LocalDateTime.now())
                .startAddress(requestDto.getStartAddress())
                .endAddress(requestDto.getEndAddress())
                .dateDeparture(requestDto.getDateDeparture())
                .statusRequest(requestDto.getStatusRequest())
                .typeTransport(requestDto.getTypeTransport())
                .detailsRequest(requestDto.getDetailsRequest())
                .build();
    }

}
