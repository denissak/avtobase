package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToAllUserRequestPage implements Command{

    private static final String GO_TO_ALL_USER_REQUEST_PAGE = "/WEB-INF/jsp/userRequest.jsp";
    private static final String GO_TO_ALL_USER_REQ_PAGE="Controller?command=gotoalluserrequestpage";

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto user = (UserDto) req.getSession().getAttribute("user");
        Integer userId = user.getId();
        try {
            req.setAttribute("requestsById", factoryService.getRequestService().findAllRequestByUser(userId));
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_ALL_USER_REQUEST_PAGE);
        requestDispatcher.forward(req,resp);

    }
}
