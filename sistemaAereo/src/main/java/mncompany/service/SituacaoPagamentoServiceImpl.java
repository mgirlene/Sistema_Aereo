package mncompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mncompany.dao.SituacaoPagamentoDao;
import mncompany.domain.SituacaoPagamento;

@Service
@Transactional(readOnly = false)
public class SituacaoPagamentoServiceImpl implements SituacaoPagamentoService {

	@Autowired
	private SituacaoPagamentoDao dao;

	@Override
	public void salvar(SituacaoPagamento situacaoPagamento) {
		dao.save(situacaoPagamento);
	}

	@Override
	public void editar(SituacaoPagamento situacaoPagamento) {
		dao.update(situacaoPagamento);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public SituacaoPagamento buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SituacaoPagamento> buscarTodos() {
		return dao.findAll();
	}

}
