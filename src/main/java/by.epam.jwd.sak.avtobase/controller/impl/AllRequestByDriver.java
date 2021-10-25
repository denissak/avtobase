package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.bean.DriverRequest;
import by.epam.jwd.sak.avtobase.controller.Command;
import by.epam.jwd.sak.avtobase.dto.DriverRequestDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class AllRequestByDriver implements Command {

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto user = (UserDto) req.getSession().getAttribute(USER);
        Long driverId = user.getId();

        try {
            /*List<DriverRequestDto> a = factoryService.getDriversRequestsService().findAllRequestByDriver(driverId);*/

            req.setAttribute(ALL_REQUEST_BY_DRIVER, factoryService.getDriversRequestsService().findAllRequestByDriver(driverId));
/*            req.setAttribute(USER_DRIVERS, factoryService.getUserService().findAllDrivers());*/
        } catch (ServiceException e) {
            throw new ServletException(e.getMessage(), e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PAGE_ALL_REQUEST_BY_DRIVER);
        requestDispatcher.forward(req,resp);
    }
}
