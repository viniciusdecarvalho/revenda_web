package br.edu.ftlf.ads.revenda.specialize;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;

import com.google.common.base.Strings;

@Convert(Date.class)
@Specializes
public class DateConverter extends br.com.caelum.vraptor.converter.DateConverter {  
  
	/**
	 * @deprecated cdi eyes only
	 */
	protected DateConverter() {
		this(null);
	}
	
	@Inject
	public DateConverter(Locale locale) {
		super(locale);
	}
	
    @Override  
    public Date convert(String value, Class<? extends Date> type) {
    	if (Strings.isNullOrEmpty(value)) {
    		return null;
    	}
        try {
        	if (value.contains("-")) {
        		return new SimpleDateFormat("yyyy-MM-dd").parse(value);
        	}
        	return getDateFormat().parse(value);
        	
		} catch (ParseException e) {
			throw new ConversionException(new ConversionMessage(INVALID_MESSAGE_KEY, value));
		}
    }  
    
}