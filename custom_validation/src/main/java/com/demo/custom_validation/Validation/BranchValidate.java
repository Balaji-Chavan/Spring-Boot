package com.demo.custom_validation.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = BranchValidator.class)
public @interface BranchValidate {
    public String message() default "{Branch is Wrong !! it is either CSE or IT or MECH or CIVIL or ENTC or AI or ELECTRICAL}";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
