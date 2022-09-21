package com.ifp.texto.application;

import com.ifp.texto.application.port.PersonaFicheroAlmacenarPort;
import com.ifp.texto.infrastructure.dto.output.PersonaOutputDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.ifp.shared.configuration.PersonaStaticConfig.RUTA;

/**
 * Esta clase devuelve true o false dependiendo de la respuesta del usuario para la creación de la Persona.
 */
public class PersonaFicheroAlmacenarUseCase implements PersonaFicheroAlmacenarPort {

    /**
     * Este método escribe la lista de Personas siempre y cuando el usuario afirme con un si, de lo contrario se cierra.
     *
     * @param personaOutputDTOList Información de la Persona
     * @return boolean
     * @throws IOException
     */
    @Override
    public boolean almacenarFichero(List<PersonaOutputDTO> personaOutputDTOList) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List listSeparator = new ArrayList<>();

        File file = new File(RUTA);
        FileWriter fileWriter = new FileWriter(file, true);

        if (file.exists()) {
            System.out.println("El fichero ya existe, ¿quiere continuar? ");
            String respuesta = scanner.next();

            if (respuesta.equalsIgnoreCase("si")) {
                try {
                    personaOutputDTOList.forEach(personaOutputDTO ->
                            listSeparator.add(personaOutputDTO + System.lineSeparator()));

                    fileWriter.write(listSeparator.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining()) + System.lineSeparator());

                    fileWriter.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return true;

            } else fileWriter.close();
        }

        throw new FileNotFoundException("No se ha encontrado el fichero.txt");

    }
}
