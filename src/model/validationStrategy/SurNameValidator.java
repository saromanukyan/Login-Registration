package model.validationStrategy;

public class SurNameValidator implements Validator {

    @Override
    public boolean validate(String text) {
        return text.trim().matches("^[A-Za-z]{2,}$");
    }

    @Override
    public String validationConditions() {
        return "Name and Surname must be\n" +
                "at least 2 characters long\n" +
                "Contains only letter.";
    }
}
