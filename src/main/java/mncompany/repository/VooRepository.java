package mncompany.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mncompany.domain.entity.Voo;

@Repository
public interface VooRepository extends JpaRepository<Voo, Long> {
	
	List<Voo> findByOrigemAndDestinoAndDataSaida(String origem, String destino, LocalDate dataSaida);

	List<Voo> findByOrigemAndDestino(String origem, String destino);
}
