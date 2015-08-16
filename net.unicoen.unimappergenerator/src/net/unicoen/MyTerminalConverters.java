package net.unicoen;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

import com.google.inject.Inject;

public class MyTerminalConverters extends DefaultTerminalConverters {
	@Inject
	private MyStringValueConverter myStringValueConverter;

	@ValueConverter(rule = "STRING")
	public IValueConverter<String> STRING() {
		return myStringValueConverter;
	}
}