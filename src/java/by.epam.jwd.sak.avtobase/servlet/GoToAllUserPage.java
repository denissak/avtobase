package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.servlet.CommandParameter.ATTRIBUTE_URL;

public class GoToAllUserPage implements Command {

    private static final String GO_TO_ALL_USER_PAGE = "/WEB-INF/jsp/allUser.jsp";
    private static final String GO_TO_AUSER_PAGE="Controller?command=gotoalluserpage";

    private final FactoryService factoryService = FactoryService.getInstance();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //HttpSession session = req.getSession(true);
/*        UserDto user = (UserDto) req.getSession().getAttribute("user");
        Integer userId = user.getId();*/
        try {
            req.setAttribute("allUser", factoryService.getUserService().findAllUser());
        } catch (ServiceException e) {
            throw new ServletException();
        }
        //session.setAttribute(ATTRIBUTE_URL, GO_TO_AUSER_PAGE);
        //resp.sendRedirect("/userRequest");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_ALL_USER_PAGE);
        requestDispatcher.forward(req,resp);

    }
}
