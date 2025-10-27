package racingcar.parse;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class NameParserTest {

	@DisplayName("콤마로 구분된 이름들을 리스트로 파싱한다")
	@Test
	void shouldParseNamesToList_whenNamesAreSeparatedByComma() {
		// given
		String participantNames = "pobi,woni,jun";

		// when
		List<String> result = NameParser.parseNamesToList(participantNames);

		// then
		assertThat(result)
			.hasSize(3)
			.containsExactly("pobi", "woni", "jun");
	}

	@DisplayName("단일 이름을 파싱한다")
	@Test
	void shouldParseToSingleElementList_whenSingleNameIsGiven() {
		// given
		String participantNames = "pobi";

		// when
		List<String> result = NameParser.parseNamesToList(participantNames);

		// then
		assertThat(result)
			.hasSize(1)
			.containsExactly("pobi");
	}

	@DisplayName("빈 문자열을 파싱하면 empty인 문자열 요소를 가지는 리스트를 반환한다")
	@Test
	void shouldReturnEmptyList_whenEmptyStringIsGiven() {
		// given
		String participantNames = "";

		List<String> result = NameParser.parseNamesToList(participantNames);

		// then
		assertThat(result)
			.hasSize(1)
			.containsExactly("");
	}

	@DisplayName("공백이 포함된 이름들을 파싱한다")
	@Test
	void shouldParseNames_whenNamesContainSpaces() {
		// given
		String participantNames = "pobi, woni, jun";

		// when
		List<String> result = NameParser.parseNamesToList(participantNames);

		// then
		assertThat(result)
			.hasSize(3)
			.containsExactly("pobi", " woni", " jun");
	}
}
