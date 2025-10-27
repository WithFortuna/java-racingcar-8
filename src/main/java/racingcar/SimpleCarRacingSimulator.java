package racingcar;

import java.util.ArrayList;
import java.util.List;

import javax.xml.validation.Validator;

import racingcar.engine.RaceEngine;
import racingcar.input.ConsoleUserInput;
import racingcar.input.RacingSimulationRequest;
import racingcar.judge.RaceJudge;
import racingcar.parse.NameParser;
import racingcar.racer.Racer;
import racingcar.validator.NameValidator;

public class SimpleCarRacingSimulator {
	private RaceEngine raceEngine = new RaceEngine();
	private List<Racer> racers = new ArrayList<>();
	private int trials;

	public void simulateRace() {
		setupPreConfiguration();

		StringBuilder racingResults = raceEngine.doRace(trials, racers);
		System.out.print(racingResults);

		List<Racer> winners = RaceJudge.decideWinners(racers);
		System.out.print("최종 우승자 : " + String.join(", ", winners.stream().map(Racer::getName).toList()));
	}

	private void setupPreConfiguration() {
		RacingSimulationRequest request = ConsoleUserInput.getUserInput();
		setupRacers(request.participantNames());
		setupTrials(request.trials());
	}

	private void setupTrials(int trials) {
		this.trials = trials;
	}

	private void setupRacers(String participantNames) {
		List<String> nameList = NameParser.parseNamesToList(participantNames);

		nameList.forEach(name -> {
			NameValidator.validate(name);
			racers.add(new Racer(name));
		});
	}

}
