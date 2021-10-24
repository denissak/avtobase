package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.controller.Command;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class EditStatusRequestByDriver implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals(POST)) {
            String status = "BEINPROGRESS";
            Integer requestId = Integer.valueOf(req.getParameter(REQUEST_ID));
/*            Integer driverId = Integer.valueOf(req.getParameter(DRIVER));*/
            try {
/*                factoryService.getDriversRequestsService().save(driverId, requestId);*/
                factoryService.getRequestService().updateStatusById(requestId, status);
            } catch (ServiceException e) {
                throw new ServletException();
            }
            resp.sendRedirect(COMMAND_ALL_REQUEST_BY_DRIVER);
        }
    }
}
