package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.entity.User;
import by.epam.jwd.sak.avtobase.exception.DAOException;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> findAll() throws DAOException;

    List<User> findAllFreeDrivers(Date date) throws DAOException;

    List<User> findAllDrivers() throws DAOException;

    Optional<User> findById(Long id) throws DAOException;

    User findByLogin(String login) throws DAOException;

    boolean save(User entity) throws DAOException;

    boolean update (User entity) throws DAOException;

    boolean delete(Long id) throws DAOException;
}
