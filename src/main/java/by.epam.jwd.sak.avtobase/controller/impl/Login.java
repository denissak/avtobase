package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.bean.StatusCar;
import by.epam.jwd.sak.avtobase.bean.StatusRequest;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;
import by.epam.jwd.sak.avtobase.service.PasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class Login implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter(PASSWORD);

        try {
            UserDto userDto = factoryService.getUserService().findByLogin(req.getParameter(LOGIN));
            if (PasswordEncoder.getInstance().isMatching(password, userDto.getPassword())){
                onLoginSuccess(userDto, req, resp);
            }else {
                onLoginFail(req,resp);
            }
        } catch (ServiceException e) {
            throw new ServletException();
        }
    }

    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onLoginSuccess(UserDto userDto, HttpServletRequest req, HttpServletResponse resp) {

        req.getSession().setAttribute(USER, userDto);
        req.getSession().setAttribute(TYPE_TRANSPORTS, TypeTransport.values());
        req.getSession().setAttribute(STATUS_CARS, StatusCar.values());

        if (userDto.getRole().equals(USER)) {
            try {
                resp.sendRedirect(COMMAND_ALL_USER_REQUEST);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (userDto.getRole().equals(DISPATCHER)) {
            try {
                req.getSession().setAttribute(STATUS_REQUESTS, StatusRequest.values());
                resp.sendRedirect(COMMAND_ALL_REQUEST);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (userDto.getRole().equals(ADMIN)) {
            try {
                try {
                    req.getSession().setAttribute(ROLES, factoryService.getRolesService().findAllRoles());
                    req.getSession().setAttribute(ALL_USER, factoryService.getUserService().findAllUser());
                    req.getSession().setAttribute(ALL_CAR, factoryService.getCarService().findAllCar());
                    //req.getSession().getAttribute(ALL_DRIVER, factoryService.getUserService().findAllDrivers())
                    req.getSession().setAttribute(ALL_REQUEST,factoryService.getRequestService().findAllRequest());

                } catch (ServiceException e) {
                    e.printStackTrace();
                }
                resp.sendRedirect(COMMAND_ALL_USER);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
