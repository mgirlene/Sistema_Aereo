package mncompany.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import mncompany.domain.entity.SituacaoPagamento;

public interface SituacaoPagamentoRepository extends JpaRepository<SituacaoPagamento, UUID> {

}
