package model.validationStrategy;

public class PasswordValidator implements Validator {

    @Override
    public boolean validate(String text) {
        return text.matches("^(?=(.*[0-9]){3})(?=(.*[A-Z]){2})(?!(.*\\s)).{9,}$");
    }

    @Override
    public String validationConditions() {
        return "Password must contain\n" +
                "at least 9 characters,\n" +
                "at least 3 numbers,\n" +
                "at least 2 Uppercase letters.\n" +
                "Password can't contain whitespaces.";
    }
}
