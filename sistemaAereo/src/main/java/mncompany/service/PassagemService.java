package mncompany.service;

import java.util.List;

import mncompany.domain.Passagem;
import mncompany.domain.Usuario;

public interface PassagemService {
	
	void salvar(Passagem passagem);

	void editar(Passagem passagem);

	void excluir(Long id);

	Passagem buscarPorId(Long id);

	List<Passagem> buscarTodos();
	
	List<Passagem> buscarPorPassagens(Usuario usuario);

}
