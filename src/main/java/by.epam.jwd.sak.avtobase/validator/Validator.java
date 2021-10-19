package by.epam.jwd.sak.avtobase.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
