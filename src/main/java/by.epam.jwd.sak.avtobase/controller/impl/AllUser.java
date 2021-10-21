package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;
import by.epam.jwd.sak.avtobase.service.Pagination;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class AllUser implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<UserDto> userDtoList = (List<UserDto>) req.getSession().getAttribute(ALL_USER);
        String page = req.getParameter(PAGE);
        int numberOfPages = userDtoList.size() / 5 + 1; //TODO
        req.setAttribute(NUMBER_OF_PAGES, numberOfPages);
        Pagination.process(userDtoList, page);
        req.setAttribute(USER_DISPLAY, Pagination.process(userDtoList, page));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PAGE_ALL_USER);
        requestDispatcher.forward(req, resp);
    }
}
