package com.ifp.texto.application.port;

import java.util.List;

/**
 * Puerto con el método de creación de Personas.
 */
public interface PersonaFicheroCreatePort {

    /**
     * @return List
     * @throws Exception
     */
    List createPersona() throws Exception;
}
