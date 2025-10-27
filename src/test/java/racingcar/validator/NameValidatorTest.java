package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameValidatorTest {

	@DisplayName("이름의 길이가 5자 이하면 검증에 성공한다")
	@Test
	void shouldPass_whenNameLengthIsLessThanOrEqualToFive() {
		assertThatCode(() -> NameValidator.validate("pobi"))
			.doesNotThrowAnyException();

		assertThatCode(() -> NameValidator.validate("abcde"))
			.doesNotThrowAnyException();
	}

	@DisplayName("이름의 길이가 5자를 초과하면 예외가 발생한다")
	@Test
	void shouldThrowException_whenNameLengthIsOverFive() {
		assertThatThrownBy(() -> NameValidator.validate("javaji"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름의 길이는 최대 5자입니다");
	}

	@DisplayName("빈 문자열은 예외가 발생한다")
	@Test
	void shouldThrowException_whenNameIsEmpty() {
		assertThatThrownBy(() -> NameValidator.validate(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("레이서의 이름은 공백일 수 없습니다");
	}
}
