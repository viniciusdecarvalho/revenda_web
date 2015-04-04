package br.edu.ftlf.ads.revenda.model;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.format.CPFFormatter;

import com.google.common.base.Strings;

public class CpfCnpjFormatter {

	private String value;
	private CPFFormatter cpfFormatter = new CPFFormatter();
	private CNPJFormatter cnpjFormatter = new CNPJFormatter();
	
	public CpfCnpjFormatter(String value) {
		if (Strings.isNullOrEmpty(value)) {
			throw new NullPointerException("value not must be null or empty");
		}
		this.value = value;
	}
	
	private boolean isCpf(String value) {
		return value.length() == 11;
	}
	
	public String getValueFormatted() {
		if (Strings.isNullOrEmpty(value)) {
			return value;
		}
		
		return isCpf(value) ? cpfFormatter.format(value) : cnpjFormatter.format(value);
	}
	
	public String getValueUnformatted() {
		if (Strings.isNullOrEmpty(value)) {
			return value;
		}
		return isCpf(value) ? cpfFormatter.unformat(value) : cnpjFormatter.unformat(value);
	}
}
