package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.CommentDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.util.List;

public interface CommentService {

    List<CommentDto> findAllComment () throws ServiceException;

    Integer create (CommentDto commentDto) throws ServiceException;
}
