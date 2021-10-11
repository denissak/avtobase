package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.bean.TypeTransport;

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
        req.setAttribute("typeTransports", TypeTransport.values());
        process(req,resp);
        //if (req.getSession().getAttribute("user") != "null"){
            //req.getRequestDispatcher("index.jsp").forward(req, resp);

        //}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("typeTransports", TypeTransport.values());
        req.setCharacterEncoding("UTF-8");
        process(req,resp);
    }

    private void process (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name;
        Command command;
        try {
            name = req.getParameter("command");
            if (name != null) {
                command = provider.takeCommand(name);
                command.execute (req, resp);
            }
/*            command = provider.takeCommand(name);
            command.execute (req, resp);*/
        }catch (RuntimeException e){
            //req.getRequestDispatcher("error404.html").forward(req,resp);
        }
    }
}
