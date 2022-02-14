package io.github.shirohoo.racing;

final class IOFactory {
    public static Input getInput(ApplicationType type) {
        return switch (type) {
            case CONSOLE -> new ConsoleInput();
        };
    }

    public static Output getOutput(ApplicationType type) {
        return switch (type) {
            case CONSOLE -> new ConsoleOutput();
        };
    }
}
