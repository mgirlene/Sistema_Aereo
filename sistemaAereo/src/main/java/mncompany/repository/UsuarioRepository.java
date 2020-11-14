package mncompany.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import mncompany.domain.entity.Usuario;


public interface UsuarioRepository  extends JpaRepository<Usuario, UUID> {
	Usuario findByEmailAndSenha(String email, String senha);
}
