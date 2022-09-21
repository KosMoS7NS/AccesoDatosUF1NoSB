package com.ifp;

import com.ifp.binario.application.PersonaBinarioAlmacenarUseCase;
import com.ifp.binario.application.PersonaBinarioCreateUseCase;
import com.ifp.binario.application.port.PersonaBinarioAlmacenarPort;
import com.ifp.binario.application.port.PersonaBinarioCreatePort;
import com.ifp.binario.application.port.PersonaBinarioLeerPort;
import com.ifp.shared.PersonaMenuUseCase;
import com.ifp.shared.port.PersonaMenuPort;
import com.ifp.texto.application.PersonaCreateUseCase;
import com.ifp.texto.application.PersonaFicheroAlmacenarUseCase;
import com.ifp.texto.application.port.PersonaCreatePort;
import com.ifp.texto.application.port.PersonaFicheroAlmacenarPort;
import com.ifp.texto.application.port.PersonaFicheroLeerPort;

import static com.ifp.shared.configuration.PersonaStaticConfig.NOMBRE;
import static com.ifp.shared.configuration.PersonaStaticConfig.RUTA;

public class Main {

    public static void main(String[] args) throws Exception {

        personaMenuPort().menu();

//        switch (personaMenuPort.menu()) {
//            case 1 -> personaFicheroAlmacenarPort.almacenarFichero(personaCreatePort.createPersona());
//            case 2 -> personaBinarioAlmacenarPort.almacenarBinario(personaBinarioCreatePort.createPersona());
//            case 4 -> System.out.println(personaFicheroLeerPort.leerFichero(RUTA));
//            case 5 -> System.out.println(personaFicheroLeerPort.leerFicheroNombre(RUTA, NOMBRE));
//            case 6 -> System.out.println(personaBinarioLeerPort.leerBinario(RUTA));
//            case 7 -> System.out.println(personaBinarioLeerPort.leerFicheroNombre(RUTA, NOMBRE));
//        }
    }

//    static PersonaCreatePort personaCreatePort;
//    static PersonaFicheroAlmacenarPort personaFicheroAlmacenarPort;
//    static PersonaFicheroLeerPort personaFicheroLeerPort;
//    static PersonaBinarioCreatePort personaBinarioCreatePort;
//    static PersonaBinarioAlmacenarPort personaBinarioAlmacenarPort;
//    static PersonaBinarioLeerPort personaBinarioLeerPort;
//    static PersonaMenuPort personaMenuPort;

    static PersonaMenuPort personaMenuPort() {
        PersonaMenuPort personaMenuPort = new PersonaMenuUseCase();
        return personaMenuPort;
    }

    static PersonaCreatePort personaCreatePort() {
        PersonaCreatePort personaCreatePort = new PersonaCreateUseCase();
        return personaCreatePort;
    }

    static PersonaFicheroAlmacenarPort personaFicheroAlmacenarUseCase() {
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
}