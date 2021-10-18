package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToAllUserPage implements Command {

    private static final String GO_TO_ALL_USER_PAGE = "/WEB-INF/jsp/allUser.jsp";
    private static final String GO_TO_AUSER_PAGE = "Controller?command=gotoalluserpage";

    private final FactoryService factoryService = FactoryService.getInstance();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("allUser", factoryService.getUserService().findAllUser());
        } catch (ServiceException e) {
            throw new ServletException();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_ALL_USER_PAGE);
        requestDispatcher.forward(req, resp);

    }
}
