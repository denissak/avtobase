package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class SetDriverOnCar implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals(POST)) {
            Integer carId = Integer.valueOf(req.getParameter(CAR_ID));
            Integer driverId = Integer.valueOf(req.getParameter(DRIVER));
            try {
                factoryService.getCarService().addDriver(driverId, carId);
            } catch (ServiceException e) {
                throw new ServletException(e.getMessage(), e);
            }
            resp.sendRedirect(COMMAND_ALL_CAR);
        }
    }
}
