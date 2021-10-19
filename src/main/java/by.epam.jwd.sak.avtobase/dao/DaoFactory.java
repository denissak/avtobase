package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.dao.impl.*;

public class DaoFactory {

        private static DaoFactory instance = null;
        private final UserDao userDao = new UserDaoImpl();
        private final RequestDao requestDao = new RequestDaoImpl();
        private final CarDao carDao = new CarDaoImpl();
        private final CommentDao commentDao = new CommentDaoImpl();
        private final RolesDao rolesDao = new RolesDaoImpl();
        private final DriversRequestsDao driversRequestsDao = new DriversRequestsDaoImpl();

        private DaoFactory() {
        }

        public static DaoFactory getInstance() {
            DaoFactory localInstance = instance;
            if (localInstance == null) {
                synchronized (DaoFactory.class) {
                    localInstance = instance;
                    if (localInstance == null) {
                        instance = localInstance = new DaoFactory();
                    }
                }
            }
            return localInstance;
        }

        public UserDao getUserDao() {
            return userDao;
        }

        public RequestDao getRequestDao(){
            return requestDao;
        }

        public CarDao getCarDao() { return carDao; }

        public CommentDao getCommentDao() { return commentDao; }

        public RolesDao getRolesDao() { return rolesDao; }

        public DriversRequestsDao getDriversRequestsDao() { return driversRequestsDao; }
}

