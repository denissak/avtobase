package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.entity.Role;
import by.epam.jwd.sak.avtobase.exception.DAOException;

import java.util.List;

public interface RolesDao {

    List<Role> findAll() throws DAOException;
}
