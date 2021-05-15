package model.validationStrategy;

public class UserNameValidator implements Validator {

    @Override
    public boolean validate(String text) {
        return text.trim().matches("^[A-Za-z]\\w{10,}$");
    }

    @Override
    public String validationConditions() {
        return "Username consists at least 11 characters.\n" +
                "First character of the username must be a letter.\n" +
                "Contain only alphanumeric characters and underscores.";
    }
}
