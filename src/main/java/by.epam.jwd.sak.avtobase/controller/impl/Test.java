package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.controller.Command;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class Test implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();



    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date date = Date.valueOf(req.getParameter("data"));
        try {

            req.getSession().setAttribute(USER_DRIVERS, factoryService.getCarService().findAllFreeDriver(date));
/*            req.setAttribute(USER_DRIVERS, factoryService.getCarService().findAllFreeDriver(date));*/
        } catch (ServiceException e) {
           throw new ServletException(e.getMessage(), e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(COMMAND_ALL_REQUEST);
        requestDispatcher.forward(req,resp);
    }
}
