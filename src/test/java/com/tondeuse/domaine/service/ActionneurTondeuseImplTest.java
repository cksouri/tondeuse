package com.tondeuse.domaine.service;

import com.tondeuse.conf.TestsConfig;
import com.tondeuse.domaine.bean.Coordonnee;
import com.tondeuse.domaine.bean.Pelouse;
import com.tondeuse.domaine.bean.Tondeuse;
import com.tondeuse.enums.ActionsEnum;
import com.tondeuse.enums.DirectionEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionneurTondeuseImplTest extends TestsConfig {

    Pelouse pelouse = new Pelouse(new Coordonnee(5, 5));
    @Autowired
    ActionneurTondeuse actionneurTondeuse;

    @Test
    public void testAvancerADroite(){
        Tondeuse tondeuse = new Tondeuse(new Coordonnee(1, 3), DirectionEnum.E);
        ActionsEnum action = ActionsEnum.recupererActionDeCode("A");

        actionneurTondeuse.executeAction(pelouse, tondeuse, action);

        Assertions.assertEquals(2, tondeuse.getCoordonnee().getX());
        Assertions.assertEquals(3, tondeuse.getCoordonnee().getY());
        Assertions.assertEquals(DirectionEnum.E, tondeuse.getDirectionEnum());
    }

    @Test
    public void testAvancerAGauche() {
        Tondeuse tondeuse = new Tondeuse(new Coordonnee(1,3), DirectionEnum.W);
        ActionsEnum action = ActionsEnum.recupererActionDeCode("A");

        actionneurTondeuse.executeAction(pelouse, tondeuse, action);

        Assertions.assertEquals(0, tondeuse.getCoordonnee().getX());
        Assertions.assertEquals(3, tondeuse.getCoordonnee().getY());
        Assertions.assertEquals(DirectionEnum.W, tondeuse.getDirectionEnum());
    }

    @Test
    public void testAvancerNord(){
        Tondeuse tondeuse = new Tondeuse(new Coordonnee(1,3), DirectionEnum.N);
        ActionsEnum action = ActionsEnum.recupererActionDeCode("A");

        actionneurTondeuse.executeAction(pelouse, tondeuse, action);


        Assertions.assertEquals(1, tondeuse.getCoordonnee().getX());
        Assertions.assertEquals(4, tondeuse.getCoordonnee().getY());
        Assertions.assertEquals(DirectionEnum.N, tondeuse.getDirectionEnum());
    }

    @Test
    public void testAvancerSud(){
        Tondeuse tondeuse = new Tondeuse(new Coordonnee(1,3), DirectionEnum.S);
        ActionsEnum action = ActionsEnum.recupererActionDeCode("A");

        actionneurTondeuse.executeAction(pelouse, tondeuse, action);

        Assertions.assertEquals(1, tondeuse.getCoordonnee().getX());
        Assertions.assertEquals(2, tondeuse.getCoordonnee().getY());
        Assertions.assertEquals(DirectionEnum.E, tondeuse.getDirectionEnum());
    }

    @Test
    public void testAvancerBloqueeVersLeNord(){
        Tondeuse tondeuse = new Tondeuse(new Coordonnee(1,5), DirectionEnum.N);
        ActionsEnum action = ActionsEnum.recupererActionDeCode("A");

        actionneurTondeuse.executeAction(pelouse, tondeuse, action);

        Assertions.assertEquals(1, tondeuse.getCoordonnee().getX());
        Assertions.assertEquals(5, tondeuse.getCoordonnee().getY());
        Assertions.assertEquals(DirectionEnum.N, tondeuse.getDirectionEnum());
    }

    @Test
    public void testTournerNord(){
        Tondeuse tondeuse = new Tondeuse(new Coordonnee(1,3), DirectionEnum.E);
        ActionsEnum action = ActionsEnum.recupererActionDeCode("G");

        actionneurTondeuse.executeAction(pelouse, tondeuse, action);

        Assertions.assertEquals(1, tondeuse.getCoordonnee().getX());
        Assertions.assertEquals(3, tondeuse.getCoordonnee().getY());
        Assertions.assertEquals(DirectionEnum.N, tondeuse.getDirectionEnum());
    }

    @Test
    public void testTournerSud(){
        Tondeuse tondeuse = new Tondeuse(new Coordonnee(1,3), DirectionEnum.E);
        ActionsEnum action = ActionsEnum.recupererActionDeCode("D");

        actionneurTondeuse.executeAction(pelouse, tondeuse, action);

        Assertions.assertEquals(1, tondeuse.getCoordonnee().getX());
        Assertions.assertEquals(3, tondeuse.getCoordonnee().getY());
        Assertions.assertEquals(DirectionEnum.S, tondeuse.getDirectionEnum());
    }

    @Test
    public void testTournerEast(){
        Tondeuse tondeuse = new Tondeuse(new Coordonnee(1,3), DirectionEnum.S);
        ActionsEnum action = ActionsEnum.recupererActionDeCode("G");

        actionneurTondeuse.executeAction(pelouse, tondeuse, action);

        Assertions.assertEquals(1, tondeuse.getCoordonnee().getX());
        Assertions.assertEquals(3, tondeuse.getCoordonnee().getY());
        Assertions.assertEquals(DirectionEnum.E, tondeuse.getDirectionEnum());
    }

    @Test
    public void testTournerWest(){
        Tondeuse tondeuse = new Tondeuse(new Coordonnee(1,3), DirectionEnum.S);
        ActionsEnum action = ActionsEnum.recupererActionDeCode("D");

        actionneurTondeuse.executeAction(pelouse, tondeuse, action);

        Assertions.assertEquals(1, tondeuse.getCoordonnee().getX());
        Assertions.assertEquals(3, tondeuse.getCoordonnee().getY());
        Assertions.assertEquals(DirectionEnum.W, tondeuse.getDirectionEnum());
    }

}
