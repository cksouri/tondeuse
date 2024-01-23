package com.tondeuse.domaine.service;

import com.tondeuse.domaine.bean.Pelouse;
import com.tondeuse.domaine.bean.Tondeuse;
import com.tondeuse.enums.ActionsEnum;

public interface ActionneurTondeuse {
    public Tondeuse executeAction(Pelouse pelouse, Tondeuse tondeuse, ActionsEnum action);
}
