package br.edu.ftlf.ads.revenda.model.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { CpfCnpjValidator.class })
@Documented
public @interface CpfCnpj {

	String message() default "{br.edu.ftlf.ads.revenda.model.validation.cpfCnpj.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}
