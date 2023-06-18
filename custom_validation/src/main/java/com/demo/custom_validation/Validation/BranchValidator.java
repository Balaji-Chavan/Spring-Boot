package com.demo.custom_validation.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class BranchValidator implements ConstraintValidator<BranchValidate,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isEmpty()){
            return false;
        }
        List<String> branchList = List.of("CSE","MECH","CIVIL","IT","ENTC","AI","ELECTRICAL");
        value = value.toUpperCase();
        return branchList.contains(value);
    }
}
