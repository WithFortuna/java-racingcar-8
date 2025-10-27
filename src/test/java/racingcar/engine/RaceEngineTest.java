package racingcar.engine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.racer.Racer;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RaceEngineTest {

	@DisplayName("레이스를 진행하면 실행결과 로그가 생성된다")
	@Test
	void shouldGenerateRacingLog_whenRaceIsExecuted() {
		assertRandomNumberInRangeTest(
			() -> {
				RaceEngine engine = new RaceEngine();
				Racer pobi = new Racer("pobi");
				Racer woni = new Racer("woni");

				StringBuilder log = engine.doRace(1, List.of(pobi, woni));

				assertThat(log.toString())
					.contains("실행결과")
					.contains("pobi : ")
					.contains("woni : ");
			},
			4, 3
		);
	}

	@DisplayName("랜덤 값이 4 이상이면 레이서가 전진한다")
	@Test
	void shouldMoveForward_whenRandomNumberIsGreaterThanOrEqualToFour() {
		assertRandomNumberInRangeTest(
			() -> {
				RaceEngine engine = new RaceEngine();
				Racer pobi = new Racer("pobi");

				engine.doRace(1, List.of(pobi));

				assertThat(pobi.getMoveForwardDistance()).isEqualTo(1);
			},
			4
		);
	}

	@DisplayName("랜덤 값이 4 미만이면 레이서가 전진하지 않는다")
	@Test
	void shouldNotMoveForward_whenRandomNumberIsLessThanFour() {
		assertRandomNumberInRangeTest(
			() -> {
				RaceEngine engine = new RaceEngine();
				Racer pobi = new Racer("pobi");

				engine.doRace(1, List.of(pobi));

				assertThat(pobi.getMoveForwardDistance()).isEqualTo(0);
			},
			3
		);
	}

	@DisplayName("여러 번의 시도를 진행하면 각 시도마다 레이서가 전진할 수 있다")
	@Test
	void shouldMoveForwardMultipleTimes_whenMultipleTrialsAreExecuted() {
		assertRandomNumberInRangeTest(
			() -> {
				RaceEngine engine = new RaceEngine();
				Racer pobi = new Racer("pobi");

				engine.doRace(3, List.of(pobi));

				assertThat(pobi.getMoveForwardDistance()).isEqualTo(3);
			},
			4, 4, 4
		);
	}

	@DisplayName("레이스 로그에 레이서별 전진 거리가 '-' 문자로 표시된다")
	@Test
	void shouldDisplayMoveForwardDistanceWithDash_inRacingLog() {
		assertRandomNumberInRangeTest(
			() -> {
				RaceEngine engine = new RaceEngine();
				Racer pobi = new Racer("pobi");
				Racer woni = new Racer("woni");

				StringBuilder log = engine.doRace(1, List.of(pobi, woni));

				assertThat(log.toString())
					.contains("pobi : -")
					.contains("woni : ");
			},
			4, 3
		);
	}

	@DisplayName("여러 레이서가 동시에 레이스를 진행한다")
	@Test
	void shouldRaceMultipleRacers_simultaneously() {
		assertRandomNumberInRangeTest(
			() -> {
				RaceEngine engine = new RaceEngine();
				Racer pobi = new Racer("pobi");
				Racer woni = new Racer("woni");
				Racer jun = new Racer("jun");

				engine.doRace(2, List.of(pobi, woni, jun));

				assertThat(pobi.getMoveForwardDistance()).isEqualTo(1);
				assertThat(woni.getMoveForwardDistance()).isEqualTo(1);
				assertThat(jun.getMoveForwardDistance()).isEqualTo(1);
			},
			4, 4, 4, 3, 3, 3
		);
	}

}
