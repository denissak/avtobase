package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.bean.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> findAll();

    Comment save(Comment entity);
}
