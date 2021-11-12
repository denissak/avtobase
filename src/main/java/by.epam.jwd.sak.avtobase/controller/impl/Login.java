package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.entity.StatusCar;
import by.epam.jwd.sak.avtobase.entity.StatusRequest;
import by.epam.jwd.sak.avtobase.entity.TypeTransport;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;
import by.epam.jwd.sak.avtobase.service.PasswordEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class Login implements Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter(PASSWORD);

        try {
            UserDto userDto = factoryService.getUserService().findByLogin(req.getParameter(LOGIN));
            if (PasswordEncoder.getInstance().isMatching(password, userDto.getPassword())) {
                onLoginSuccess(userDto, req, resp);
            } else {
                onLoginFail(req, resp);
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new ServletException(e.getMessage(), e);
        }
    }

    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            resp.sendRedirect("/");
        } catch (IOException e) {
            throw new ServletException(e.getMessage(),e);
        }
    }

    private void onLoginSuccess(UserDto userDto, HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        req.getSession().setAttribute(USER, userDto);
        req.getSession().setAttribute(TYPE_TRANSPORTS, TypeTransport.values());
        req.getSession().setAttribute(STATUS_CARS, StatusCar.values());

        if (userDto.getRole().equals(USER)) {
            try {
                resp.sendRedirect(COMMAND_ALL_USER_REQUEST);
            } catch (IOException e) {
                LOGGER.error(e);
                throw new ServletException(e.getMessage(), e);
            }
        } else if (userDto.getRole().equals(DISPATCHER)) {
            try {
                req.getSession().setAttribute(STATUS_REQUESTS, StatusRequest.values());
                resp.sendRedirect(COMMAND_ALL_REQUEST);
            } catch (IOException e) {
                LOGGER.error(e);
                throw new ServletException(e.getMessage(), e);
            }

        } else if (userDto.getRole().equals(DRIVER)) {
            try {
                req.getSession().setAttribute(STATUS_REQUESTS, StatusRequest.values());
                req.getSession().setAttribute(ALL_CAR, factoryService.getCarService().findAllCar());
                resp.sendRedirect(COMMAND_ALL_REQUEST_BY_DRIVER);
            } catch (IOException | ServiceException e) {
                LOGGER.error(e);
                throw new ServletException(e.getMessage(), e);
            }

        } else if (userDto.getRole().equals(ADMIN)) {
            try {
                try {
                    req.getSession().setAttribute(ROLES, factoryService.getRolesService().findAllRoles());
                    req.getSession().setAttribute(ALL_USER, factoryService.getUserService().findAllUser());
                    req.getSession().setAttribute(ALL_CAR, factoryService.getCarService().findAllCar());
                    req.getSession().setAttribute(ALL_REQUEST, factoryService.getRequestService().findAllRequest());

                } catch (ServiceException e) {
                    LOGGER.error(e);
                    throw new ServletException(e.getMessage(), e);
                }
                resp.sendRedirect(COMMAND_ALL_USER);
            } catch (IOException e) {
                LOGGER.error(e);
                e.printStackTrace();
            }
        }

    }
}
