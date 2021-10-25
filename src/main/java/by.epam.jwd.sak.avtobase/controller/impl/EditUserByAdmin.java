package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class EditUserByAdmin implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(METHOD) != null) {
            if (req.getParameter(METHOD).equals(DELETE)) {
                long userId = Integer.parseInt(req.getParameter(ID));
                try {
                    factoryService.getUserService().delete(userId);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
            }
        } else if (req.getMethod().equals(POST)) {
            long id = 0;
            if (req.getParameter(ID) != null){
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
                throw new ServletException();
            }
        }
        resp.sendRedirect(COMMAND_ALL_USER);
    }
}
