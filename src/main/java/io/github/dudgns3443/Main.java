package io.github.shirohoo;

import io.github.shirohoo.racing.ApplicationType;
import io.github.shirohoo.racing.Game;
import io.github.shirohoo.racing.RandomForwardCondition;

public class Main {
    public static void main(String[] args) {
        Game.of(ApplicationType.CONSOLE, new RandomForwardCondition())
            .start();
    }
}
