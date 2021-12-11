package by.epam.jwd.sak.avtobase.service.validator;

import by.epam.jwd.sak.avtobase.dto.RequestDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestValidation {

    private static final String ADDRESS_REGEX = "[А-Яа-яA-Za-z0-9]{5,50}";
    private static final String DATE_REGEX = "^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])" +
            "[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468]" +
            "[048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$";

    private RequestValidation() {
    }

    public static boolean isRequestValid (RequestDto requestDto) {
        if (!(isCorrectAddress(requestDto.getStartAddress())
                || isCorrectDate(String.valueOf(requestDto.getDateDeparture()))
                || isCorrectAddress(requestDto.getEndAddress()))) {
            return false;
        }
        return true;
    }

    private static boolean isCorrectAddress(String address) {
        Pattern pattern = Pattern.compile(ADDRESS_REGEX);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }

    private static boolean isCorrectDate(String date) {
        Pattern pattern = Pattern.compile(DATE_REGEX);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
