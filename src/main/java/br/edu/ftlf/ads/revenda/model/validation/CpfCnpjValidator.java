package br.edu.ftlf.ads.revenda.model.validation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.vraptor.environment.Environment;

import com.google.common.base.Strings;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String> {

	private final Environment environment;

	protected CpfCnpjValidator() {
		this(null);
	}
	
	@Inject
	public CpfCnpjValidator(Environment environment) {
		this.environment = environment;
	}
	
	@Override
	public void initialize(CpfCnpj constraintAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (Strings.isNullOrEmpty(value)) {
			return true;
		}
		
		String withValidation = environment.get("cpf_cnpj_validation", "0");
		
		if (!Boolean.getBoolean(withValidation)) {
			return true;
		}
		
		String cpfCnpj = value.replace(".", "").replace("-", "").replace("/", "");
		
		if (cpfCnpj.length() == 11) {
			context.buildConstraintViolationWithTemplate("{org.hibernate.validator.constraints.br.CPF.message}");
			CPFValidator cpfValidator = new CPFValidator();
			cpfValidator.assertValid(value);
			return cpfValidator.invalidMessagesFor(value).isEmpty();
		} else if(cpfCnpj.length() == 14) {
			context.buildConstraintViolationWithTemplate("{org.hibernate.validator.constraints.br.CNPJ.message}");
			CNPJValidator cnpjValidator = new CNPJValidator();
			cnpjValidator.assertValid(value);
			return cnpjValidator.invalidMessagesFor(value).isEmpty();
		}
		
		return false;
	}

}
