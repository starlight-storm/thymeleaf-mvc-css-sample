package sample.customer.values;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sample.util.values.Values;

@Getter
@AllArgsConstructor
public enum CustomerRankValues implements Values {
	PLATINUM("1", "プラチナ"), GOLD("2", "ゴールド"), SILVER("3", "シルバー");

	private final String value;
	private final String text;
}