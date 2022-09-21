package com.ifp.shared.port;

import com.ifp.binario.domain.no_database.PersonaBinarioNoEntity;
import com.ifp.binario.infrastructure.dto.input.PersonaBinarioInputDTO;
import com.ifp.binario.infrastructure.dto.output.PersonaBinarioOutputDTO;
import com.ifp.texto.domain.no_database.PersonaNoEntity;
import com.ifp.texto.infrastructure.dto.input.PersonaInputDTO;
import com.ifp.texto.infrastructure.dto.output.PersonaOutputDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-21T17:11:15+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
public class PersonaMapperPortImpl implements PersonaMapperPort {

    @Override
    public PersonaNoEntity personaEntity(PersonaInputDTO personaInputDTO) {
        if ( personaInputDTO == null ) {
            return null;
        }

        PersonaNoEntity personaNoEntity = new PersonaNoEntity();

        personaNoEntity.setNombre( personaInputDTO.getNombre() );
        personaNoEntity.setApellidos( personaInputDTO.getApellidos() );
        personaNoEntity.setCiudad( personaInputDTO.getCiudad() );
        personaNoEntity.setNacionalidad( personaInputDTO.getNacionalidad() );
        personaNoEntity.setEdad( personaInputDTO.getEdad() );

        return personaNoEntity;
    }

    @Override
    public List<PersonaOutputDTO> personaOutputDtoList(List<PersonaNoEntity> personaNoEntityList) {
        if ( personaNoEntityList == null ) {
            return null;
        }

        List<PersonaOutputDTO> list = new ArrayList<PersonaOutputDTO>( personaNoEntityList.size() );
        for ( PersonaNoEntity personaNoEntity : personaNoEntityList ) {
            list.add( personaNoEntityToPersonaOutputDTO( personaNoEntity ) );
        }

        return list;
    }

    @Override
    public PersonaBinarioNoEntity personaBinarioNoEntity(PersonaBinarioInputDTO personaBinarioInputDTO) {
        if ( personaBinarioInputDTO == null ) {
            return null;
        }

        PersonaBinarioNoEntity personaBinarioNoEntity = new PersonaBinarioNoEntity();

        personaBinarioNoEntity.setNombre( personaBinarioInputDTO.getNombre() );
        personaBinarioNoEntity.setApellidos( personaBinarioInputDTO.getApellidos() );
        personaBinarioNoEntity.setCiudad( personaBinarioInputDTO.getCiudad() );
        personaBinarioNoEntity.setNacionalidad( personaBinarioInputDTO.getNacionalidad() );
        personaBinarioNoEntity.setEdad( personaBinarioInputDTO.getEdad() );

        return personaBinarioNoEntity;
    }

    @Override
    public List<PersonaBinarioOutputDTO> personaBinarioOutputDtoList(List<PersonaBinarioNoEntity> personaBinarioNoEntityList) {
        if ( personaBinarioNoEntityList == null ) {
            return null;
        }

        List<PersonaBinarioOutputDTO> list = new ArrayList<PersonaBinarioOutputDTO>( personaBinarioNoEntityList.size() );
        for ( PersonaBinarioNoEntity personaBinarioNoEntity : personaBinarioNoEntityList ) {
            list.add( personaBinarioNoEntityToPersonaBinarioOutputDTO( personaBinarioNoEntity ) );
        }

        return list;
    }

    protected PersonaOutputDTO personaNoEntityToPersonaOutputDTO(PersonaNoEntity personaNoEntity) {
        if ( personaNoEntity == null ) {
            return null;
        }

        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO();

        personaOutputDTO.setNombre( personaNoEntity.getNombre() );
        personaOutputDTO.setApellidos( personaNoEntity.getApellidos() );
        personaOutputDTO.setCiudad( personaNoEntity.getCiudad() );
        personaOutputDTO.setNacionalidad( personaNoEntity.getNacionalidad() );
        personaOutputDTO.setEdad( personaNoEntity.getEdad() );

        return personaOutputDTO;
    }

    protected PersonaBinarioOutputDTO personaBinarioNoEntityToPersonaBinarioOutputDTO(PersonaBinarioNoEntity personaBinarioNoEntity) {
        if ( personaBinarioNoEntity == null ) {
            return null;
        }

        PersonaBinarioOutputDTO personaBinarioOutputDTO = new PersonaBinarioOutputDTO();

        personaBinarioOutputDTO.setNombre( personaBinarioNoEntity.getNombre() );
        personaBinarioOutputDTO.setApellidos( personaBinarioNoEntity.getApellidos() );
        personaBinarioOutputDTO.setCiudad( personaBinarioNoEntity.getCiudad() );
        personaBinarioOutputDTO.setNacionalidad( personaBinarioNoEntity.getNacionalidad() );
        personaBinarioOutputDTO.setEdad( personaBinarioNoEntity.getEdad() );

        return personaBinarioOutputDTO;
    }
}
