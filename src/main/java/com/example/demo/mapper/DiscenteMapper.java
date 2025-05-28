package com.example.demo.mapper;

import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteMapper {

    DiscenteDTO toDTO(Discente discente);
    Discente toEntity(DiscenteDTO dto);
}
