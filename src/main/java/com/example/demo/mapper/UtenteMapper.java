package com.example.demo.mapper;

import com.example.demo.data.dto.UtenteDTO;
import com.example.demo.entity.Utente;

public class UtenteMapper {

    public static UtenteDTO toDto(Utente u) {
        return new UtenteDTO(u.getId(), u.getEmail(), u.getRuolo());
    }
}
