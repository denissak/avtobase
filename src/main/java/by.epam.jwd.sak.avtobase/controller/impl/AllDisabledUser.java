package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.controller.Command;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.service.Pagination;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

/**
 *
 * {@code Command} realization for watching all inactive users.
 *
 */

public class AllDisabledUser implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<UserDto> userDtoList = (List<UserDto>) req.getSession().getAttribute(ALL_DISABLED_USER);
        String page = req.getParameter(PAGE);
        double numberOfPages = Math.ceil(userDtoList.size() / 5.0);
        req.setAttribute(NUMBER_OF_PAGES, numberOfPages);
        req.setAttribute(DISABLED_USER_DISPLAY, Pagination.process(userDtoList, page));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PAGE_ALL_DISABLED_USER);
        requestDispatcher.forward(req, resp);
    }
    }

