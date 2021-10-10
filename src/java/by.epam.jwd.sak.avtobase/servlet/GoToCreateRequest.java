package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.bean.StatusRequest;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.util.LocalDateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;

import static by.epam.jwd.sak.avtobase.servlet.CommandParameter.ATTRIBUTE_URL;

public class GoToCreateRequest implements Command {

    private static final String GO_TO_CREATE_REQ_PAGE = "/WEB-INF/jsp/createUserRequest.jsp";
    private static final String GO_TO_CREATE_REQUEST_PAGE="Controller?command=gotocreaterequest";

    private final FactoryService factoryService = FactoryService.getInstance();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getMethod().equals("POST")) {
            UserDto user = (UserDto) req.getSession().getAttribute("user");
            RequestDto requestDto = RequestDto.builder()
                    .userDto(user)
                    .startAddress(req.getParameter("startAddress"))
                    .endAddress(req.getParameter("endAddress"))
                    .dateDeparture(LocalDateTimeFormatter.format(req.getParameter("dateDeparture")))
                    .typeTransport(TypeTransport.valueOf(req.getParameter("typeTransport")))
                    .detailsRequest(req.getParameter("detailsRequest"))
                    .build();
            factoryService.getRequestService().create(requestDto);
        }
        req.setAttribute("typeTransports",TypeTransport.values());
        resp.sendRedirect("/index");
        HttpSession session = req.getSession(true);
        session.setAttribute(ATTRIBUTE_URL, GO_TO_CREATE_REQUEST_PAGE);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_CREATE_REQ_PAGE);
        requestDispatcher.forward(req,resp);
    }
}
