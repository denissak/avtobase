package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.bean.StatusCar;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dto.CarDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;
import by.epam.jwd.sak.avtobase.util.LocalDateFormatter;
import by.epam.jwd.sak.avtobase.util.LocalDateTimeFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class EditCar implements Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(METHOD) != null) {
            if (req.getParameter(METHOD).equals(DELETE)) {
                long carId = Integer.parseInt(req.getParameter(ID));
                try {
                    factoryService.getCarService().delete(carId);
                } catch (ServiceException e) {
                    LOGGER.error(e);
                    throw new ServletException(e.getMessage(), e);
                }
            }
        } else if (req.getMethod().equals(POST)) {
            long id = 0;
            if (req.getParameter(ID) != null) {
                id = Integer.valueOf(req.getParameter(ID));
            }
            CarDto carDto = CarDto.builder()
                    .id(id)
                    .mark(req.getParameter(MARK))
                    .model(req.getParameter(MODEL))
                    .releaseDate(LocalDate.parse(req.getParameter(RELEASE_DATE)))
                    .typeTransport(TypeTransport.valueOf(req.getParameter(TYPE_TRANSPORT)))
                    .liftingCapacity(Integer.valueOf(req.getParameter(LIFTING_CAPACITY)))
                    .cargoCapacity(Integer.valueOf(req.getParameter(CARGO_CAPACITY)))
                    .passengerCapacity(Integer.valueOf(req.getParameter(PASSENGER_CAPACITY)))
                    .inspectionPermission(LocalDate.parse(req.getParameter(INSPECTION_PERMISSION))) //TODO
                    .statusCar(StatusCar.valueOf(req.getParameter(STATUS_CAR)))
                    .carDescription(req.getParameter(CAR_DESCRIPTION))
                    .build();
            try {
                factoryService.getCarService().update(carDto);
            } catch (ServiceException e) {
                LOGGER.error(e);
                throw new ServletException(e.getMessage(), e);
            }
        }
        resp.sendRedirect(COMMAND_ALL_CAR);
    }
}
