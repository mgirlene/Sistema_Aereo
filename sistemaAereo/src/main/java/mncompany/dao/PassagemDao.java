package mncompany.dao;

import java.util.List;

import mncompany.domain.entity.Passagem;
import mncompany.domain.entity.Usuario;

public interface PassagemDao {
	
	void save(Passagem passagem);

	void update(Passagem passagem);

	void delete(Long id);

	Passagem findById(Long id);

	List<Passagem> findAll();
	
	List<Passagem> findByPassagens(Usuario usuario);
}
