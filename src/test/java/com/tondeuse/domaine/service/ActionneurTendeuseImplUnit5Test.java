package com.tondeuse.domaine.service;

import com.tondeuse.conf.TestsConfig;
import com.tondeuse.domaine.bean.Coordonnee;
import com.tondeuse.domaine.bean.Pelouse;
import com.tondeuse.domaine.bean.Tondeuse;
import com.tondeuse.enums.ActionsEnum;
import com.tondeuse.enums.DirectionEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionneurTendeuseImplUnit5Test extends TestsConfig {

    Pelouse pelouse = new Pelouse(new Coordonnee(5, 5));
    @Autowired
    ActionneurTondeuse actionneurTondeuse;

    // example with ParameterizedTest
    @ParameterizedTest
    @CsvSource({
            "1, 3, E, A, 2, 3, E",
            "1, 3, W, A, 0, 3, W",
            "1, 5, N, A, 1, 5, N",
            "1, 3, E, G, 1, 3, N",
            "1, 3, E, D, 1, 3, S",
            "1, 3, S, G, 1, 3, E",
            "1, 3, S, D, 1, 3, W"
    })
    void testExecuteAction(int x, int y, char direction, char act, int x1, int y1, char direction1) {


        Tondeuse tondeuse = new Tondeuse(new Coordonnee(x, y), DirectionEnum.directionFromChar(direction));
        ActionsEnum action = ActionsEnum.recupererActionDeCode(String.valueOf(act));

        actionneurTondeuse.executeAction(pelouse, tondeuse, action);

        Assertions.assertEquals(x1, tondeuse.getCoordonnee().getX());
        Assertions.assertEquals(y1, tondeuse.getCoordonnee().getY());
        Assertions.assertEquals(DirectionEnum.directionFromChar(direction1), tondeuse.getDirectionEnum());
    }
}
