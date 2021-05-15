package model.validationStrategy;

public class EmailValidator implements Validator {
    @Override
    public boolean validate(String text) {
        return text.trim().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    @Override
    public String validationConditions() {
        return "Email address format\n" +
                "prefix@domain.host";
    }
}
