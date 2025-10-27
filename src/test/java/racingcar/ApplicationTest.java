package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("전진거리가 더 큰 레이서가 우승한다")
    @Test
    void should_win_the_race_if_moving_distance_is_bigger() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @DisplayName("전진거리의 최대값이 동일한 레이서가 있다면 공동 우승한다")
    @Test
    public void shouldWinSameTime_whenMovingDistanceIsSame() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
            },
            4, 4
        );
    }

    @DisplayName("이름의 길이가 5자 이상이면 레이서 등록이 불가능하다")
    @Test
    void shouldNotSetupRacers_whenNameLengthIsOverFive() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("공백을 포함한 이름의 길이가 5자 이상이면 레이서 등록이 불가능하다")
    @Test
    void shouldNotSetupRacers_whenNameLengthIsOverFiveWithBlank() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,java5 ", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("공백을 포함한 이름의 길이가 5자 이상이면 레이서 등록이 불가능하다")
    @Test
    void shouldNotSetupRacers_whenNameIsBlank() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,java5,,olaf ", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이서의 이름은 공백일 수 없습니다")
        );

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
