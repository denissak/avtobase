package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetDriverOnCar implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        if (req.getParameter("method") != null) {
            if (req.getParameter("method").equals("delete")) {
                int carId = Integer.parseInt(req.getParameter("id"));
                try {
                    factoryService.getCarService().delete(carId);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
            }
        } else */if
        (req.getMethod().equals("POST")) {
            Integer carId = Integer.valueOf(req.getParameter("carId"));
            Integer driverId = Integer.valueOf(req.getParameter("driver"));
            try {
                factoryService.getCarService().addDriver(driverId, carId);
            } catch (ServiceException e) {
                throw new ServletException(e.getMessage(), e);
            }
            resp.sendRedirect("Controller?command=gotoallcar");
        }
    }
}
