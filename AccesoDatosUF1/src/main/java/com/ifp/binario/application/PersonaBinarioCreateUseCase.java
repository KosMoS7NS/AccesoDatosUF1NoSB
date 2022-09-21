package com.ifp.binario.application;

import com.ifp.binario.application.port.PersonaBinarioCreatePort;
import com.ifp.binario.domain.no_database.PersonaBinarioNoEntity;
import com.ifp.binario.infrastructure.dto.input.PersonaBinarioInputDTO;
import com.ifp.shared.configuration.PersonaStaticConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ifp.shared.configuration.PersonaStaticConfig.RUTA;
import static com.ifp.shared.port.PersonaMapperPort.INSTANCE;


/**
 * Clase con el método de creación de las Personas.
 */
public class PersonaBinarioCreateUseCase implements PersonaBinarioCreatePort {

    /**
     * Se realiza un Scaner para capturar la información del usuario.
     * <p>
     * Se instancia la clase PersonaInputDTO mediante un constructor con argumentos, en el cual se le pasa los atributos
     * anteriormente capturados.
     * <p>
     * La lista de personaEntity guardara PersonaBinarioNoEntity con un mapeon de PersonaInputDTO. A continuación,
     * se convierte la lista de personaEntity en un DTO de Salida mediante un Mapper, realizado en otro Caso de Uso.
     *
     * @return List
     */

    @Override
    public List createPersona() throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<PersonaBinarioNoEntity> personaBinarioNoEntityList = new ArrayList<>();
        int i = 1;

        try {
            System.out.println("Introduce el nombre del fichero: ");
            RUTA = scanner.next();
            System.out.println("=====================================");

            do {
                System.out.println("PERSONA: " + i);

                System.out.println("Introduce tu nombre: ");
                String nombre = scanner.next();

                scanner.nextLine();
                System.out.println("Introduce tus apellidos: ");
                String apellidos = scanner.nextLine();

                System.out.println("Introduce tu edad: ");
                int edad = scanner.nextInt();

                scanner.nextLine();
                System.out.println("Introduce tu ciudad: ");
                String ciudad = scanner.nextLine();

                System.out.println("Introduce tu nacionalidad: ");
                String nacionalidad = scanner.next();
                System.out.println("=====================================");


                personaBinarioNoEntityList.add(INSTANCE.personaBinarioNoEntity(
                        new PersonaBinarioInputDTO(nombre, apellidos, ciudad, nacionalidad, edad)));

                i += 1;

            } while (i <= 3);
            return INSTANCE.personaBinarioOutputDtoList(personaBinarioNoEntityList);

        } catch (Exception e) {
            throw new Exception("Introduce correctamente los datos");
        }

    }
}
