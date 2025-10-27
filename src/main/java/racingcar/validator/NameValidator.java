package racingcar.validator;

public class NameValidator {
	public static void validate(String name) {
		validateNameSize(name);
	}

	private static void validateNameSize(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("이름의 길이는 최대 5자입니다");
		} else if (name.isBlank()) {
			throw new IllegalArgumentException("레이서의 이름은 공백일 수 없습니다");
		}
	}
}
