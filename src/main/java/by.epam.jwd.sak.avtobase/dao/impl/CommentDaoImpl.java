package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Comment;
import by.epam.jwd.sak.avtobase.dao.CommentDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class CommentDaoImpl implements CommentDao {

    private static final String GET_ALL_COMMENT = "SELECT * FROM comments";
    private static final String SAVE_COMMENT = "INSERT INTO comments (user_id, comment_date, mark, message) VALUES (?,?,?,?)";
    private static final String DELETE_COMMENT = "DELETE FROM comments WHERE id = ?";

    @Override
    public boolean delete(Integer id) throws DAOException {
        int result;
            try (Connection connection = ConnectionManager.get();
                 PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COMMENT, RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, id);
                result = preparedStatement.executeUpdate();
            }
        catch (SQLException e) {
            throw new DAOException();
        }
        return result==1;
    }

    @Override
    public List<Comment> findAllByUserId(Integer userId) throws DAOException {
        return null;
    }

    @Override
    public List<Comment> findAll() throws DAOException {
        List<Comment> comments = new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_COMMENT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                comments.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return comments;
    }

    @Override
    public Comment save(Comment entity) throws DAOException {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_COMMENT, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getUser().getId());
            preparedStatement.setObject(2, entity.getCommentDate());
            preparedStatement.setObject(3, entity.getMark());
            preparedStatement.setObject(4, entity.getMessage());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException();
        }
        return entity;
    }

    private Comment buildEntity(ResultSet resultSet) throws SQLException {
        return Comment.builder()
                .id(resultSet.getObject("id", Integer.class))
                .commentDate(resultSet.getObject("comment_date", Timestamp.class).toLocalDateTime())
                .mark(resultSet.getObject("mark", Integer.class))
                .message(resultSet.getObject("name", String.class))
                .build();
    }
}
