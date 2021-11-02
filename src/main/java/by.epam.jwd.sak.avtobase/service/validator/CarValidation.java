package by.epam.jwd.sak.avtobase.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarValidation {

    private static final String MARK_REGEX = "[А-Яа-яA-Za-z]{2,15}";
    private static final String MODEL_REGEX = "[А-Яа-яA-Za-z0-9]{2,15}";
    private static final String CAPACITY_REGEX = "^[0-9]\\d*(\\d+)?$";
    private static final String DATE_REGEX = "^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])" +
            "[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468]" +
            "[048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$";


    private CarValidation(){}

    public static boolean isCorrectMark (String mark){
        Pattern pattern = Pattern.compile(MARK_REGEX);
        Matcher matcher = pattern.matcher(mark);
        return matcher.matches();
    }

    public static boolean isCorrectModel (String model){
        Pattern pattern = Pattern.compile(MODEL_REGEX);
        Matcher matcher = pattern.matcher(model);
        return matcher.matches();
    }

    public static boolean isCorrectCapacity (Integer capacity){
        String stringCapacity = String.valueOf(capacity);
        Pattern pattern = Pattern.compile(CAPACITY_REGEX);
        Matcher matcher = pattern.matcher(stringCapacity);
        return matcher.matches();
    }

    public static boolean isCorrectDate (String date){
        Pattern pattern = Pattern.compile(DATE_REGEX);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }




}
