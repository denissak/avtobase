package by.epam.jwd.sak.avtobase.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Represents the interface which must be implemented in order to be executed by
 * {@link by.epam.jwd.sak.avtobase.controller.Controller}
 *
 * @see CommandProvider
 *
 */

public interface Command {
    void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
