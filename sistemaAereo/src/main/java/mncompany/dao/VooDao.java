package mncompany.dao;

import java.util.List;

import mncompany.domain.Voo;

public interface VooDao {
	
	void save(Voo voo);

	void update(Voo voo);

	void delete(Long id);

	Voo findById(Long id);

	List<Voo> findAll();

}
