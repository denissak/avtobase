package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.entity.Comment;
import by.epam.jwd.sak.avtobase.exception.DAOException;

import java.util.List;

public interface CommentDao {

    List<Comment> findAll() throws DAOException;

    boolean save(Comment entity) throws DAOException;

    List<Comment> findAllByUserId(Long userId) throws DAOException;

    boolean delete(Long id) throws DAOException;
}
