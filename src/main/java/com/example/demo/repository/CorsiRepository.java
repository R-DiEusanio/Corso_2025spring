package com.example.demo.repository;

import com.example.demo.entity.Corsi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CorsiRepository extends JpaRepository<Corsi, Long> {

    @Query("SELECT c FROM Corsi c LEFT JOIN FETCH c.docente")
    List<Corsi> findAllConDocenti();


}
