package by.epam.jwd.sak.avtobase.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarValidation {

    private static final String MARK_REGEX = "[А-Яа-яA-Za-z]{2,15}";
    private static final String MODEL_REGEX = "[А-Яа-яA-Za-z0-9]{2,15}";
    private static final String CAPACITY_REGEX = "^[0-9]\\d*(\\d+)?$";

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




}
