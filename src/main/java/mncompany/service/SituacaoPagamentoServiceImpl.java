package mncompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mncompany.domain.entity.SituacaoPagamento;
import mncompany.repository.SituacaoPagamentoRepository;

@Service
@Transactional(readOnly = false)
public class SituacaoPagamentoServiceImpl implements SituacaoPagamentoService {

	@Autowired
	private SituacaoPagamentoRepository repository;

	public SituacaoPagamentoServiceImpl(SituacaoPagamentoRepository repository) {
		this.repository = repository;
	}

	@Override
	public void salvar(SituacaoPagamento situacaoPagamento) {
		this.repository.save(situacaoPagamento);
	}

	@Override
	public void editar(SituacaoPagamento situacaoPagamento) {
		this.salvar(situacaoPagamento);
	}

	@Override
	public void excluir(Long id) {
		SituacaoPagamento situacao = this.buscarPorId(id);
		this.repository.delete(situacao);
	}

	@Override
	@Transactional(readOnly = true)
	public SituacaoPagamento buscarPorId(Long id) {
		return this.repository.findById(id).orElseThrow(() -> 
			new RuntimeException("O ID informado [%s] não existe no banco."));
	}

	@Override
	@Transactional(readOnly = true)
	public List<SituacaoPagamento> buscarTodos() {
		return this.repository.findAll();
	}

}
