package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToAllUserComment implements Command {

    private static final String GO_TO_ALL_COMMENT_BY_USER_PAGE = "/WEB-INF/jsp/userComment.jsp";

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto user = (UserDto) req.getSession().getAttribute("user");
        Integer userId = user.getId();
        try {
            req.setAttribute("requestsById", factoryService.getCommentService().findAllCommentByUser(userId));
        } catch (ServiceException e) {
            throw new ServletException();
        }
        //session.setAttribute(ATTRIBUTE_URL, GO_TO_ALL_USER_REQ_PAGE);
        //resp.sendRedirect("/userRequest");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_ALL_COMMENT_BY_USER_PAGE);
        requestDispatcher.forward(req,resp);
    }
}
