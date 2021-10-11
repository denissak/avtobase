package by.epam.jwd.sak.avtobase.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.servlet.CommandParameter.ATTRIBUTE_URL;

public class GoToMainPage implements Command {

    private static final String GO_TO_MPAGE="WEB-INF/jsp/mainpage.jsp";
    private static final String GO_TO_MAIN_PAGE="Controller?command=gotomainpage";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //HttpSession session = req.getSession(true);
        //session.setAttribute(ATTRIBUTE_URL, GO_TO_MAIN_PAGE);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_MPAGE);
        requestDispatcher.forward(req, resp);
    }
}
