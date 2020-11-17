package mncompany.service;

import java.time.LocalDate;
import java.util.List;

import mncompany.domain.entity.Voo;

public interface VooService {
	
	void salvar(Voo voo);

	void editar(Voo voo);

	void excluir(Long id);

	Voo buscarPorId(Long id);

	List<Voo> buscarTodos();
	
	List<Voo> buscarPorVoos(String origem, String destino, LocalDate dataSaida);

}
