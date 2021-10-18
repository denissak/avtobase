package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.service.impl.CarServiceImpl;
import by.epam.jwd.sak.avtobase.service.impl.CommentServiceImpl;
import by.epam.jwd.sak.avtobase.service.impl.DriversRequestsServiceImpl;
import by.epam.jwd.sak.avtobase.service.impl.RequestServiceImpl;
import by.epam.jwd.sak.avtobase.service.impl.RolesServiceImpl;
import by.epam.jwd.sak.avtobase.service.impl.UserServiceImpl;

public class FactoryService {

    private static FactoryService instance = null;

    private UserService userService = new UserServiceImpl();
    private RequestService requestService = new RequestServiceImpl();
    private CarService carService = new CarServiceImpl();
    private CommentService commentService = new CommentServiceImpl();
    private RolesService rolesService = new RolesServiceImpl();
    private DriversRequestsService driversRequestsService = new DriversRequestsServiceImpl();

    public static FactoryService getInstance() {
        FactoryService localInstance = instance;
        if (localInstance == null) {
            synchronized (FactoryService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new FactoryService();
                }
            }
        }
        return localInstance;
    }

    private FactoryService() {
    }

    public UserService getUserService() {
        return userService;
    }

    public RequestService getRequestService() {
        return requestService;
    }

    public CarService getCarService() {
        return carService;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public RolesService getRolesService() {
        return rolesService;
    }

    public DriversRequestsService getDriversRequestsService() {
        return driversRequestsService;
    }
}
