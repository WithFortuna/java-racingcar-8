package racingcar.racer;

public class Racer {
	private String name;
	private int moveForwardDistance = 0;

	public Racer(String name) {
		this.name = name;
	}

	public void moveForward() {
		moveForwardDistance++;
	}

	public String getName() {
		return name;
	}

	public int getMoveForwardDistance() {
		return moveForwardDistance;
	}
}
