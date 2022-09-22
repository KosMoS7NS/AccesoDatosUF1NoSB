package com.ifp.binario.application;

import com.ifp.binario.application.port.PersonaBinarioLeerPort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase esta compuesta por dos métodos.
 * <p>
 * EL primer método leerFichero devuelve una lista con todas las personas del fichero.txt
 * <p>
 * El segundo método leerFicheroNombre devuelve una lista con los datos de una persona del fichero.txt
 */
public class PersonaBinarioLeerUseCase implements PersonaBinarioLeerPort {

    private final List personaList = new ArrayList<>();

    /**
     * @param ruta Ruta del fichero.dat
     * @return List
     * @throws IOException
     */
    @Override
    public List leerBinario(String ruta) throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream(new File(ruta));
        int content;
        String data = "";

        while ((content = inputStream.read()) != -1) data += (char) content;
        personaList.add(data);

        inputStream.close();
        return personaList;

    }

    /**
     * @param ruta Ruta del fichero.dat
     * @param nombre Nombre de la persona a buscar en el fichero.dat
     * @return List
     * @throws IOException
     */
    @Override
    public List leerFicheroNombre(String ruta, String nombre) throws IOException, ClassNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(ruta)));
        String lineaTextoFichero = "";

        while ((lineaTextoFichero = bufferedReader.readLine()) != null) {
            String[] infoSplit = lineaTextoFichero.split("=");

            if (infoSplit.length > 1 && nombre.equalsIgnoreCase(infoSplit[1]
                    .substring(0, infoSplit[1].length() - 11)))
                personaList.add(System.lineSeparator() + lineaTextoFichero);

        }

        bufferedReader.close();
        return personaList;

    }
}
