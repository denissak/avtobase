package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.RequestDto;

import java.util.List;

public interface RequestService {

    List<RequestDto> findAllRequestByUser (Integer userId);

    Integer create (RequestDto requestDto);
}
