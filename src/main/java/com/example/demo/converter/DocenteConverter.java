package com.example.demo.converter;
import com.example.demo.data.dto.DocenteDTO;;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.entity.Docente;

public class DocenteConverter {

    public static DocenteDTO toDTO(Docente docente) {

        if (docente == null) return null;
        return new DocenteDTO(
                docente.getId(),
                docente.getNome(),
                docente.getCognome()
        );
    }

    public static Docente toEntity(DocenteDTO dto) {
        if (dto == null) return null;
        Docente docente = new Docente();
        docente.setId(dto.getId());
        docente.setNome(dto.getNome());
        docente.setCognome(dto.getCognome());
        return docente;

    }

}
