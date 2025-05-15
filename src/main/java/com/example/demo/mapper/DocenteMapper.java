package com.example.demo.mapper;
import com.example.demo.entity.Docente;
import com.example.demo.data.dto.DocenteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteMapper {

    DocenteDTO toDTO(Docente docente);

    Docente toEntity(DocenteDTO dto);
}
