package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static servlet.CommandParameter.ATTRIBUTE_URL;

public class Registration implements Command {

    private static final String GO_TO_REG_PAGE = "/WEB-INF/jsp/registration.jsp";
    private static final String GO_TO_REGISTRATION_PAGE = "Controller?command=registration";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute(ATTRIBUTE_URL, GO_TO_REGISTRATION_PAGE);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_REG_PAGE);
        requestDispatcher.forward(req,resp);

    }
}
