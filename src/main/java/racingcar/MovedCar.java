package racingcar;

import java.util.Objects;

public class MovedCar {
    private final String name;
    private final int position;

    public MovedCar(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    boolean hasMax(int max) {
        return max == this.position;
    }

    boolean getMax(int max) {
        return this.position > max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovedCar movedCar = (MovedCar) o;
        return position == movedCar.position &&
                Objects.equals(name, movedCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
