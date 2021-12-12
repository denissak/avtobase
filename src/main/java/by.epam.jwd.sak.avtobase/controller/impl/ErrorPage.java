package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.controller.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.PAGE_ERROR;

/**
 *
 * Implementation of {@code Command} to set error page.
 *
 */

public class ErrorPage implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PAGE_ERROR);
        requestDispatcher.forward(req, resp);
    }
}
