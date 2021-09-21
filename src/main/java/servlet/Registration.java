package servlet;

import dto.UserCreateDto;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static servlet.CommandParameter.ATTRIBUTE_URL;

public class Registration implements Command {

    private static final String GO_TO_REG_PAGE = "/WEB-INF/jsp/registration.jsp";
    private static final String GO_TO_REGISTRATION_PAGE = "Controller?command=registration";
    private final UserService userService = UserService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCreateDto createUserDto = UserCreateDto.builder()
                .login(req.getParameter("login"))
                .password(req.getParameter("password"))
                .roleId(req.getParameter("roleId"))
                .name(req.getParameter("name"))
                .surname(req.getParameter("surname"))
                .phoneNumber(req.getParameter("phoneNumber"))
                .build();

        userService.create(createUserDto);
        //resp.sendRedirect("/login");


        HttpSession session = req.getSession(true);
        session.setAttribute(ATTRIBUTE_URL, GO_TO_REGISTRATION_PAGE);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_REG_PAGE);
        requestDispatcher.forward(req,resp);

    }
}
