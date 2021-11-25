package by.epam.jwd.sak.avtobase.controller.impl;


import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class SetDriverOnRequest implements Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals(POST)) {
            String status = req.getParameter(STATUS);
            Long requestId = Long.valueOf(req.getParameter(REQUEST_ID));
            Long carId = Long.valueOf(req.getParameter(DRIVER));
            try {
                factoryService.getCarService().findAllFreeDriver();
                factoryService.getRequestService().addDriverOnRequest(carId, requestId);
                factoryService.getRequestService().updateStatusById(requestId, status);
            } catch (ServiceException e) {
                LOGGER.error("Set driver on request controller error", e);
                throw new ServletException("Set driver on request controller error", e);
            }
            resp.sendRedirect(COMMAND_ALL_REQUEST);
        }
    }
}
