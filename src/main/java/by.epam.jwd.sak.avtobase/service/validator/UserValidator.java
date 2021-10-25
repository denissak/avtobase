package by.epam.jwd.sak.avtobase.service.validator;

import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dao.UserDao;
import by.epam.jwd.sak.avtobase.dao.impl.UserDaoImpl;
import by.epam.jwd.sak.avtobase.dto.UserDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    private static final UserDao USER_DAO = DaoFactory.getInstance().getUserDao();

    private static final String LOGIN_REGEX = "[A-Za-z0-9]{5,15}";

    private UserValidator() {
    }

    public static boolean isCorrectLogin (String login){
        Pattern pattern = Pattern.compile(LOGIN_REGEX);
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }
}
