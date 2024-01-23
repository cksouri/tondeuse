package com.tondeuse.domaine.service;

import com.tondeuse.domaine.bean.Pelouse;
import com.tondeuse.domaine.bean.Tondeuse;
import com.tondeuse.enums.ActionsEnum;
import com.tondeuse.enums.DirectionEnum;
import org.springframework.stereotype.Service;

@Service
public class ActionneurTondeuseImpl implements ActionneurTondeuse {
    public Tondeuse executeAction(Pelouse pelouse, Tondeuse tondeuse, ActionsEnum action) {

        if(ActionsEnum.DROITE.equals(action)) {
            switch (tondeuse.getDirectionEnum()){
                case E -> tondeuse.setDirectionEnum(DirectionEnum.S);
                case W -> tondeuse.setDirectionEnum(DirectionEnum.N);
                case N -> tondeuse.setDirectionEnum(DirectionEnum.E);
                case S -> tondeuse.setDirectionEnum(DirectionEnum.W);
            }
        } else if(ActionsEnum.GAUCHE.equals(action)) {
            switch (tondeuse.getDirectionEnum()){
                case E -> tondeuse.setDirectionEnum(DirectionEnum.N);
                case W -> tondeuse.setDirectionEnum(DirectionEnum.S);
                case N -> tondeuse.setDirectionEnum(DirectionEnum.W);
                case S -> tondeuse.setDirectionEnum(DirectionEnum.E);
            }

        } else if(ActionsEnum.AVANCER.equals(action) && actionOk(pelouse, tondeuse)){
            switch (tondeuse.getDirectionEnum()){
                case E -> tondeuse.getCoordonnee().setX(tondeuse.getCoordonnee().getX() + 1);
                case W -> tondeuse.getCoordonnee().setX(tondeuse.getCoordonnee().getX() - 1);
                case N -> tondeuse.getCoordonnee().setY(tondeuse.getCoordonnee().getY() + 1);
                case S -> tondeuse.getCoordonnee().setY(tondeuse.getCoordonnee().getY() - 1);
            }
        }
        return tondeuse;
    }

    private boolean actionOk(Pelouse pelouse, Tondeuse tondeuse) {
        return  switch (tondeuse.getDirectionEnum()){
            case E -> tondeuse.getCoordonnee().getX() + 1 <= pelouse.getCoordonnee().getX();
            case W -> tondeuse.getCoordonnee().getX() - 1 >= 0;
            case N -> tondeuse.getCoordonnee().getY() + 1 <= pelouse.getCoordonnee().getY();
            case S -> tondeuse.getCoordonnee().getY() - 1 >= 0;
        };

    }
}
