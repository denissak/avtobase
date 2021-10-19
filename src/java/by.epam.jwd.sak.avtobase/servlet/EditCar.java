package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.bean.StatusCar;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.dto.CarDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.util.LocalDateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditCar implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("method") != null) {
            if (req.getParameter("method").equals("delete")) {
                int carId = Integer.parseInt(req.getParameter("id"));
                try {
                    factoryService.getCarService().delete(carId);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
            }
        } else if (req.getMethod().equals("POST")) {
            int id = 0;
            if (req.getParameter("id") != null) {
                id = Integer.valueOf(req.getParameter("id"));
            }
            CarDto carDto = CarDto.builder()
                    .id(id)
                    .mark(req.getParameter("mark"))
                    .model(req.getParameter("model"))
                    .releaseDate(LocalDateTimeFormatter.format(req.getParameter("releaseDate")))
                    .typeTransport(TypeTransport.valueOf(req.getParameter("typeTransport")))
                    .liftingCapacity(Integer.valueOf(req.getParameter("liftingCapacity")))
                    .cargoCapacity(Integer.valueOf(req.getParameter("cargoCapacity")))
                    .passengerCapacity(Integer.valueOf("passengerCapacity"))
                    .inspectionPermission(LocalDateTimeFormatter.format(req.getParameter("inspectionPermission")))
                    .statusCar(StatusCar.valueOf(req.getParameter("statusCar")))
                    .carDescription(req.getParameter("carDescription"))
                    .build();
            try {
                factoryService.getCarService().update(carDto);
            } catch (ServiceException e) {
                throw new ServletException();
            }
        }
        resp.sendRedirect("Controller?command=gotoallcar");
    }
}
