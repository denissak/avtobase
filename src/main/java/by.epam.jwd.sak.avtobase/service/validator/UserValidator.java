package by.epam.jwd.sak.avtobase.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    private static final String LOGIN_REGEX = "[A-Za-z0-9]{5,15}";
    private static final String NAME_REGEX = "[А-Яа-яA-Za-z]{2,15}";
    private static final String SURNAME_REGEX = "[А-Яа-яA-Za-z]{2,30}";
    private static final String PHONE_NUMBER_REGEX = "^\\+375(17|29|33|44)[0-9]{7}$";

    private UserValidator() {
    }

    public static boolean isCorrectLogin(String login) {
        Pattern pattern = Pattern.compile(LOGIN_REGEX);
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }

    public static boolean isCorrectName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean isCorrectSurname(String surname) {
        Pattern pattern = Pattern.compile(SURNAME_REGEX);
        Matcher matcher = pattern.matcher(surname);
        return matcher.matches();
    }

    public static boolean isCorrectPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }


}
