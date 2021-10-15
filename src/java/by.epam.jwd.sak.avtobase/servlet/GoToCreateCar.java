package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.bean.StatusCar;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dto.CarDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.util.LocalDateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToCreateCar implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals("POST")) {
            CarDto carDto = CarDto.builder()
                    .mark(req.getParameter("mark"))
                    .model(req.getParameter("model"))
                    .releaseDate(LocalDateTimeFormatter.format(req.getParameter("releaseDate")))
                    .typeTransport(TypeTransport.valueOf(req.getParameter("typeTransport")))
                    .liftingCapacity(Integer.valueOf(req.getParameter("liftingCapacity")))
                    .cargoCapacity(Integer.valueOf(req.getParameter("cargoCapacity")))
                    .passengerCapacity(Integer.valueOf(req.getParameter("passengerCapacity")))
                    .inspectionPermission(LocalDateTimeFormatter.format(req.getParameter("inspectionPermission")))
                    .statusCar(StatusCar.valueOf(req.getParameter("statusCar")))
                    .carDescription(req.getParameter("carDescription"))
                    .build();
            try {
                factoryService.getCarService().create(carDto);
            } catch (ServiceException e) {
                throw new ServletException();
            }
        }
        req.setAttribute("typeTransports",TypeTransport.values());
        req.setAttribute("statusCars",StatusCar.values());
        resp.sendRedirect("Controller?command=gotoalluserrequestpage");
    }
    }

