package com.tondeuse.utils;

import com.tondeuse.exception.MauvaisFichierTondeuseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LecteurFichierTest {

    @Test
    void testLireFichier() throws MauvaisFichierTondeuseException {

        String path = "src/test/resources/jdd/tondeuses.txt";

        List<String> result = LecteurFichier.lireFichier(path);

        Assertions.assertEquals("5 5", result.get(0));
        Assertions.assertEquals("1 2 N", result.get(1));
        Assertions.assertEquals("GAGAGAGAA", result.get(2));
        Assertions.assertEquals("3 3 E", result.get(3));
        Assertions.assertEquals("AADAADADDA", result.get(4));

    }
}
