package by.epam.jwd.sak.avtobase.service.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
