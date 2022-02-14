package io.github.shirohoo.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleGameTests {
    Input input;
    Output output;

    @BeforeEach
    void setUp() {
        input = new ConsoleInput();
        output = new ConsoleOutput();
    }

    @Test
    void createGameWithApplicationType() {
        assertThatCode(() -> {
            Game game = Game.of(ApplicationType.CONSOLE, () -> true);
            assertThat(game).isNotNull();
        }).doesNotThrowAnyException();
    }
}
