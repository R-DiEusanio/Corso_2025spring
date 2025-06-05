package com.example.demo.mapper;
import com.example.demo.entity.Docente;
import com.example.demo.data.dto.DocenteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocenteMapper {
    
    @Mapping(source = "id", target = "idDocente")
    DocenteDTO toDTO(Docente docente);

    @Mapping(source = "idDocente", target = "id")
    Docente toEntity(DocenteDTO dto);
}