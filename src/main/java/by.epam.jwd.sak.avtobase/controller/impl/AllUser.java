package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class AllUser implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("page") != null) {
            String page = req.getParameter("page");
            Integer pageInt = Integer.parseInt(page);
            Integer limit  = (pageInt - 1) *5;
            try {
                req.setAttribute(ALL_USER, factoryService.getUserService().findAllUser(limit));
            } catch (ServiceException e) {
                throw new ServletException();
            }
        }


        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PAGE_ALL_USER);
        requestDispatcher.forward(req, resp);

    }
}
