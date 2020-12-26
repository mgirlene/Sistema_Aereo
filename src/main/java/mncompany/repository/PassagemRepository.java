package mncompany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mncompany.domain.entity.Passagem;
import mncompany.domain.entity.Usuario;

@Repository
public interface PassagemRepository  extends JpaRepository<Passagem, Long> {
	List<Passagem> findByIdUsuario(Usuario idUsuario);
			
}
