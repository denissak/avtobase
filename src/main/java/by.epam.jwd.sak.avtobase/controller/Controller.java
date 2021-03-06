package by.epam.jwd.sak.avtobase.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

/**
 * Represents Front controller.
 *
 */

@WebServlet("/")
public class Controller extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger();
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
            LOGGER.error("Main controller error", e);
            throw new ServletException("Main controller error", e);
        }
    }
}
