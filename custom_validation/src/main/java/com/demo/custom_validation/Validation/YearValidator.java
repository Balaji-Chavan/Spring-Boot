package com.demo.custom_validation.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class YearValidator implements ConstraintValidator<YearValidate, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value>=1 && value<=4){
            return  true;
        }
        return  false;
    }
}
