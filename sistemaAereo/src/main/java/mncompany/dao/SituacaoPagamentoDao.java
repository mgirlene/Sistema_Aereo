package mncompany.dao;

import java.util.List;

import mncompany.domain.entity.SituacaoPagamento;

public interface SituacaoPagamentoDao {

	void save(SituacaoPagamento situacaoPagamento);

	void update(SituacaoPagamento situacaoPagamento);

	void delete(Long id);

	SituacaoPagamento findById(Long id);

	List<SituacaoPagamento> findAll();

}
