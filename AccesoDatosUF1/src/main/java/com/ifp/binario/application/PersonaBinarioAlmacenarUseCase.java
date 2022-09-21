package com.ifp.binario.application;

import com.ifp.binario.application.port.PersonaBinarioAlmacenarPort;
import com.ifp.binario.infrastructure.dto.output.PersonaBinarioOutputDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.ifp.shared.configuration.PersonaStaticConfig.RUTA;
import static java.lang.System.lineSeparator;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Esta clase devuelve true o false dependiendo de la respuesta del usuario para la creación de la Persona.
 */
public class PersonaBinarioAlmacenarUseCase implements PersonaBinarioAlmacenarPort {

    /**
     * Este método escribe la lista de Personas siempre y cuando el usuario afirme con un si, de lo contrario se cierra.
     *
     * @param personaOutputDTOList Información de la Persona
     * @return boolean
     * @throws IOException
     */

    @Override
    public boolean almacenarBinario(List<PersonaBinarioOutputDTO> personaBinarioOutputDTOList) throws IOException {

        Scanner scanner = new Scanner(System.in);
        List dataList = new ArrayList<>();

        File file = new File(RUTA);
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);

        if (file.exists()) {
            System.out.println("El fichero ya existe, ¿quiere continuar? ");
            String respuesta = scanner.next();

            if (respuesta.equalsIgnoreCase("si")) {
                try {

                    personaBinarioOutputDTOList.forEach(personaBinarioOutputDTO ->
                            dataList.add(personaBinarioOutputDTO + lineSeparator()));

                    fileOutputStream.write((dataList.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(", ")) + lineSeparator())
                            .getBytes(UTF_8));

                    fileOutputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                return true;

            } else fileOutputStream.close();
        }

        throw new FileNotFoundException("No se ha encontrado el fichero.txt");

    }
}
