package model.validationStrategy;

public class Context {
    private Validator validator;

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public boolean isNotValid(String text) {
        return !validator.validate(text);
    }

    public String validationConditons() {
        return validator.validationConditions();
    }

}
