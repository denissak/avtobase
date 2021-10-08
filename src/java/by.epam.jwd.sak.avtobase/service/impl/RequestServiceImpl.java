package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.bean.Request;
import by.epam.jwd.sak.avtobase.bean.StatusRequest;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.RequestCreateDto;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.service.RequestService;
import by.epam.jwd.sak.avtobase.util.LocalDateTimeFormatter;

import java.util.List;
import java.util.stream.Collectors;

public class RequestServiceImpl implements RequestService{

    private final DaoFactory daoFactory = DaoFactory.getInstance();


    @Override
    public Integer create(RequestCreateDto requestCreateDto) {
        Request requestBean = convertToRequest(requestCreateDto);
        daoFactory.getRequestDao().save(requestBean);
        return requestBean.getId();
    }

    @Override
    public List<RequestDto> findAllRequestByUser (Integer userId){
        return daoFactory.getRequestDao().findAllByUserId(userId).stream()
                .map(this::convertToRequestDto).collect(Collectors.toList());
    }

    private RequestDto convertToRequestDto(Request object) {
        return RequestDto.builder()
                .id(object.getId())
                .dateCreate(object.getDateCreate())
                .startAddress(object.getStartAddress())
                .endAddress(object.getEndAddress())
                .dateDeparture(object.getDateDeparture())
                .statusRequest(object.getStatusRequest())
                .typeTransport(object.getTypeTransport())
                .detailsRequest(object.getDetailsRequest())
                .build();
    }

    private Request convertToRequest(RequestCreateDto object) {
        return Request.builder()
                .id(Integer.valueOf(object.getId()))
                //.user(object.getUser())
                .dateCreate(LocalDateTimeFormatter.format(object.getDateCreate()))
                .startAddress(object.getStartAddress())
                .endAddress(object.getEndAddress())
                .dateDeparture(LocalDateTimeFormatter.format(object.getDateDeparture()))
                .statusRequest(StatusRequest.valueOf(object.getStatusRequest()))
                .typeTransport(TypeTransport.valueOf(object.getTypeTransport()))
                .detailsRequest(object.getDetailsRequest())
                .build();
    }

}
