package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.dto.RequestCreateDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.service.FactoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.servlet.CommandParameter.ATTRIBUTE_URL;

public class GoToCreateRequest implements Command {

    private static final String GO_TO_CREATE_REQ_PAGE = "/WEB-INF/jsp/createUserRequest.jsp";
    private static final String GO_TO_CREATE_REQUEST_PAGE="Controller?command=gotocreaterequest";

    private final FactoryService factoryService = FactoryService.getInstance();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

/*        UserDto user = (UserDto) req.getSession().getAttribute("user");
        Integer userId = user.getId();*/

        RequestCreateDto requestCreateDto = RequestCreateDto.builder()
                //.user(req.getParameter("userId"))
                .dateCreate(req.getParameter("dateCreate"))
                .startAddress(req.getParameter("startAddress"))
                .endAddress(req.getParameter("endAddress"))
                .dateDeparture(req.getParameter("dateDeparture"))
                .statusRequest(req.getParameter("statusRequest"))
                .typeTransport(req.getParameter("typeTransport"))
                .detailsRequest(req.getParameter("detailsRequest"))
                .build();

        factoryService.getRequestService().create(requestCreateDto);
        resp.sendRedirect("/index");
        HttpSession session = req.getSession(true);
        session.setAttribute(ATTRIBUTE_URL, GO_TO_CREATE_REQUEST_PAGE);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(GO_TO_CREATE_REQ_PAGE);
        requestDispatcher.forward(req,resp);
    }
}
