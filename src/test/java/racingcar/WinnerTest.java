package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Winner.findWinner;

public class WinnerTest {
    @Test
    void 우승자_구하기() {
        MovedCar pobi = new MovedCar("pobi", 4);
        List<MovedCar> cars = Arrays.asList(pobi, new MovedCar("crong", 3));
        assertThat(findWinner(cars)).isEqualTo(pobi);

        cars = Arrays.asList(new MovedCar("crong", 3), pobi);
        assertThat(findWinner(cars)).isEqualTo(pobi);
    }
}
