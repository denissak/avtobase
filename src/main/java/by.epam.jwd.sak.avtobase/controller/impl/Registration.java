package by.epam.jwd.sak.avtobase.controller.impl;

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

public class Registration implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals(POST)) {
            UserDto userDto = UserDto.builder()
                    .login(req.getParameter(LOGIN))
                    .password(req.getParameter(PASSWORD))
                    .name(req.getParameter(NAME))
                    .surname(req.getParameter(SURNAME))
                    .phoneNumber(req.getParameter(PHONE_NUMBER))
                    .build();
            try {
                factoryService.getUserService().create(userDto);
            } catch (ServiceException e) {
                throw new ServletException(e.getMessage(), e);
            }
        }
        resp.sendRedirect("/");

    }
}
