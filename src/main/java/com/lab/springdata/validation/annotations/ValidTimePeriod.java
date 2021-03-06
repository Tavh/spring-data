package com.lab.springdata.validation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lab.springdata.validation.validators.TimePeriodValidator;

@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { TimePeriodValidator.class })
public @interface ValidTimePeriod {

    String message() default "Invalid time period!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
