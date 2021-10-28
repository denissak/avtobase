package by.epam.jwd.sak.avtobase.controller.impl;

import by.epam.jwd.sak.avtobase.dao.CarDao;
import by.epam.jwd.sak.avtobase.dto.CarDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.controller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

public class AllRequest implements Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute(ALL_REQUEST, factoryService.getRequestService().findAllRequest());
            req.setAttribute(USER_DRIVERS, factoryService.getCarService().findAllFreeDriver());
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new ServletException(e.getMessage(), e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PAGE_ALL_REQUEST);
        requestDispatcher.forward(req,resp);
    }
    }

