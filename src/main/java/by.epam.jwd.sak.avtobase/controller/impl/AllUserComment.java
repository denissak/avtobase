package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.dto.CommentDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;
import by.epam.jwd.sak.avtobase.service.Pagination;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class AllUserComment implements Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto user = (UserDto) req.getSession().getAttribute(USER);
        Long userId = user.getId();
        try {
            List<CommentDto> commentDtoList = factoryService.getCommentService().findAllCommentByUser(userId);
            String page = req.getParameter(PAGE);
            double numberOfPages = Math.ceil(commentDtoList.size() / 5.0);
            req.setAttribute(NUMBER_OF_PAGES, numberOfPages);
            req.setAttribute(COMMENT_BY_ID, Pagination.process(commentDtoList, page));
        } catch (ServiceException e) {
            LOGGER.error("All users comment controller error", e);
            throw new ServletException("All users comment controller error", e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PAGE_ALL_COMMENT_BY_USER);
        requestDispatcher.forward(req, resp);
    }
}
