package mncompany.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mncompany.domain.entity.Usuario;
import mncompany.service.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@CrossOrigin
	@PostMapping("/save")
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
		if (usuario != null) {
			usuarioService.salvar(usuario);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.NOT_FOUND);
	}

	@CrossOrigin
	@PutMapping("/update")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
		if (usuario != null) {
			usuarioService.editar(usuario);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.NOT_FOUND);
	}

	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable("id") Long id) {
		Usuario usuario = usuarioService.buscarPorId(id);
		if (usuario != null) {
			usuarioService.excluir(id);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.NOT_FOUND);
	}

	@CrossOrigin
	@GetMapping("/findall")
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> usuarios = usuarioService.buscarTodos();
		if (!usuarios.isEmpty())
			return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);

		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.NOT_FOUND);
	}

	@CrossOrigin
	@GetMapping("/findid/{id}")
	public ResponseEntity<Usuario> findId(@PathVariable("id") Long id) {
		Usuario usuario = usuarioService.buscarPorId(id);

		if (usuario != null)
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

		return new ResponseEntity<Usuario>(usuario, HttpStatus.NOT_FOUND);
	}

}
