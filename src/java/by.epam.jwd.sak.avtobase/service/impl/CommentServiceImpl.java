package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.bean.Comment;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.CommentDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.CommentService;

import java.util.List;
import java.util.stream.Collectors;

public class CommentServiceImpl implements CommentService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<CommentDto> findAllCommentByUser(Integer userId) throws ServiceException {
        try {
            return daoFactory.getCommentDao().findAllByUserId(userId).stream()
                    .map(this::convertToCommentDto).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public boolean delete(Integer id) throws ServiceException {
        try {
            return daoFactory.getCommentDao().delete(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public List<CommentDto> findAllComment() throws ServiceException {
        try {
            return daoFactory.getCommentDao().findAll().stream().map(this::convertToCommentDto).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Integer create(CommentDto commentDto) throws ServiceException {
        Comment commentBean = convertToComment(commentDto);
        try {
            daoFactory.getCommentDao().save(commentBean);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return commentBean.getId();
    }

    private CommentDto convertToCommentDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .commentDate(comment.getCommentDate())
                .mark(comment.getMark())
                .message(comment.getMessage())
                .build();
    }

    private Comment convertToComment(CommentDto commentDto) {
        return Comment.builder()
                .id(commentDto.getId())
                .commentDate(commentDto.getCommentDate())
                .mark(commentDto.getMark())
                .message(commentDto.getMessage())
                .build();
    }
}
