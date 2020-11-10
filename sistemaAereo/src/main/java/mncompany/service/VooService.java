package mncompany.service;

import java.util.List;

import mncompany.domain.Voo;

public interface VooService {
	
	void salvar(Voo voo);

	void editar(Voo voo);

	void excluir(Long id);

	Voo buscarPorId(Long id);

	List<Voo> buscarTodos();

}
