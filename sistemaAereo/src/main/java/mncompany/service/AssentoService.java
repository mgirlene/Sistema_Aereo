package mncompany.service;

import java.util.List;

import mncompany.domain.Assento;
import mncompany.domain.Voo;

public interface AssentoService {

	void salvar(Assento assento);

	void editar(Assento assento);

	void excluir(Long id);

	Assento buscarPorId(Long id);

	List<Assento> buscarTodos();
	
	List<Assento> buscarPorAssentos(Voo voo);
}
