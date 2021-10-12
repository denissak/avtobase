package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.servlet.CommandParameter.*;
import static by.epam.jwd.sak.avtobase.servlet.CommandParameter.PHONE_NUMBER;

public class UserEditByAdmin implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals("POST")) {
            UserDto userDto = UserDto.builder()
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
                throw new ServletException();
            }
        }

        resp.sendRedirect("Controller?command=gotoalluserpage");
    }
}
