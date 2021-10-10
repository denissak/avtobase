package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.dto.UserDto;
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
        factoryService.getUserService().findByLoginAndPassword(req.getParameter(LOGIN),req.getParameter(PASSWORD))
                .ifPresentOrElse(
                        user -> onLoginSuccess(user, req, resp),
                        () -> onLoginFail (req, resp)
                );
/*        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_LOGIN_PAGE);
        requestDispatcher.forward(req,resp);*/
    }

    private void onLoginFail (HttpServletRequest req, HttpServletResponse resp){
        try {
            resp.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onLoginSuccess (UserDto user, HttpServletRequest req, HttpServletResponse resp){
        req.getSession().setAttribute("user", user);
        try {
            //resp.sendRedirect("gotoalluserrequestpage");
            req.getRequestDispatcher("Controller?command=gotoalluserrequestpage").forward(req,resp);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
