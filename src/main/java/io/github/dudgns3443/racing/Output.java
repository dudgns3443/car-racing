package io.github.shirohoo.racing;

import java.util.List;

interface Output {
    void setCarNamesMessage();

    void setTryCountMessage();

    void showRoundMessage(List<List<Car>> roundInfo);

    void showResultMessage(Cars cars);
}
