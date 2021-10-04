package servlet;

import dto.UserDto;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static servlet.CommandParameter.*;

public class Login implements Command {

    private static final String GO_TO_LOGIN_PAGE = "/WEB-INF/jsp/login.jsp";
    private final UserService userService = UserService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.findLogin(req.getParameter(LOGIN),req.getParameter(PASSWORD))
                .ifPresentOrElse(
                        user -> onLoginSuccess(user, req, resp),
                        () -> onLoginFail (req, resp)
                );
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_LOGIN_PAGE);
        requestDispatcher.forward(req,resp);
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
            resp.sendRedirect("/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
