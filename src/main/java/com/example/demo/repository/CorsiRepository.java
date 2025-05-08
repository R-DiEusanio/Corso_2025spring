package com.example.demo.repository;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.Corsi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CorsiRepository extends JpaRepository<Corsi, Long> {

    @Query("SELECT c FROM Corsi c ORDER BY c.docente.id")
    List<Corsi> CorsiOrdinatiIdDocenti();

}
