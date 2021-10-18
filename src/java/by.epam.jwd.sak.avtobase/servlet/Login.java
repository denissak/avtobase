package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.bean.StatusCar;
import by.epam.jwd.sak.avtobase.bean.StatusRequest;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.servlet.CommandParameter.*;

public class Login implements Command {

    private static final String GO_TO_LOGIN_PAGE = "/WEB-INF/jsp/login.jsp";
    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            factoryService.getUserService().findByLoginAndPassword(req.getParameter(LOGIN),req.getParameter(PASSWORD))
                    .ifPresentOrElse(
                            user -> onLoginSuccess(user, req, resp),
                            () -> onLoginFail (req, resp)
                    );
        } catch (ServiceException e) {
            throw new ServletException();
        }
/*        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_LOGIN_PAGE);
        requestDispatcher.forward(req,resp);*/
    }

    private void onLoginFail (HttpServletRequest req, HttpServletResponse resp){
        try {
            resp.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onLoginSuccess (UserDto user, HttpServletRequest req, HttpServletResponse resp){
        req.getSession().setAttribute("user", user);
        //req.getSession().setAttribute("driver", d);
        req.getSession().setAttribute("typeTransports", TypeTransport.values());
        req.getSession().setAttribute("statusCars", StatusCar.values());
        if (user.getRole().equals("user")){
            try {
                resp.sendRedirect("Controller?command=gotoalluserrequestpage");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (user.getRole().equals("dispatcher")){
            try {
                req.getSession().setAttribute("statusRequests", StatusRequest.values());
                resp.sendRedirect("Controller?command=gotoallrequestpage");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (user.getRole().equals("admin")){
            try {
                req.getSession().setAttribute("roles", factoryService.getRolesService().findAllRoles());
                resp.sendRedirect("Controller?command=gotoalluserpage");
            } catch (IOException | ServiceException e) {
                e.printStackTrace();
            }
        }

    }
}
