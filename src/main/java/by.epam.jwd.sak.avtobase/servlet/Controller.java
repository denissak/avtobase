package by.epam.jwd.sak.avtobase.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class Controller extends HttpServlet {

    private final CommandProvider provider = new CommandProvider();

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name;
        Command command;
        try {
            name = req.getParameter("command");
            if (name != null) {
                command = provider.takeCommand(name);
                command.execute(req, resp);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            //req.getRequestDispatcher("error404.html").forward(req,resp);
        }
    }
}
