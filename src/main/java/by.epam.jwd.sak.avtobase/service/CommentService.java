package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.CommentDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.util.List;

public interface CommentService {

    List<CommentDto> findAllComment() throws ServiceException;

    boolean create(CommentDto commentDto) throws ServiceException;

    boolean delete(Long id) throws ServiceException;

    List<CommentDto> findAllCommentByUser(Long userId) throws ServiceException;
}
