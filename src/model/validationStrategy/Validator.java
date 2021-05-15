package model.validationStrategy;

public interface Validator {

    boolean validate(String text);

    String validationConditions();
}
