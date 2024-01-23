package com.tondeuse.commande;

import com.tondeuse.conf.TestsConfig;
import com.tondeuse.domaine.bean.MouvementsTondeuse;
import com.tondeuse.enums.DirectionEnum;
import com.tondeuse.exception.MauvaisFichierTondeuseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CommanderTondeuseImplTest extends TestsConfig {
    @Autowired
    CommanderTondeuse commanderTondeuse;

    @Test
    public void testCommanderTondeuse() throws MauvaisFichierTondeuseException {

        String nomFichier = "src/test/resources/jdd/tondeuses.txt";
        List<MouvementsTondeuse> tondeuses = commanderTondeuse.executeMvtsTondeuses(nomFichier);

        Assertions.assertEquals(DirectionEnum.N, tondeuses.get(0).tondeuse().getDirectionEnum());
        Assertions.assertEquals(1, tondeuses.get(0).tondeuse().getCoordonnee().getX());
        Assertions.assertEquals(3, tondeuses.get(0).tondeuse().getCoordonnee().getY());

        Assertions.assertEquals(DirectionEnum.E, tondeuses.get(1).tondeuse().getDirectionEnum());
        Assertions.assertEquals(5, tondeuses.get(1).tondeuse().getCoordonnee().getX());
        Assertions.assertEquals(1, tondeuses.get(1).tondeuse().getCoordonnee().getY());
    }

    @Test
    public void testBouger() {
        String nomFichier = "src/test/resources/jdd/tondeuses-1.txt";
        Assertions.assertThrows(MauvaisFichierTondeuseException.class, () -> {
            commanderTondeuse.executeMvtsTondeuses(nomFichier);
        });
    }

    @Test
    public void testCommanderTondeuseHorsPortee() throws MauvaisFichierTondeuseException {

        String nomFichier = "src/test/resources/jdd/tondeuses-2.txt";
        List<MouvementsTondeuse> tondeuses = commanderTondeuse.executeMvtsTondeuses(nomFichier);

        Assertions.assertEquals(DirectionEnum.N, tondeuses.get(0).tondeuse().getDirectionEnum());
        Assertions.assertEquals(5, tondeuses.get(0).tondeuse().getCoordonnee().getX());
        Assertions.assertEquals(5, tondeuses.get(0).tondeuse().getCoordonnee().getY());

        Assertions.assertEquals(DirectionEnum.S, tondeuses.get(1).tondeuse().getDirectionEnum());
        Assertions.assertEquals(0, tondeuses.get(1).tondeuse().getCoordonnee().getX());
        Assertions.assertEquals(0, tondeuses.get(1).tondeuse().getCoordonnee().getY());
    }
}
