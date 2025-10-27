package racingcar.judge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.racer.Racer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceJudgeTest {

	@DisplayName("전진 거리가 가장 큰 레이서를 우승자로 선정한다")
	@Test
	void shouldDecideWinner_whenOneRacerHasMaxDistance() {
		Racer pobi = new Racer("pobi");
		Racer woni = new Racer("woni");
		Racer jun = new Racer("jun");

		pobi.moveForward();
		pobi.moveForward();
		pobi.moveForward();
		woni.moveForward();
		jun.moveForward();
		jun.moveForward();

		List<Racer> winners = RaceJudge.decideWinners(List.of(pobi, woni, jun));

		assertThat(winners)
			.hasSize(1)
			.containsExactlyInAnyOrder(pobi);
	}

	@DisplayName("전진 거리가 같은 레이서들을 공동 우승자로 선정한다")
	@Test
	void shouldDecideMultipleWinners_whenMultipleRacersHaveSameMaxDistance() {
		Racer pobi = new Racer("pobi");
		Racer woni = new Racer("woni");
		Racer jun = new Racer("jun");

		pobi.moveForward();
		pobi.moveForward();
		pobi.moveForward();
		woni.moveForward();
		woni.moveForward();
		woni.moveForward();
		jun.moveForward();

		List<Racer> winners = RaceJudge.decideWinners(List.of(pobi, woni, jun));

		assertThat(winners)
			.hasSize(2)
			.containsExactlyInAnyOrder(pobi, woni);
	}

	@DisplayName("모든 레이서의 전진 거리가 0이면 모두 우승자로 선정한다")
	@Test
	void shouldDecideAllWinners_whenAllRacersHaveZeroDistance() {
		Racer pobi = new Racer("pobi");
		Racer woni = new Racer("woni");

		List<Racer> winners = RaceJudge.decideWinners(List.of(pobi, woni));

		assertThat(winners)
			.hasSize(2)
			.containsExactlyInAnyOrder(pobi, woni);
	}

	@DisplayName("레이서가 한 명일 때 해당 레이서를 우승자로 선정한다")
	@Test
	void shouldDecideWinner_whenOnlyOneRacerExists() {
		Racer pobi = new Racer("pobi");
		pobi.moveForward();
		pobi.moveForward();

		List<Racer> winners = RaceJudge.decideWinners(List.of(pobi));

		assertThat(winners)
			.hasSize(1)
			.containsExactly(pobi);
	}
}
