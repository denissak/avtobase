package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.dao.impl.CarDaoImpl;
import by.epam.jwd.sak.avtobase.dao.impl.CommentDaoImpl;
import by.epam.jwd.sak.avtobase.dao.impl.DriverDaoImpl;
import by.epam.jwd.sak.avtobase.dao.impl.RequestDaoImpl;
import by.epam.jwd.sak.avtobase.dao.impl.UserDaoImpl;

public class DaoFactory {

        private static by.epam.jwd.sak.avtobase.dao.DaoFactory instance = null;
        private final UserDao userDao = new UserDaoImpl();
        private final RequestDao requestDao = new RequestDaoImpl();
        private final CarDao carDao = new CarDaoImpl();
        private final DriverDao driverDao = new DriverDaoImpl();
        private final CommentDao commentDao = new CommentDaoImpl();

        private DaoFactory() {
        }

        public static by.epam.jwd.sak.avtobase.dao.DaoFactory getInstance() {
            by.epam.jwd.sak.avtobase.dao.DaoFactory localInstance = instance;
            if (localInstance == null) {
                synchronized (by.epam.jwd.sak.avtobase.dao.DaoFactory.class) {
                    localInstance = instance;
                    if (localInstance == null) {
                        instance = localInstance = new by.epam.jwd.sak.avtobase.dao.DaoFactory();
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

        public DriverDao getDriverDao() { return driverDao; }

        public CommentDao getCommentDao() { return commentDao; }
}

