package io.github.shirohoo.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private final Input input;
    private final Output output;
    private final ForwardCondition condition;

    private Game(ApplicationType type, ForwardCondition condition) {
        Objects.requireNonNull(condition);
        this.input = IOFactory.getInput(type);
        this.output = IOFactory.getOutput(type);
        this.condition = condition;
    }

    public static Game of(ApplicationType type, ForwardCondition condition) {
        return new Game(type, condition);
    }

    public void start() {
        output.setCarNamesMessage();
        Cars cars = Cars.createCars(input.carNames());

        output.setTryCountMessage();
        int tryCount = input.tryCount();

        output.showRoundMessage(roundStart(cars, tryCount));

        output.showResultMessage(cars);
    }

    private List<List<Car>> roundStart(Cars cars, int tryCount) {
        List<List<Car>> roundInfo = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            List<Car> roundResult = cars.forward(condition);
            roundInfo.add(roundResult);
        }
        return roundInfo;
    }
}
