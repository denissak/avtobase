package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.bean.StatusRequest;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;
import by.epam.jwd.sak.avtobase.util.LocalDateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class EditRequestByUser implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(METHOD) != null) {
            if (req.getParameter(METHOD).equals(DELETE)) {
                int requestId = Integer.parseInt(req.getParameter(ID));
                try {
                    factoryService.getRequestService().delete(requestId);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
            }
        } else if (req.getMethod().equals(POST)) {
            int id = 0;
            if (req.getParameter(ID) != null){
                id = Integer.valueOf(req.getParameter(ID));
            }
            RequestDto requestDto = RequestDto.builder()
                    .id(id)
                    .startAddress(req.getParameter(START_ADDRESS))
                    .endAddress(req.getParameter(END_ADDRESS))
                    .dateDeparture(LocalDateTimeFormatter.format(req.getParameter(DATE_DEPARTURE)))
                    .statusRequest(StatusRequest.valueOf(req.getParameter(STATUS_REQUEST)))
                    .typeTransport(TypeTransport.valueOf(req.getParameter(TYPE_TRANSPORT)))
                    .detailsRequest(req.getParameter(DETAILS_REQUEST))
                    .build();
            try {
                factoryService.getRequestService().update(requestDto);
            } catch (ServiceException e) {
                throw new ServletException();
            }
        }
        resp.sendRedirect(COMMAND_ALL_USER_REQUEST);
    }
}
