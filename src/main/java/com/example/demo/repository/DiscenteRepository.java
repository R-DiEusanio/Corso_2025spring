package com.example.demo.repository;
import com.example.demo.entity.Discente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface DiscenteRepository extends JpaRepository<Discente, Long> {

    @Query("SELECT s FROM Discente s WHERE s.eta >= :eta")
    List<Discente> trovaTuttiMaggiorenni(@Param("eta") int eta);

    @Query("SELECT s From Discente s where s.cittaResidenza = :citta")
    List<Discente> trovaResidenza(@Param("citta") String citta);

    @Query("SELECT s FROM Discente s ORDER BY s.nome ASC")
    List<Discente> DiscentiOrdinatiPerNome();

    @Query("SELECT d FROM Discente d WHERE CONCAT(d.nome, ' ', d.cognome) = :nomeCompleto")
    Optional<Discente> findByNomeCompleto(@Param("nomeCompleto") String nomeCompleto);

}
