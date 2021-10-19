package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.RoleDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.util.List;

public interface RolesService {

    List<RoleDto> findAllRoles() throws ServiceException;
}
