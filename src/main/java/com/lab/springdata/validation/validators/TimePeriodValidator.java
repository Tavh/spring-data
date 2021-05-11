package com.lab.springdata.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lab.springdata.dto.TimePeriod;
import com.lab.springdata.validation.annotations.ValidTimePeriod;

public class TimePeriodValidator implements ConstraintValidator<ValidTimePeriod, TimePeriod> {

	 public void initialize(ValidTimePeriod constraintAnnotation) {}
	 
	 @Override
	 public boolean isValid(TimePeriod timePeriod, ConstraintValidatorContext context) {
		 context.getDefaultConstraintMessageTemplate();
		 return timePeriod.getStartYear() < timePeriod.getEndYear(); 
	 }

}