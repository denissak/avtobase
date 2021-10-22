package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;
import by.epam.jwd.sak.avtobase.util.LocalDateFormatter;
import by.epam.jwd.sak.avtobase.util.LocalDateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class CreateRequest implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getMethod().equals(POST)) {
            UserDto user = (UserDto) req.getSession().getAttribute(USER);
            RequestDto requestDto = RequestDto.builder()
                    .userDto(user)
                    .startAddress(req.getParameter(START_ADDRESS))
                    .endAddress(req.getParameter(END_ADDRESS))
                    .dateDeparture(LocalDateFormatter.format(req.getParameter(DATE_DEPARTURE)))
                    .typeTransport(TypeTransport.valueOf(req.getParameter(TYPE_TRANSPORT)))
                    .detailsRequest(req.getParameter(DETAILS_REQUEST))
                    .build();
            try {
                factoryService.getRequestService().create(requestDto);
            } catch (ServiceException e) {
                throw new ServletException();
            }
        }
        req.setAttribute(TYPE_TRANSPORTS,TypeTransport.values());
        resp.sendRedirect(COMMAND_ALL_USER_REQUEST);
    }
}
