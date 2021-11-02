package by.epam.jwd.sak.avtobase.controller.mapping;

public final class CommandParameter {

    public static final String ID = "id";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String ROLE = "role";
    public static final String METHOD = "method";
    public static final String POST = "POST";
    public static final String DELETE = "delete";
    public static final String MARK = "mark";
    public static final String MODEL = "model";
    public static final String MESSAGE = "message";
    public static final String START_ADDRESS = "startAddress";
    public static final String END_ADDRESS = "endAddress";
    public static final String DATE_DEPARTURE = "dateDeparture";
    public static final String DETAILS_REQUEST = "detailsRequest";
    public static final String RELEASE_DATE = "releaseDate";
    public static final String TYPE_TRANSPORT = "typeTransport";
    public static final String TYPE_TRANSPORTS = "typeTransports";
    public static final String LIFTING_CAPACITY = "liftingCapacity";
    public static final String CARGO_CAPACITY = "cargoCapacity";
    public static final String PASSENGER_CAPACITY = "passengerCapacity";
    public static final String INSPECTION_PERMISSION = "inspectionPermission";//
    public static final String STATUS_CAR = "statusCar";
    public static final String STATUS_CARS = "statusCars";
    public static final String STATUS_REQUEST = "statusRequest";
    public static final String STATUS_REQUESTS = "statusRequests";
    public static final String CAR_DESCRIPTION = "carDescription";
    public static final String ALL_CAR = "allCar";
    public static final String USER_DRIVERS = "userDrivers";
    public static final String ALL_COMMENT = "allComment";
    public static final String ALL_DRIVER = "allDriver";
    public static final String ALL_REQUEST = "allRequest";
    public static final String ALL_REQUEST_BY_DRIVER = "allRequestByDriver";
    public static final String ALL_USER = "allUser";
    public static final String USER = "user";
    public static final String DISPATCHER = "dispatcher";
    public static final String ADMIN = "admin";
    public static final String DRIVER = "driver";
    public static final String ROLES = "roles";
    public static final String COMMENT_BY_ID = "commentsById";
    public static final String REQUEST_BY_ID = "requestsById";
    public static final String REQUEST_ID = "requestId";
    public static final String NUMBER_OF_PAGES = "numberOfPages";
    public static final String USER_DISPLAY = "usersDisplay";
    public static final String CAR_ID = "carId";
    public static final String STATUS = "status";
    public static final String PAGE = "page";



    public static final String COMMAND_ALL_CAR= "Controller?command=allcar&page=1";
    public static final String COMMAND_ALL_USER_REQUEST = "Controller?command=alluserrequest";
    public static final String COMMAND_ALL_USER = "Controller?command=alluser&page=1";
    public static final String COMMAND_ALL_REQUEST = "Controller?command=allrequest&page=1";
    public static final String COMMAND_ALL_REQUEST_BY_DRIVER  = "Controller?command=allrequestbydriver";
    public static final String COMMAND_LOGIN  = "Controller?command=login";



    public static final String PAGE_ALL_CAR = "/WEB-INF/jsp/allCar.jsp";
    public static final String PAGE_ALL_COMMENT = "/WEB-INF/jsp/allComment.jsp";
    public static final String PAGE_ALL_DRIVER = "/WEB-INF/jsp/allDriver.jsp";
    public static final String PAGE_ALL_REQUEST = "/WEB-INF/jsp/allRequest.jsp";
    public static final String PAGE_ALL_USER = "/WEB-INF/jsp/allUser.jsp";
    public static final String PAGE_ALL_USER_REQUEST = "/WEB-INF/jsp/allUserRequest.jsp";
    public static final String PAGE_ALL_COMMENT_BY_USER = "/WEB-INF/jsp/allCommentByUser.jsp";
    public static final String PAGE_ALL_REQUEST_BY_DRIVER = "/WEB-INF/jsp/allRequestByDriver.jsp";


    public static final String ACCESS_ALL_CAR = "command=allcar";
    public static final String ACCESS_ALL_COMMENT = "command=allcomment";
    public static final String ACCESS_ALL_DRIVER = "command=alldriver";
    public static final String ACCESS_ALL_REQUEST = "command=allrequest";
    public static final String ACCESS_ALL_REQUESTBYDRIVER = "command=allrequestbydriver";
    public static final String ACCESS_ALL_USER = "command=alluser";// TODO
    public static final String ACCESS_ALL_USER_COMMENT = "command=allusercomment";
    public static final String ACCESS_ALL_USER_REQUEST = "command=alluserrequest";
    public static final String ACCESS_CREATE_CAR = "command=createcar";
    public static final String ACCESS_CREATE_COMMENT = "command=createcomment";
    public static final String ACCESS_CREATE_REQUEST = "command=createrequest";
    public static final String ACCESS_EDIT_CAR = "command=editcar";
    public static final String ACCESS_EDIT_REQUEST_BY_USER = "command=editrequestbyuser";
    public static final String ACCESS_EDIT_STATUS_CAR = "command=editstatuscar";
    public static final String ACCESS_EDIT_STATUS_REQUEST_BY_DRIVER = "command=editstatusrequestbydriver";
    public static final String ACCESS_EDIT_USER_BY_ADMIN = "command=edituserbyadmin";
    public static final String ACCESS_LANGUAGE = "command=language";
    public static final String ACCESS_LOGIN = "command=login";
    public static final String ACCESS_LOGOUT = "command=logout";
    public static final String ACCESS_REGISTRATION = "command=registration";
    public static final String ACCESS_SET_DRIVER_ON_CAR = "command=setdriveroncar";
    public static final String ACCESS_SET_DRIVER_ON_REQUEST = "command=setdriveronrequest";

    private CommandParameter() {
    }
}
