package racingcar.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;

class ConsoleUserInputTest {

	@DisplayName("사용자가 이름과 시행횟수를 입력하면 레이싱 시뮬레이션 요청을 생성한다")
	@Test
	void shouldCreateRacingSimulationRequest() {
		// given
		String participantNames = "pobi,woni";
		String trials = "5";
		String input = participantNames + "\n" + trials + "\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		// when
		RacingSimulationRequest userInput = ConsoleUserInput.getUserInput();

		// then
		assertThat(userInput.participantNames()).isEqualTo(participantNames);
		assertThat(userInput.trials()).isEqualTo(Integer.parseInt(trials));

	}
}
