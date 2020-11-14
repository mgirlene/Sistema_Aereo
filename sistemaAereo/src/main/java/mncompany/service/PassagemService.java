package mncompany.service;

import java.util.List;
import java.util.UUID;

import mncompany.domain.entity.Passagem;
import mncompany.domain.entity.Usuario;

public interface PassagemService {
	
	void salvar(Passagem passagem);

	void editar(Passagem passagem);

	void excluir(UUID id);

	Passagem buscarPorId(UUID id);

	List<Passagem> buscarTodos();
	
	List<Passagem> buscarPorPassagens(Usuario usuario);

}
