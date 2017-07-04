package sample.customer.values;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sample.util.values.Values;

@Getter
@AllArgsConstructor
public enum CustomerSexValues implements Values {
	MALE("1", "MALE"), FEMAIL("2", "FEMALE"), OTHER("3", "OTHER");

	private final String value;
	private final String text;
}