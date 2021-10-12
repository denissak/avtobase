package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.bean.Comment;
import by.epam.jwd.sak.avtobase.exception.DAOException;

import java.util.List;

public interface CommentDao {
    
    
    
    List<Comment> findAll() throws DAOException;

    Comment save(Comment entity) throws DAOException;
}
