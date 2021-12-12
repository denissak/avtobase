package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.dao.CommentDao;
import by.epam.jwd.sak.avtobase.entity.Comment;
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
    private final CommentDao commentDao = DaoFactory.getInstance().getCommentDao();

    @Override
    public List<CommentDto> findAllCommentByUser(Long userId) throws ServiceException {
        try {
            return commentDao.findAllByUserId(userId).stream()
                    .map(this::convertToCommentDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error("Find all comments by user error service", e);
            throw new ServiceException("Find all comments by user error service", e);
        }
    }

    @Override
    public boolean delete(Long id) throws ServiceException {
        try {
            return commentDao.delete(id);
        } catch (DAOException e) {
            LOGGER.error("Delete comment error service", e);
            throw new ServiceException("Delete comment error service", e);
        }
    }

    @Override
    public List<CommentDto> findAllComment() throws ServiceException {
        try {
            return commentDao.findAll().stream().map(this::convertToCommentDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error("Find all comments error service", e);
            throw new ServiceException("Find all comments error service", e);
        }
    }

    @Override
    public boolean create(CommentDto commentDto) throws ServiceException {
        if (commentDto == null || !CommentValidation.isCorrectMark(commentDto.getMark())){
            return false;
        }
        Comment commentBean = convertToComment(commentDto);
        try {
            commentDao.save(commentBean);
        } catch (DAOException e) {
            LOGGER.error("Create comment error service", e);
            throw new ServiceException("Create comment error service", e);
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
