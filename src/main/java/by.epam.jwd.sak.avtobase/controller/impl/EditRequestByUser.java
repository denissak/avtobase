package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.bean.StatusRequest;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;
import by.epam.jwd.sak.avtobase.util.LocalDateFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class EditRequestByUser implements Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = (UserDto) req.getSession().getAttribute("user");
        if (req.getParameter(METHOD) != null) {
            if (req.getParameter(METHOD).equals(DELETE)) {
                long requestId = Integer.parseInt(req.getParameter(ID));
                try {
                    factoryService.getRequestService().delete(requestId);
                } catch (ServiceException e) {
                    LOGGER.error(e);
                    throw new ServletException(e.getMessage(), e);
                }
            }
        } else if (req.getMethod().equals(POST)) {
            long id = 0;
            if (req.getParameter(ID) != null){
                id = Integer.valueOf(req.getParameter(ID));
            }
            RequestDto requestDto = RequestDto.builder()
                    .id(id)
                    .startAddress(req.getParameter(START_ADDRESS))
                    .endAddress(req.getParameter(END_ADDRESS))
                    .dateDeparture(LocalDateFormatter.format(req.getParameter(DATE_DEPARTURE)))
                    .statusRequest(StatusRequest.valueOf(req.getParameter(STATUS_REQUEST)))
                    .typeTransport(TypeTransport.valueOf(req.getParameter(TYPE_TRANSPORT)))
                    .detailsRequest(req.getParameter(DETAILS_REQUEST))
                    .build();
            try {
                factoryService.getRequestService().update(requestDto);
            } catch (ServiceException e) {
                LOGGER.error(e);
                throw new ServletException(e.getMessage(), e);
            }
        }
        if (userDto.getRole().equals("dispatcher")) {
            resp.sendRedirect(COMMAND_ALL_REQUEST);
        } else {
            resp.sendRedirect(COMMAND_ALL_USER_REQUEST);
        }
    }
}
