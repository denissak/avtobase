package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.bean.Role;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.RoleDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.RolesService;

import java.util.List;
import java.util.stream.Collectors;

public class RolesServiceImpl implements RolesService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<RoleDto> findAllRoles() throws ServiceException {
        try {
            return daoFactory.getRolesDao().findAll().stream().map(this::convertToRoleDto).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    private RoleDto convertToRoleDto(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    private Role convertToRole(RoleDto roleDto) {
        return Role.builder()
                .id(roleDto.getId())
                .name(roleDto.getName())
                .build();
    }
}
