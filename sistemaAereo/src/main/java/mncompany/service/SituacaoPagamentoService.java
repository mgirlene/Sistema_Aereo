package mncompany.service;

import java.util.List;

import mncompany.domain.SituacaoPagamento;

public interface SituacaoPagamentoService {
	
	void salvar(SituacaoPagamento situacaoPagamento);

	void editar(SituacaoPagamento situacaoPagamento);

	void excluir(Long id);

	SituacaoPagamento buscarPorId(Long id);

	List<SituacaoPagamento> buscarTodos();

}
