package mncompany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mncompany.domain.entity.Assento;
import mncompany.domain.entity.Voo;

@Repository
public interface AssentoRepository extends JpaRepository<Assento, Long> {

	List<Assento> findByVoo(Voo voo);
}
