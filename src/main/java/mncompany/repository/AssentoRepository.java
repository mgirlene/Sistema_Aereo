package mncompany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mncompany.domain.entity.Assento;

@Repository
public interface AssentoRepository extends JpaRepository<Assento, Long> {

	List<Assento> findByIdVoo(Long id);
}
