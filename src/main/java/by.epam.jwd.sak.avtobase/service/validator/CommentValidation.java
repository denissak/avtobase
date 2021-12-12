package by.epam.jwd.sak.avtobase.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides support for Comment validation.
 *
 */

public class CommentValidation {

    private static final String MARK_REGEX = "^[1-5]{1}\\d*(\\d+)?$";

    private CommentValidation() {
    }

    public static boolean isCorrectMark(Integer mark) {
        String stringMark = String.valueOf(mark);
        Pattern pattern = Pattern.compile(MARK_REGEX);
        Matcher matcher = pattern.matcher(stringMark);
        return matcher.matches();
    }
}
