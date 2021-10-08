package by.epam.jwd.sak.avtobase.validator;


import by.epam.jwd.sak.avtobase.dto.UserDto;

public class CreateUserValidator implements Validator<UserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidationResult isValid(UserDto object) {
        ValidationResult validationResult =new ValidationResult();

        return validationResult;
    }
}
