package com.demo.custom_validation.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeValidate, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        if(value>=18 && value<=26)
            return true;

        return false;
    }
}
