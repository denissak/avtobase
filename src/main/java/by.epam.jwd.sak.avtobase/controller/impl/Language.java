package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Implementation of changing the interface language.
 *
 */

public class Language implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String language = req.getParameter("lang");
        String prevPage = req.getHeader("referer");
        Cookie cookie = new Cookie("lang", language);
        resp.addCookie(cookie);
        resp.sendRedirect(prevPage);
    }
}
