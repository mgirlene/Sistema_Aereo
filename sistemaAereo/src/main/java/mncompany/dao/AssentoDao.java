package mncompany.dao;

import java.util.List;

import mncompany.domain.Assento;

public interface AssentoDao {

	void save(Assento assento);

	void update(Assento assento);

	void delete(Long id);

	Assento findById(Long id);

	List<Assento> findAll();

}
