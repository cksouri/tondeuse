package com.tondeuse.commande;

import com.tondeuse.domaine.bean.MouvementsTondeuse;
import com.tondeuse.domaine.bean.Pelouse;
import com.tondeuse.domaine.bean.Tondeuse;
import com.tondeuse.domaine.service.ActionneurTondeuse;
import com.tondeuse.domaine.service.PreparateurMouvementsTondeuses;
import com.tondeuse.enums.ActionsEnum;
import com.tondeuse.exception.MauvaisFichierTondeuseException;
import com.tondeuse.utils.LecteurFichier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommanderTondeuseImpl implements CommanderTondeuse {
    public static final Logger logger = LoggerFactory.getLogger(CommanderTondeuseImpl.class);
    private final ActionneurTondeuse actionneurTondeuseImpl;

    private final  PreparateurMouvementsTondeuses preparateurMouvementsTondeuses;

    public CommanderTondeuseImpl(ActionneurTondeuse actionneurTondeuseImpl, PreparateurMouvementsTondeuses preparateurMouvementsTondeuses) {
        this.actionneurTondeuseImpl = actionneurTondeuseImpl;
        this.preparateurMouvementsTondeuses = preparateurMouvementsTondeuses;
    }

    public List<MouvementsTondeuse> lancerTondeuses(List<MouvementsTondeuse> mouvementsTondeuses) {

        mouvementsTondeuses.stream().forEach(mouvement ->
            bouger(mouvement.pelouse(), mouvement.tondeuse(), mouvement.mouvements())
        );

        return mouvementsTondeuses;
    }

    public Tondeuse bouger(Pelouse pelouse, Tondeuse tondeuse, String mouvements) {
        logger.debug("La tondeuse est en position initial X = {} et y = {}", tondeuse.getCoordonnee().getX(), tondeuse.getCoordonnee().getY());
        for (char mvt : mouvements.toCharArray()) {
            actionneurTondeuseImpl.executeAction(pelouse, tondeuse, ActionsEnum.recupererActionDeCode(String.valueOf(mvt)));
        }
        logger.debug("La tondeuse est en position final X = {} et y = {}", tondeuse.getCoordonnee().getX(), tondeuse.getCoordonnee().getY());
        return tondeuse;
    }

    @Override
    public List<MouvementsTondeuse> executeMvtsTondeuses(String nomFichier) throws MauvaisFichierTondeuseException {
        logger.debug("Récuperer les informations des tondeuses à partir du fichier {}", nomFichier);
        List<String> lignesTondeuses = LecteurFichier.lireFichier(nomFichier);
        List<MouvementsTondeuse> mouvements = preparateurMouvementsTondeuses.recupererMvtsTondeuses(lignesTondeuses);
        return lancerTondeuses(mouvements);

    }
}
