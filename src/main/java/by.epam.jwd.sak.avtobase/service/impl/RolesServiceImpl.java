package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.dao.RolesDao;
import by.epam.jwd.sak.avtobase.entity.Role;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.RoleDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.RolesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class RolesServiceImpl implements RolesService {

    private static final Logger LOGGER = LogManager.getLogger();
    private final RolesDao rolesDao = DaoFactory.getInstance().getRolesDao();

    @Override
    public List<RoleDto> findAllRoles() throws ServiceException {
        try {
            return rolesDao.findAll().stream().map(this::convertToRoleDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error("Find all roles error service", e);
            throw new ServiceException("Find all roles error service", e);
        }
    }

    private RoleDto convertToRoleDto(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }
}
