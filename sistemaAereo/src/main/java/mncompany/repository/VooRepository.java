package mncompany.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import mncompany.domain.entity.Voo;

public interface VooRepository  extends JpaRepository<Voo, UUID> {
	List<Voo> findByOrigemAndDestinoAndDataIda(String origem, String destino, LocalDate dataIda);
}
