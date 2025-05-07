package com.example.demo.repository;

import com.example.demo.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocenteRepository extends JpaRepository<Docente, Long> {

    @Query("Select d FROM Docente d WHERE d.nome = :nome")
    List<Docente> trovaPerNome(@Param("nome") String name);

}
