package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.util.LocalDateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            try {
                factoryService.getRequestService().create(requestDto);
            } catch (ServiceException e) {
                throw new ServletException();
            }
        }
        req.setAttribute("typeTransports",TypeTransport.values());
        resp.sendRedirect("Controller?command=gotoalluserrequestpage");
    }
}