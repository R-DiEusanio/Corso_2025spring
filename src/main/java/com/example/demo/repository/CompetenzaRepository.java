package com.example.demo.repository;

import com.example.demo.entity.Competenza;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CompetenzaRepository extends JpaRepository<Competenza, Long> {
    List<Competenza> findByDocenteIdOrderByNomeAsc(Long docenteId);
}
