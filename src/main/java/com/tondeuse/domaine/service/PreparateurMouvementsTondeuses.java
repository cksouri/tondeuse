package com.tondeuse.domaine.service;

import com.tondeuse.domaine.bean.Coordonnee;
import com.tondeuse.domaine.bean.MouvementsTondeuse;
import com.tondeuse.domaine.bean.Pelouse;
import com.tondeuse.domaine.bean.Tondeuse;
import com.tondeuse.dto.PelouseDto;
import com.tondeuse.dto.TondeuseDto;
import com.tondeuse.enums.DirectionEnum;
import com.tondeuse.exception.MauvaisFichierTondeuseException;
import com.tondeuse.validator.ValidationBean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreparateurMouvementsTondeuses {
    private final ValidationBean validator;
    public PreparateurMouvementsTondeuses(ValidationBean validator) {
        this.validator = validator;
    }

    public List<MouvementsTondeuse> recupererMvtsTondeuses(List<String> lignesTondeuses) throws MauvaisFichierTondeuseException {
        List<MouvementsTondeuse> mouvementsTondeuses = new ArrayList<>();
        if(lignesTondeuses.isEmpty()){
            throw new MauvaisFichierTondeuseException("Le fichier n'est pas bon ");
        }
        Pelouse pelouse = initPelouse(lignesTondeuses.get(0));
        int index = 1;
        while (index < lignesTondeuses.size() - 1){
            MouvementsTondeuse mouvementsTondeuse = initMouvementsTondeuse(lignesTondeuses.get(index), lignesTondeuses.get(index + 1), pelouse);
            mouvementsTondeuses.add(mouvementsTondeuse);
            index = index + 2;
        }

        return mouvementsTondeuses;
    }
    private MouvementsTondeuse initMouvementsTondeuse(String pos, String mvt, Pelouse pelouse) throws MauvaisFichierTondeuseException {
        if(validator.validerTondeuseDto(new TondeuseDto(pos, mvt))) {
            Tondeuse tondeuse = new Tondeuse(new Coordonnee(Character.getNumericValue(StringUtils.trimAllWhitespace(pos).charAt(0)), Character.getNumericValue(StringUtils.trimAllWhitespace(pos).charAt(1))), DirectionEnum.directionFromChar(StringUtils.trimAllWhitespace(pos).charAt(2)));
            return new MouvementsTondeuse(mvt, pelouse, tondeuse);
        } else {
            throw new MauvaisFichierTondeuseException("La simulation du tondeuse n'est pas bonne ");
        }
    }
    private Pelouse initPelouse(String s) throws MauvaisFichierTondeuseException {
        if(validator.validerPelpuseDto(new PelouseDto(s))){
            return new Pelouse(new Coordonnee(Character.getNumericValue(StringUtils.trimAllWhitespace(s).charAt(0)), Character.getNumericValue(StringUtils.trimAllWhitespace(s).charAt(0))));
        } else {
            throw new MauvaisFichierTondeuseException("La simulation du pelouse n'est pas bonne ");
        }
    }

}
