package com.demo.custom_validation.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = YearValidator.class)
public @interface YearValidate {

    public String message() default "Year must be between 1 to 4 ";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
