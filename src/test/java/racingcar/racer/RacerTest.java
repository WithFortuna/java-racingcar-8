package racingcar.racer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacerTest {

	@DisplayName("레이서 생성 시 전진 거리는 0이다")
	@Test
	void shouldInitializeMoveForwardDistanceAsZero_whenRacerIsCreated() {
		Racer racer = new Racer("pobi");

		assertThat(racer.getMoveForwardDistance()).isEqualTo(0);
	}

	@DisplayName("전진하면 전진 거리가 1 증가한다")
	@Test
	void shouldIncreaseMoveForwardDistance_whenMoveForward() {
		Racer racer = new Racer("pobi");

		racer.moveForward();

		assertThat(racer.getMoveForwardDistance()).isEqualTo(1);
	}

	@DisplayName("전진을 여러 번 수행하면 전진 거리가 누적된다")
	@Test
	void shouldAccumulateMoveForwardDistance_whenMoveForwardMultipleTimes() {
		Racer racer = new Racer("pobi");

		racer.moveForward();
		racer.moveForward();
		racer.moveForward();

		assertThat(racer.getMoveForwardDistance()).isEqualTo(3);
	}
}
