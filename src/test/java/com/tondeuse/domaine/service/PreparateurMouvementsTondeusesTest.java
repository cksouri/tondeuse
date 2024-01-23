package com.tondeuse.domaine.service;

import com.tondeuse.conf.TestsConfig;
import com.tondeuse.domaine.bean.Coordonnee;
import com.tondeuse.domaine.bean.MouvementsTondeuse;
import com.tondeuse.domaine.bean.Pelouse;
import com.tondeuse.domaine.bean.Tondeuse;
import com.tondeuse.enums.DirectionEnum;
import com.tondeuse.exception.MauvaisFichierTondeuseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PreparateurMouvementsTondeusesTest extends TestsConfig {

    @Autowired
    private PreparateurMouvementsTondeuses preparateurMouvementsTondeuses;

    @Test
    public void testRecupererMvtsTondeuses() throws MauvaisFichierTondeuseException {
        String mouvement = "GAGAGAGAA";
        List<String> lingnesTondeuse = List.of("5 5", "1 2 N", mouvement);

        List<MouvementsTondeuse> mvts = preparateurMouvementsTondeuses.recupererMvtsTondeuses(lingnesTondeuse);

        Assertions.assertEquals(new Pelouse(new Coordonnee(5, 5)), mvts.get(0).pelouse());
        Assertions.assertEquals(new Tondeuse(new Coordonnee(1,2), DirectionEnum.N), mvts.get(0).tondeuse());
        Assertions.assertEquals(mouvement, mvts.get(0).mouvements());

    }

    @Test
    public void testEchecTondeuseRecupererMvtsTondeuses() throws MauvaisFichierTondeuseException {

        String mouvement = "GARTGAGAA";

        List<String> lingnesTondeuse = List.of("5 5", "1 2 N", mouvement);

        Assertions.assertThrows(MauvaisFichierTondeuseException.class, () -> {
            preparateurMouvementsTondeuses.recupererMvtsTondeuses(lingnesTondeuse);
        }, "La simulation du tondeuse n'est pas bonne ");

    }

    @Test
    public void testEchecPelouseRecupererMvtsTondeuses() throws MauvaisFichierTondeuseException {

        String mouvement = "GARTGAGAA";

        List<String> lingnesTondeuse = List.of("p 5", "1 2 D", mouvement);

        Assertions.assertThrows(MauvaisFichierTondeuseException.class, () -> {
            preparateurMouvementsTondeuses.recupererMvtsTondeuses(lingnesTondeuse);
        }, "La simulation du pelouse n'est pas bonne ");

    }

}
