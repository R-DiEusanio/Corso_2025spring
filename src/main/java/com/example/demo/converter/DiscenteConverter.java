package com.example.demo.converter;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.entity.Discente;

public class DiscenteConverter {

    public static DiscenteDTO toDTO(Discente discente) {
        if (discente == null) return null;
        return new DiscenteDTO(
                discente.getId(),
                discente.getNome(),
                discente.getCognome()
        );
    }

    public static Discente toEntity(DiscenteDTO dto) {
        if (dto == null) return null;
        Discente discenti = new Discente();
        discenti.setId(dto.getId());
        discenti.setNome(dto.getNome());
        discenti.setCognome(dto.getCognome());
        return discenti;
    }
}


