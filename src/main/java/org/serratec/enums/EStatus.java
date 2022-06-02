package org.serratec.enums;

import org.serratec.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EStatus {

    NÃO_FINALIZADO,
    FINALIZADO;

    @JsonCreator
    public static EStatus verifica(String value) throws EnumValidationException{
        for(EStatus s : values()){
            if(value.equals(s.name())){
                return s;
            }
        }
        throw new EnumValidationException("Status preenchido incorretamente");
    }
}
