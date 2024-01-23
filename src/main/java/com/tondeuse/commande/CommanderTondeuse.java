package com.tondeuse.commande;

import com.tondeuse.domaine.bean.MouvementsTondeuse;
import com.tondeuse.domaine.bean.Pelouse;
import com.tondeuse.domaine.bean.Tondeuse;
import com.tondeuse.exception.MauvaisFichierTondeuseException;

import java.util.List;

public interface CommanderTondeuse {

    public List<MouvementsTondeuse> lancerTondeuses(List<MouvementsTondeuse> mouvementsTondeuses);

    public Tondeuse bouger(Pelouse pelouse, Tondeuse tondeuse, String mouvements);

    public List<MouvementsTondeuse> executeMvtsTondeuses(String nomFichier) throws MauvaisFichierTondeuseException;
}
