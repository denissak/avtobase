package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Comment;
import by.epam.jwd.sak.avtobase.dao.CommentDao;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.util.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static by.epam.jwd.sak.avtobase.dao.daoMapping.Mapping.*;

public class CommentDaoImpl implements CommentDao {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String GET_ALL_COMMENT = "SELECT * FROM comments";
    private static final String GET_ALL_COMMENT_BY_USER_ID = "SELECT * FROM comments WHERE user_id = ?";
    private static final String SAVE_COMMENT = "INSERT INTO comments (user_id, comment_date, mark, message) VALUES (?,?,?,?)";
    private static final String DELETE_COMMENT = "DELETE FROM comments WHERE id = ?";

    @Override
    public boolean delete(Long id) throws DAOException {
        int result;
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COMMENT, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e.getMessage(), e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return result == 1;
    }

    @Override
    public List<Comment> findAllByUserId(Long userId) throws DAOException {
        List<Comment> comments = new ArrayList<>();
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_COMMENT_BY_USER_ID)) {
            preparedStatement.setObject(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                comments.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e.getMessage(), e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return comments;
    }

    @Override
    public List<Comment> findAll() throws DAOException {
        List<Comment> comments = new ArrayList<>();
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_COMMENT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                comments.add(buildEntity(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e.getMessage(), e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return comments;
    }

    @Override
    public Comment save(Comment entity) throws DAOException {
        Connection connection = ConnectionManager.get();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE_COMMENT, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getUser().getId());
            preparedStatement.setObject(2, entity.getCommentDate());
            preparedStatement.setObject(3, entity.getMark());
            preparedStatement.setObject(4, entity.getMessage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            ConnectionManager.returnConnection(connection);
        }
        return entity;
    }

    private Comment buildEntity(ResultSet resultSet) throws SQLException {
        return Comment.builder()
                .id(resultSet.getObject(ID, Long.class))
                .commentDate(resultSet.getObject(COMMENT_DATE, Timestamp.class).toLocalDateTime())
                .mark(resultSet.getObject(MARK, Integer.class))
                .message(resultSet.getObject(MESSAGE, String.class))
                .build();
    }
}
