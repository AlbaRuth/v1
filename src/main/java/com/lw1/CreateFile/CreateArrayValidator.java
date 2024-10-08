package com.lw1.CreateFile;

public class CreateArrayValidator {
	private static final String REGEXP_INPUT_LINE = "\\d+(\\s+\\d+)*";

	public static boolean RegExpValidator(String inputLine) {
		return inputLine.matches(REGEXP_INPUT_LINE);
	}
}
