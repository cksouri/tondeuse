package com.tondeuse.enums;

public enum DirectionEnum {

    N("NORD"),
    S("SUD"),
    W("WEST"),
    E("EAST");

    private String direction;
    DirectionEnum(String direction) {
        this.direction = direction;
    }

    public static DirectionEnum directionFromChar(char c){
        return DirectionEnum.valueOf(String.valueOf(c));
    }
}
