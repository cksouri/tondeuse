package com.tondeuse.utils;

import com.tondeuse.exception.MauvaisFichierTondeuseException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class LecteurFichier {

    private LecteurFichier(){
        throw new IllegalStateException("classe utilitaire à ne pas instancier ");
    }

    public static List<String> lireFichier(String chemin) throws MauvaisFichierTondeuseException {

        try (Stream<String> lignes = java.nio.file.Files.lines(Paths.get(chemin))) {
            return  lignes.toList();
        } catch (IOException ex) {
            throw new MauvaisFichierTondeuseException(ex.getMessage());
        }
    }
}
