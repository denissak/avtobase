package by.epam.jwd.sak.avtobase.validator;


import by.epam.jwd.sak.avtobase.dto.UserCreateDto;

public class CreateUserValidator implements Validator<UserCreateDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidationResult isValid(UserCreateDto object) {
        ValidationResult validationResult =new ValidationResult();

        return validationResult;
    }
}
