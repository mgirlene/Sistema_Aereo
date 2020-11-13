package mncompany.dao;

import java.util.List;

import mncompany.domain.Assento;
import mncompany.domain.Voo;

public interface AssentoDao {

	void save(Assento assento);

	void update(Assento assento);

	void delete(Long id);

	Assento findById(Long id);

	List<Assento> findAll();
	
	List<Assento> findByAssentos(Voo voo);

}
