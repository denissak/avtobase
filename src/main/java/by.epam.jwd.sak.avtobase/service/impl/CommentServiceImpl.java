package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.bean.Comment;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.CommentDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.CommentService;
import by.epam.jwd.sak.avtobase.service.Mapper;
import by.epam.jwd.sak.avtobase.service.validator.CommentValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CommentServiceImpl implements CommentService {

    private static final Logger LOGGER = LogManager.getLogger();
    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<CommentDto> findAllCommentByUser(Long userId) throws ServiceException {
        try {
            return daoFactory.getCommentDao().findAllByUserId(userId).stream()
                    .map(this::convertToCommentDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(Long id) throws ServiceException {
        try {
            return daoFactory.getCommentDao().delete(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<CommentDto> findAllComment() throws ServiceException {
        try {
            return daoFactory.getCommentDao().findAll().stream().map(this::convertToCommentDto).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean create(CommentDto commentDto) throws ServiceException {
        if (commentDto == null || !CommentValidation.isCorrectMark(commentDto.getMark())){
            return false;
        }
        Comment commentBean = convertToComment(commentDto);
        try {
            daoFactory.getCommentDao().save(commentBean);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return true;
    }

    private CommentDto convertToCommentDto(Comment comment) {
        UserDto userDto = new UserDto();
        if (comment.getUser() != null) {
            userDto = Mapper.convertToUserDto(comment.getUser());
        }
        return CommentDto.builder()
                .id(comment.getId())
                .userDto(userDto)
                .commentDate(comment.getCommentDate())
                .mark(comment.getMark())
                .message(comment.getMessage())
                .build();
    }

    private Comment convertToComment(CommentDto commentDto) {
        return Comment.builder()
                .id(commentDto.getId())
                .user(Mapper.convertToUser(commentDto.getUserDto()))
                .commentDate(LocalDateTime.now())
                .mark(commentDto.getMark())
                .message(commentDto.getMessage())
                .build();
    }
}
