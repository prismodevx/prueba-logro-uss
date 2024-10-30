package com.luna.pruebalogro.validator;

import com.luna.pruebalogro.entity.Denuncia;
import com.luna.pruebalogro.exception.ValidateException;

public class DenunciaValidator {
    public static void save(Denuncia registro) {
        if(registro.getTitulo() == null || registro.getTitulo().trim().isEmpty()) {
            throw new ValidateException("El titulo es requerido");
        }
        if(registro.getTitulo().length() > 100) {
            throw new ValidateException("El titulo no debe exceder los 100 caracteres");
        }
    }
}
