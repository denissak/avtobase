package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.service.FactoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.servlet.CommandParameter.*;

public class Registration implements Command {

    private static final String GO_TO_REG_PAGE = "/WEB-INF/jsp/registration.jsp";
    private static final String GO_TO_REGISTRATION_PAGE = "Controller?command=registration";
    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals("POST")) {
            UserDto userDto = UserDto.builder()
                    .login(req.getParameter(LOGIN))
                    .password(req.getParameter(PASSWORD))
                    .name(req.getParameter(NAME))
                    .surname(req.getParameter(SURNAME))
                    .phoneNumber(req.getParameter(PHONE_NUMBER))
                    .build();
            factoryService.getUserService().create(userDto);
        }
        resp.sendRedirect("/");
        //HttpSession session = req.getSession(true);
        //session.setAttribute(ATTRIBUTE_URL, GO_TO_REGISTRATION_PAGE);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_REG_PAGE);
//        requestDispatcher.forward(req,resp);

    }
}
