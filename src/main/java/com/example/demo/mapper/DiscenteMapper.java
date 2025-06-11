package com.example.demo.mapper;

import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.entity.Discente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DiscenteMapper {

    @Mapping(source = "id", target = "idDiscente")
    DiscenteDTO toDTO(Discente discente);

    @Mapping(source = "idDiscente", target = "id")
    Discente toEntity(DiscenteDTO dto);

}