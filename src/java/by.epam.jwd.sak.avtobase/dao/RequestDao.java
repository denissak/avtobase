package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.bean.Request;
import by.epam.jwd.sak.avtobase.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface RequestDao {

    Optional<Request> findById(Integer id) throws DAOException;

    List<Request> findAllByUserId(Integer userId) throws DAOException;

    Request save(Request entity) throws DAOException;

}
