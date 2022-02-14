package io.github.shirohoo.racing;

import static java.util.Arrays.stream;
import java.util.ArrayList;
import java.util.List;

class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    private Cars(String cars) {
        if (cars == null || cars.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.cars = stream(cars.split(","))
            .map(Car::from)
            .toList();
    }

    public static Cars createCars(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars createCars(String carNames) {
        return new Cars(carNames);
    }

    public List<Car> forward(ForwardCondition condition) {
        cars.forEach(car -> car.forward(condition));
        return new ArrayList<>(cars.stream().map(Car::deepCopy).toList());
    }

    public List<Car> winners() {
        return cars.stream()
            .filter(car -> car.currentPosition() == getMaxPosition())
            .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::currentPosition)
            .reduce(Integer.MIN_VALUE, Integer::max);
    }
}
