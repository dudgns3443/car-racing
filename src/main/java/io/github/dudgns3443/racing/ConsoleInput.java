package io.github.shirohoo.racing;

import java.util.Scanner;

class ConsoleInput implements Input{
    private static final Scanner SCANNER = new Scanner(System.in);

    public String carNames() {
        return SCANNER.nextLine();
    }

    public int tryCount() {
        return SCANNER.nextInt();
    }
}
