package sample.customer.util.values;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sample.common.util.values.Values;

@Getter
@AllArgsConstructor
public enum CustomerGraduateValues implements Values {
	JAPAN("1", "日本"), OTHER("2", "日本以外");

	private final String value;
	private final String text;
}