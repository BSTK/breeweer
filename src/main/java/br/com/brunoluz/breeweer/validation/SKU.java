package br.com.brunoluz.breeweer.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = {})
@Pattern(regexp = "([a-zA-Z]{2}\\d{4})?")
public @interface SKU {
	
	/**
	 * TODO: @Constraint(validatedBy = {})
	 */
	
	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "O SKU deve conter 2 letras e 4 números. Ex: AA1234";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
