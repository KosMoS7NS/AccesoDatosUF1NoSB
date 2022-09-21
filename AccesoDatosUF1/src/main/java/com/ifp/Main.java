package com.ifp;

import com.ifp.binario.application.PersonaBinarioAlmacenarUseCase;
import com.ifp.binario.application.PersonaBinarioCreateUseCase;
import com.ifp.binario.application.PersonaBinarioLeerUseCase;
import com.ifp.binario.application.port.PersonaBinarioAlmacenarPort;
import com.ifp.binario.application.port.PersonaBinarioCreatePort;
import com.ifp.binario.application.port.PersonaBinarioLeerPort;
import com.ifp.shared.PersonaMenuUseCase;
import com.ifp.shared.port.PersonaMenuPort;
import com.ifp.texto.application.PersonaCreateUseCase;
import com.ifp.texto.application.PersonaFicheroAlmacenarUseCase;
import com.ifp.texto.application.PersonaFicheroLeerUseCase;
import com.ifp.texto.application.port.PersonaCreatePort;
import com.ifp.texto.application.port.PersonaFicheroAlmacenarPort;
import com.ifp.texto.application.port.PersonaFicheroLeerPort;

import static com.ifp.shared.configuration.PersonaStaticConfig.NOMBRE;
import static com.ifp.shared.configuration.PersonaStaticConfig.RUTA;

/**
 * Este proyecto se realiza mediante una Arquitectura Hexagonal para no exponer las Entidades.
 * <p>
 * PersonaBinarioNoEntity es referenciada como Entity, para demostrar como se organizaría el proyecto con una BBDD
 * <p>
 * Las interfaces son referenciadas como Ports.
 * <p>
 * Las clases con métodos son referencias como Use Case.
 * <p>
 * No se utilizan controladores con peticiones POST/GET ya que no es el objetivo de este ejercicio.
 * <p>
 * @author Daniel Díez Miguel
 */
public class Main {

    public static void main(String[] args) throws Exception {

        switch (personaMenuPort().menu()) {
            case 1 -> personaFicheroAlmacenarPort().almacenarFichero(personaCreatePort().createPersona());
            case 2 -> personaBinarioAlmacenarPort().almacenarBinario(personaBinarioCreatePort().createPersona());
            case 4 -> System.out.println(personaFicheroLeerPort().leerFichero(RUTA));
            case 5 -> System.out.println(personaFicheroLeerPort().leerFicheroNombre(RUTA, NOMBRE));
            case 6 -> System.out.println(personaBinarioLeerPort().leerBinario(RUTA));
            case 7 -> System.out.println(personaBinarioLeerPort().leerFicheroNombre(RUTA, NOMBRE));
        }
    }

    static PersonaMenuPort personaMenuPort() {
        PersonaMenuPort personaMenuPort = new PersonaMenuUseCase();
        return personaMenuPort;
    }

    static PersonaCreatePort personaCreatePort() {
        PersonaCreatePort personaCreatePort = new PersonaCreateUseCase();
        return personaCreatePort;
    }

    static PersonaFicheroAlmacenarPort personaFicheroAlmacenarPort() {
        PersonaFicheroAlmacenarPort personaFicheroAlmacenarPort = new PersonaFicheroAlmacenarUseCase();
        return personaFicheroAlmacenarPort;
    }

    static PersonaBinarioCreatePort personaBinarioCreatePort() {
        PersonaBinarioCreatePort personaBinarioCreatePort = new PersonaBinarioCreateUseCase();
        return personaBinarioCreatePort;
    }

    static PersonaBinarioAlmacenarPort personaBinarioAlmacenarPort() {
        PersonaBinarioAlmacenarPort personaBinarioAlmacenarPort = new PersonaBinarioAlmacenarUseCase();
        return personaBinarioAlmacenarPort;
    }

    static PersonaFicheroLeerPort personaFicheroLeerPort() {
        PersonaFicheroLeerPort personaFicheroLeerPort = new PersonaFicheroLeerUseCase();
        return personaFicheroLeerPort;
    }

    static PersonaBinarioLeerPort personaBinarioLeerPort() {
        PersonaBinarioLeerPort personaBinarioLeerPort = new PersonaBinarioLeerUseCase();
        return personaBinarioLeerPort;
    }
}