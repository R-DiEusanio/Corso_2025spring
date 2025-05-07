package com.example.demo.repository;
import com.example.demo.entity.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface StudenteRepository extends JpaRepository<Studente, Long> {

    @Query("SELECT s FROM Studente s WHERE s.eta >= :eta")
    List<Studente> trovaTuttiMaggiorenni(@Param("eta") int eta);

    @Query("SELECT s From Studente s where s.cittaResidenza = :citta")
    List<Studente> trovaResidenza(@Param("citta") String citta);

    @Query("SELECT s FROM Studente s ORDER BY s.nome ASC")
    List<Studente> StudentiOrdinatiPerNome();

}
