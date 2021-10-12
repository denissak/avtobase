package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface RequestService {

    List<RequestDto> findAllRequestByUser (Integer userId) throws ServiceException;

    Integer create (RequestDto requestDto) throws ServiceException;

    Optional<RequestDto> findById (Integer id) throws ServiceException;
}
