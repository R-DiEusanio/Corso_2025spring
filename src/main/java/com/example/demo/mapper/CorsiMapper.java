package com.example.demo.mapper;

import com.example.demo.data.dto.CorsiDTO;
import com.example.demo.entity.Corsi;
import com.example.demo.entity.Discente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CorsiMapper {

    CorsiMapper INSTANCE = Mappers.getMapper(CorsiMapper.class);

    @Mapping(target = "docenteNome", source = "docente", qualifiedByName = "docenteToNomeCompleto")
    @Mapping(target = "discentiNomi", source = "discenti", qualifiedByName = "discentiToNomiCompleti")
    CorsiDTO toDTO(Corsi entity);


    @Named("docenteToNomeCompleto")
    default String docenteToNomeCompleto(com.example.demo.entity.Docente docente) {
        if (docente == null) return null;
        return docente.getNome() + " " + docente.getCognome();
    }

    @Named("discentiToNomiCompleti")
    default List<String> discentiToNomiCompleti(List<Discente> discenti) {
        if (discenti == null) return null;
        return discenti.stream()
                .map(d -> d.getNome() + " " + d.getCognome())
                .collect(Collectors.toList());
    }
}
