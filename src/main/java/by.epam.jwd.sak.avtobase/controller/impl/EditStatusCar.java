package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.entity.StatusCar;
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

public class EditStatusCar implements Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals(POST)) {
            Long carId = Long.valueOf(req.getParameter(CAR_ID));
            String status = StatusCar.valueOf(req.getParameter(STATUS_CAR)).name();
            try {
                factoryService.getCarService().updateStatusById(carId, status);
                req.getSession().setAttribute(ALL_CAR, factoryService.getCarService().findAllCar());
            } catch (ServiceException e) {
                LOGGER.error("Edit status car controller error", e);
                throw new ServletException("Edit status car controller error", e);
            }
            resp.sendRedirect(COMMAND_ALL_REQUEST_BY_DRIVER);
        }
    }
}


