package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.bean.StatusRequest;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.util.LocalDateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestEditByUser implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("method") != null) {
            if (req.getParameter("method").equals("delete")) {
                int requestId = Integer.parseInt(req.getParameter("id"));
                try {
                    factoryService.getRequestService().delete(requestId);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
            }
        } else if (req.getMethod().equals("POST")) {
            int id = 0;
            if (req.getParameter("id") != null){
                id = Integer.valueOf(req.getParameter("id"));
            }
            RequestDto requestDto = RequestDto.builder()
                    .id(id)
                    //.userDto(req.getParameter())
                    //.userDto(user)
                    .startAddress(req.getParameter("startAddress"))
                    .endAddress(req.getParameter("endAddress"))
                    .dateDeparture(LocalDateTimeFormatter.format(req.getParameter("dateDeparture")))
                    .statusRequest(StatusRequest.valueOf(req.getParameter("statusRequest")))
                    .typeTransport(TypeTransport.valueOf(req.getParameter("typeTransport")))
                    .detailsRequest(req.getParameter("detailsRequest"))
                    .build();
            try {
                factoryService.getRequestService().update(requestDto);
            } catch (ServiceException e) {
                throw new ServletException();
            }
        }
        resp.sendRedirect("Controller?command=gotoalluserrequestpage");
    }
}
