package mncompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mncompany.domain.entity.SituacaoPagamento;

@Repository
public interface SituacaoPagamentoRepository extends JpaRepository<SituacaoPagamento, Long> {

}
