package mncompany.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import mncompany.domain.entity.Assento;
import mncompany.domain.entity.Voo;

public interface AssentoRepository extends JpaRepository<Assento, UUID> {

	List<Assento> findByIdVoo(Voo voo);
}
