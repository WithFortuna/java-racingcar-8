package racingcar.engine;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.racer.Racer;

public class RaceEngine {
	private static final int MOVE_FORWARD_STANDARD = 4;

	private final StringBuilder racingLog = new StringBuilder();

	public StringBuilder doRace(int trials, List<Racer> racers) {
		racingLog.append("실행결과\n");
		for (int trial = 0; trial < trials; trial++) {
			doEachTrial(racers);
		}
		return racingLog;
	}

	private void doEachTrial(List<Racer> racers) {
		for (Racer racer : racers) {
			moveForwardIfGreaterThanOrEqualTo(racer, MOVE_FORWARD_STANDARD);
			writeMoveTrace(racer);
		}
		racingLog.append("\n");
	}

	private void writeMoveTrace(Racer racer) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < racer.getMoveForwardDistance(); j++) {
			sb.append("-");
		}
		racingLog.append(racer.getName() + " : " + sb + "\n");
	}

	private void moveForwardIfGreaterThanOrEqualTo(Racer racer, int forwardStandard) {
		if (Randoms.pickNumberInRange(0, 9) >= forwardStandard) {
			racer.moveForward();
		}
	}

}
