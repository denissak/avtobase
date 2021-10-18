package by.epam.jwd.sak.avtobase.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToMainPage implements Command {

    private static final String GO_TO_MPAGE="WEB-INF/jsp/mainpage.jsp";
    private static final String GO_TO_MAIN_PAGE="Controller?command=gotomainpage";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_MPAGE);
        requestDispatcher.forward(req, resp);
    }
}
