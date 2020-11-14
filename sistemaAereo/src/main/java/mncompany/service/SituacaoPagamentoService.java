package mncompany.service;

import java.util.List;
import java.util.UUID;

import mncompany.domain.entity.SituacaoPagamento;

public interface SituacaoPagamentoService {
	
	void salvar(SituacaoPagamento situacaoPagamento);

	void editar(SituacaoPagamento situacaoPagamento);

	void excluir(UUID id);

	SituacaoPagamento buscarPorId(UUID id);

	List<SituacaoPagamento> buscarTodos();

}
