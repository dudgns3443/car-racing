package io.github.shirohoo.racing;

import java.util.List;
import java.util.stream.Collectors;

class ConsoleOutput implements Output{
    private static final String NEW_LINE = System.lineSeparator();

    public void setCarNamesMessage() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void setTryCountMessage() {
        println("시도할 회수는 몇회인가요?");
    }

    public void showRoundMessage(List<List<Car>> roundInfo) {
        StringBuilder sb = new StringBuilder(NEW_LINE)
            .append("실행 결과")
            .append(NEW_LINE);

        for (List<Car> cars : roundInfo) {
            for (Car car : cars) {
                String carName = car.name();
                int currentPosition = car.currentPosition();
                sb.append(String.format("%s : %s%s", carName, convertSymbol(currentPosition), NEW_LINE));
            }
            sb.append(NEW_LINE);
        }
        print(sb.toString());
    }

    private String convertSymbol(int currentPosition) {
        return "-".repeat(currentPosition);
    }

    public void showResultMessage(Cars cars) {
        println(String.format("%s가 최종 우승했습니다.", convertWinnersString(cars.winners())));
    }

    private String convertWinnersString(List<Car> winners) {
        return winners.stream()
            .map(Car::name)
            .collect(Collectors.joining(", "));
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
