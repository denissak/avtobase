package servlet;

import dto.UserDto;
import service.RequestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToAllUserRequestPage implements Command{

    private static final String GO_TO_ALL_USER_REQUEST_PAGE = "/WEB-INF/jsp/userRequest.jsp";

    private final RequestService requestService = RequestService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto user = (UserDto) req.getSession().getAttribute("user");
        Integer userId = user.getId();
        req.setAttribute("requestsById",requestService.findAllRequestByUser(userId));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_ALL_USER_REQUEST_PAGE);
        requestDispatcher.forward(req,resp);

    }
}
