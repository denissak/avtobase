package servlet;

import dto.UserDto;
import service.RequestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static servlet.CommandParameter.ATTRIBUTE_URL;

public class GoToAllUserRequestPage implements Command{

    private static final String GO_TO_ALL_USER_REQUEST_PAGE = "/WEB-INF/jsp/userRequest.jsp";
    private static final String GO_TO_ALL_USER_REQ_PAGE="Controller?command=gotoalluserrequestpage";

    private final RequestService requestService = RequestService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        UserDto user = (UserDto) req.getSession().getAttribute("user");
        Integer userId = user.getId();
        req.setAttribute("requestsById",requestService.findAllRequestByUser(userId));
        session.setAttribute(ATTRIBUTE_URL, GO_TO_ALL_USER_REQ_PAGE);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_ALL_USER_REQUEST_PAGE);
        requestDispatcher.forward(req,resp);

    }
}
