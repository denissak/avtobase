package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> findAll() throws DAOException;

    List<User> findAllDrivers() throws DAOException;

    Optional<User> findById(Integer id) throws DAOException;

    User findByLogin(String login) throws DAOException;

    User save(User entity) throws DAOException;

    User update (User entity) throws DAOException;

    boolean delete(Integer id) throws DAOException;
}
