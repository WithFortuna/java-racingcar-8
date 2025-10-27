package racingcar.judge;

import java.util.ArrayList;
import java.util.List;

import racingcar.racer.Racer;

public class RaceJudge {
	public static List<Racer> decideWinners(List<Racer> racers) {
		List<Racer> winners = new ArrayList<>();
		int maxDistance = 0;
		for(Racer racer : racers) {
			maxDistance = updateWinnersAndGetMaxDistance(racer, winners, maxDistance);
		}
		return winners;
	}

	private static int updateWinnersAndGetMaxDistance(Racer racer, List<Racer> winners, int maxDistance) {
		if (maxDistance < racer.getMoveForwardDistance()) {
			winners.clear();
			winners.add(racer);

			return racer.getMoveForwardDistance();
		} else if (maxDistance == racer.getMoveForwardDistance()) {
			winners.add(racer);
		}

		return maxDistance;
	}

}
