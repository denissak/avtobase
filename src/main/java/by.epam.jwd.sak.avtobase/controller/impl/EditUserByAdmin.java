package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class EditUserByAdmin implements Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(METHOD) != null) {
            if (req.getParameter(METHOD).equals(DELETE)) {
                long userId = Integer.parseInt(req.getParameter(ID));
                try {
                    factoryService.getUserService().delete(userId);
                } catch (ServiceException e) {
                    LOGGER.error("Delete user by admin controller error", e);
                    throw new ServletException("Delete user by admin controller error", e);
                }
            } else if (req.getParameter(METHOD).equals(RESTORE)){
                long userId = Integer.parseInt(req.getParameter(ID));
                try {
                    factoryService.getUserService().restore(userId);
                } catch (ServiceException e) {
                    LOGGER.error("Restore user by admin controller error", e);
                    throw new ServletException("Restore user by admin controller error", e);
                }
            }
        } else if (req.getMethod().equals(POST)) {
            long id = 0;
            if (req.getParameter(ID) != null) {
                id = Integer.valueOf(req.getParameter(ID));
            }
            UserDto userDto = UserDto.builder()
                    .id(id)
                    .login(req.getParameter(LOGIN))
                    .password(req.getParameter(PASSWORD))
                    .role(req.getParameter(ROLE))
                    .name(req.getParameter(NAME))
                    .surname(req.getParameter(SURNAME))
                    .phoneNumber(req.getParameter(PHONE_NUMBER))
                    .build();
            try {
                factoryService.getUserService().update(userDto);
            } catch (ServiceException e) {
                LOGGER.error("Edit user by admin controller error", e);
                throw new ServletException("Edit user by admin controller error", e);
            }
        }
        try {
            req.getSession().setAttribute(ALL_USER, factoryService.getUserService().findAllUser());
            req.getSession().setAttribute(ALL_DISABLED_USER, factoryService.getUserService().findAllDisabledUser());
        } catch (ServiceException e) {
            LOGGER.error("Edit user by admin controller error", e);
            throw new ServletException("Edit user by admin controller error", e);
        }
        resp.sendRedirect(COMMAND_ALL_USER);
    }
}
