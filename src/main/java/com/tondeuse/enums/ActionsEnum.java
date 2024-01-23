package com.tondeuse.enums;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public enum ActionsEnum {

    AVANCER("A"),
    GAUCHE("G"),
    DROITE("D");

    private String actionCode;

    ActionsEnum(String codeAction) {
        this.actionCode = codeAction;
    }

    public static ActionsEnum recupererActionDeCode(String code){
        if(Optional.ofNullable(code).isPresent()){
            return Arrays.asList(ActionsEnum.values()).stream().filter(a -> a.actionCode.equals(code)).toList().stream().findFirst().get();
        }
        return null;
    }
}
