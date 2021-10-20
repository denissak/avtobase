package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.dto.CommentDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class CreateComment implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals(POST)) {
            UserDto userDto = (UserDto) req.getSession().getAttribute(USER);
            CommentDto commentDto = CommentDto.builder()
                    .userDto(userDto)
                    .mark(Integer.valueOf(req.getParameter(MARK)))
                    .message(req.getParameter(MESSAGE))
                    .build();
            try {
                factoryService.getCommentService().create(commentDto);
            } catch (ServiceException e) {
                throw new ServletException();
            }
        }
        resp.sendRedirect(COMMAND_ALL_USER_REQUEST);
    }
}

