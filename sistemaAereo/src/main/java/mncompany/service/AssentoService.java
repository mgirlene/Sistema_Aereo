package mncompany.service;

import java.util.List;
import java.util.UUID;

import mncompany.domain.entity.Assento;
import mncompany.domain.entity.Voo;

public interface AssentoService {

	void salvar(Assento assento);

	void editar(Assento assento);

	void excluir(UUID id);

	Assento buscarPorId(UUID id);

	List<Assento> buscarTodos();
	
	List<Assento> buscarPorAssentos(Voo voo);
	
	List<Assento> buscarAssentosDisponiveis(Voo voo);
}
