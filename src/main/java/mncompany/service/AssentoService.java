package mncompany.service;

import java.util.List;

import mncompany.domain.entity.Assento;

public interface AssentoService {

	void salvar(Assento assento);

	void editar(Assento assento);

	void excluir(Long id);

	Assento buscarPorId(Long id);

	List<Assento> buscarTodos();
	
	List<Assento> buscarPorAssentos(Long id);
	
	List<Assento> buscarAssentosDisponiveis(Long id);
}
