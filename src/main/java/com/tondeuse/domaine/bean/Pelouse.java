package com.tondeuse.domaine.bean;

import java.util.Objects;

public class Pelouse {
    private Coordonnee coordonnee;

    public Pelouse(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }

    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelouse pelouse = (Pelouse) o;
        return Objects.equals(coordonnee, pelouse.coordonnee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordonnee);
    }
}
