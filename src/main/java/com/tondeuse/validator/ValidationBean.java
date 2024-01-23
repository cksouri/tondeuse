package com.tondeuse.validator;

import com.tondeuse.dto.PelouseDto;
import com.tondeuse.dto.TondeuseDto;

import java.util.Optional;


public class ValidationBean {
    public boolean validerPelpuseDto(PelouseDto bean){
        return Optional.ofNullable(bean.coinSuperieur()).orElse("")
                .matches("^(\\s)*\\d(\\s)*\\d(\\s)*$");
    }

    public boolean validerTondeuseDto(TondeuseDto bean){
        return Optional.ofNullable(bean.mouvement()).orElse("")
                            .matches("^[G DA]*$")
                && Optional.ofNullable(bean.posInitial()).orElse("")
                            .matches("^(\\s)*\\d(\\s)*\\d(\\s)*[\\sNEWS]$");
    }

}
