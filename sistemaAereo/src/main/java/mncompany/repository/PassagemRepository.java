package mncompany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mncompany.domain.entity.Passagem;

@Repository
public interface PassagemRepository  extends JpaRepository<Passagem, Long> {
	List<Passagem> findByIdUsuario(Long id);
	
	@Query(value="select * from passagem as p "
			+ "inner join usuario as u on (p.id_usuario = u.id) "
			+ "inner join situacao_pagamento as s on (p.id_pagamento = s.id) "
			+ "inner join assento as a on (p.id_assento = a.id) "
			+ "inner join voo as v on (a.id_voo = v.id) "
			+ "where u.id = ?", nativeQuery = true)
	List<Passagem> findByJoin(Long id);
	
}
