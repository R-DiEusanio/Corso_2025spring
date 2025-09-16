package com.example.demo.mapper;

import com.example.demo.data.dto.CompetenzaDTO;
import com.example.demo.entity.Competenza;

public class CompetenzaMapper {

    public static CompetenzaDTO toDTO(Competenza c) {
        return new CompetenzaDTO(
                c.getId(),
                c.getNome(),
                c.getLivello(),
                c.getDocente() != null ? c.getDocente().getId() : null
        );
    }

    public static Competenza toEntity(CompetenzaDTO dto) {
        Competenza c = new Competenza();
        c.setId(dto.getId());
        c.setNome(dto.getNome());
        c.setLivello(dto.getLivello());
        return c;
    }
}
