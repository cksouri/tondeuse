package com.tondeuse.domaine.bean;

import com.tondeuse.enums.DirectionEnum;

import java.util.Objects;

public class Tondeuse {
    private Coordonnee coordonnee;
    private DirectionEnum directionEnum;

    public Tondeuse(Coordonnee coordonnee, DirectionEnum directionEnum) {
        this.coordonnee = coordonnee;
        this.directionEnum = directionEnum;
    }

    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    public DirectionEnum getDirectionEnum() {
        return directionEnum;
    }

    public void setCoordonnee(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }

    public void setDirectionEnum(DirectionEnum directionEnum) {
        this.directionEnum = directionEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tondeuse tondeuse = (Tondeuse) o;
        return Objects.equals(coordonnee, tondeuse.coordonnee) && directionEnum == tondeuse.directionEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordonnee, directionEnum);
    }
}
