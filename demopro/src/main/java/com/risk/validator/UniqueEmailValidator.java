package com.risk.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;





public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	
	@Autowired
	

	@Override
	public void initialize(UniqueEmail is) {
		
		is.message();
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return false;
//		System.out.println(email);
//		System.out.println("1"+(email!=null));
//		boolean e_value=(email!=null);
		//boolean email_value=(service.isEmailAlreadyInUse(email));
		//System.out.println("hry"+!service.isEmailAlreadyInUse(email));
		//System.out.println("final"+(email != null && !service.isEmailAlreadyInUse(email)));
//		boolean val=e_value && email_value;
//		
//		System.out.println("hello"+val);
//		
//		if (email_value) {
//			emailValidation=true;
//		}
		
		//return email_value;
	}

	
}
