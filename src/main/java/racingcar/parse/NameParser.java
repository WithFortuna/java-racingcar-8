package racingcar.parse;

import java.util.Arrays;
import java.util.List;


public class NameParser {
	public static List<String> parseNamesToList(String participantNames) {
		return Arrays.asList(participantNames.split(","));
	}
}
