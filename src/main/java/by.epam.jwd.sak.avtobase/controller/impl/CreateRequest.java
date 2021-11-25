package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.entity.TypeTransport;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class CreateRequest implements Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private final FactoryService factoryService = FactoryService.getInstance();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto user = (UserDto) req.getSession().getAttribute(USER);
        if (req.getMethod().equals(POST)) {
            RequestDto requestDto = RequestDto.builder()
                    .userDto(user)
                    .startAddress(req.getParameter(START_ADDRESS))
                    .endAddress(req.getParameter(END_ADDRESS))
                    .dateDeparture(LocalDate.parse(req.getParameter(DATE_DEPARTURE)))
                    .typeTransport(TypeTransport.valueOf(req.getParameter(TYPE_TRANSPORT)))
                    .detailsRequest(req.getParameter(DETAILS_REQUEST))
                    .build();
            try {
                factoryService.getRequestService().create(requestDto);
            } catch (ServiceException e) {
                LOGGER.error("Create request controller error", e);
                throw new ServletException("Create request controller error", e);
            }
        }
        req.setAttribute(TYPE_TRANSPORTS, TypeTransport.values());
        if (user.getRole().equals(DISPATCHER)) {
            resp.sendRedirect(COMMAND_ALL_REQUEST);
        } else {
            resp.sendRedirect(COMMAND_ALL_USER_REQUEST);
        }
    }
}
