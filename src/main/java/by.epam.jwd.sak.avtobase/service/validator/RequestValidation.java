package by.epam.jwd.sak.avtobase.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestValidation {

    private static final String ADDRESS_REGEX = "[А-Яа-яA-Za-z0-9]{5,50}";

    private RequestValidation () {}

    public static boolean isCorrectAddress (String address){
        Pattern pattern = Pattern.compile(ADDRESS_REGEX);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }
}
