package mncompany.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import mncompany.domain.entity.Voo;

public interface VooService {
	
	void salvar(Voo voo);

	void editar(Voo voo);

	void excluir(UUID id);

	Voo buscarPorId(UUID id);

	List<Voo> buscarTodos();
	
	List<Voo> buscarPorVoos(String origem, String destino, LocalDate dataIda);

}
