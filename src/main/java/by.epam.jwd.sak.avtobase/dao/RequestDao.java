package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.bean.Request;
import by.epam.jwd.sak.avtobase.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface RequestDao {

    List<Request> findAllByCarId(Long carId) throws DAOException;

    Optional<Request> findById(Long id) throws DAOException;

    List<Request> findAllByUserId(Long userId) throws DAOException;

    List<Request> findAll() throws DAOException;

    Request save(Request entity) throws DAOException;

    Long addDriverOnRequest(Long carId, Long requestId) throws DAOException;

    Request update(Request entity) throws DAOException;

    boolean updateStatusById(Long id, String status) throws DAOException;

    boolean delete(Long id) throws DAOException;

}
