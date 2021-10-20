package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToAllDriver implements Command {

    private static final String GO_TO_ALL_DRIVER_PAGE = "/WEB-INF/jsp/allDriver.jsp";

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("allDriver", factoryService.getUserService().findAllDrivers());
        } catch (ServiceException e) {
            throw new ServletException();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_ALL_DRIVER_PAGE);
        requestDispatcher.forward(req, resp);

    }
}
