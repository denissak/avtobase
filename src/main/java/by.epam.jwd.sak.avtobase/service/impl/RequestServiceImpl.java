package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.bean.Request;
import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.Mapper;
import by.epam.jwd.sak.avtobase.service.RequestService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RequestServiceImpl implements RequestService {



    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<RequestDto> findAllRequest() throws ServiceException {
        try {
            return daoFactory.getRequestDao().findAll().stream().map(this::convertToRequestDto).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public boolean delete(Integer id) throws ServiceException {
        try {
            return daoFactory.getRequestDao().delete(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Integer update(RequestDto requestDto) throws ServiceException {
        Request requestBean = convertToRequest(requestDto);
        try {
            daoFactory.getRequestDao().update(requestBean);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return requestBean.getId();
    }

    @Override
    public boolean updateStatusById(Integer id, String status) throws ServiceException {
        try {
            return daoFactory.getRequestDao().updateStatusById(id, status);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Optional<RequestDto> findById(Integer id) throws ServiceException {
        try {
            return daoFactory.getRequestDao().findById(id).map(this::convertToRequestDto);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Integer create(RequestDto requestDto) throws ServiceException {
        Request requestBean = convertToRequest(requestDto);
        try {
            daoFactory.getRequestDao().save(requestBean);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return requestBean.getId();
    }

    @Override
    public List<RequestDto> findAllRequestByUser (Integer userId) throws ServiceException {
        try {
            return daoFactory.getRequestDao().findAllByUserId(userId).stream()
                    .map(this::convertToRequestDto).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException();
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
