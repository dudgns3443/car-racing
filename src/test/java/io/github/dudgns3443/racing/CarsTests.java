package io.github.shirohoo.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarsTests {
    Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.createCars(List.of(
            Car.from("car1"),
            Car.from("car2"),
            Car.from("car3"),
            Car.from("car4"),
            Car.from("car5")
        ));
    }

    @Test
    void createCars() {
        assertThatCode(() -> {
            Cars.createCars("car1,car2,car3");
        }).doesNotThrowAnyException();
    }

    @NullAndEmptySource
    @ParameterizedTest
    void createCarsExceptionIfInputNullOrEmpty(String carNames) {
        assertThatThrownBy(() -> {
            Cars.createCars(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @MethodSource
    @ParameterizedTest
    void forward(ForwardCondition condition, int expected) {
        assertThat(cars.forward(condition))
            .filteredOn(car -> car.currentPosition() == expected);
    }

    static Stream<Arguments> forward() {
        return Stream.of(
            Arguments.of((ForwardCondition) () -> true, 1),
            Arguments.of((ForwardCondition) () -> false, 0)
        );
    }

    @Test
    void winners() {
        // ...given
        cars.forward(() -> true);
        cars.forward(() -> true);
        cars.forward(() -> true);

        // ...when
        List<Car> winners = cars.winners();

        // ...then
        assertThat(winners).filteredOn(car -> car.currentPosition() == 3);
    }
}
