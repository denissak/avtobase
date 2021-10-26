package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class Language implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String language = req.getParameter("lang");
//        req.getSession().setAttribute("lang", language);
        String prevPage = req.getHeader("referer");

        /*String prevPage = req.getHeader("referer");
        String page = prevPage != null ? prevPage : COMMAND_LOGIN;
        if (prevPage.contains("lang=")) {
            prevPage = prevPage.replaceAll(prevPage.substring(prevPage.length() - 5), language);
            resp.sendRedirect(prevPage);
        } else if (prevPage.contains("Controller")){
            resp.sendRedirect(prevPage *//*+ "&lang=" + language*//*);
        } else {
            resp.sendRedirect(prevPage *//*+ "?lang=" + language*//*);
        }*/
/*        String language = req.getParameter("newLang");*/
/*        String path = req.getParameter(AttributeName.CURRENT_PAGE);*/
        Cookie cookie = new Cookie("lang", language);
        resp.addCookie(cookie);
        resp.sendRedirect(prevPage);
    }
}
