package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.controller.Command;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

/**
 *
 * welcome page
 *
 */

public class WelcomePage implements Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute(ALL_COMMENT, factoryService.getCommentService().findAllComment());
        } catch (ServiceException e) {
            LOGGER.error("Welcome page controller error", e);
            throw new ServletException("Welcome page controller error", e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PAGE_WELCOME);
        requestDispatcher.forward(req, resp);
    }
}
