package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.bean.Request;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.Mapper;
import by.epam.jwd.sak.avtobase.service.RequestService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RequestServiceImpl implements RequestService{

    private final DaoFactory daoFactory = DaoFactory.getInstance();

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
        return RequestDto.builder()
                .id(request.getId())
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
        return Request.builder()
                .user(Mapper.convertToUser(requestDto.getUserDto()))
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
