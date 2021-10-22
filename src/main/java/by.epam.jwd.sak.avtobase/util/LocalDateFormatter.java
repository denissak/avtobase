package by.epam.jwd.sak.avtobase.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class LocalDateFormatter {

    private static final String PATTERN = "yyyy-MM-dd'T'HH:mm";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    public LocalDateTime format(String date) {
        return LocalDateTime.parse(date, FORMATTER);
    }
}
