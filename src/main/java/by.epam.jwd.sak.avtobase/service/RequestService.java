package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface RequestService {

    List<RequestDto> findAllByCarId(Long carId) throws ServiceException;

    List<RequestDto> findAllRequestByUser(Long userId) throws ServiceException;

    List<RequestDto> findAllRequest() throws ServiceException;

    boolean create(RequestDto requestDto) throws ServiceException;

    boolean addDriverOnRequest(Long carId, Long requestId) throws ServiceException;

    Optional<RequestDto> findById(Long id) throws ServiceException;

    boolean update(RequestDto entity) throws ServiceException;

    boolean updateStatusById(Long id, String status) throws ServiceException;

    boolean delete(Long id) throws ServiceException;
}
