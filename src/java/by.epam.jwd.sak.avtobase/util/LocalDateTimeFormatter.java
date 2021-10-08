package by.epam.jwd.sak.avtobase.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@UtilityClass
public class LocalDateTimeFormatter {

    private static final String PATTERN = "yyyy-MM-dd'T'HH:mm";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    public LocalDateTime format(String date) {
        return LocalDateTime.parse(date, FORMATTER);
    }

/*    public boolean isValid(String date) {
        try {
            return Optional.ofNullable(date)
                    .map(LocalDateTimeFormatter::format)
                    .isPresent();
        } catch (DateTimeParseException exception) {
            return false;
        }
    }*/
}
