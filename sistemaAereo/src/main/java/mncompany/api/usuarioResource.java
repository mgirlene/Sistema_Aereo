package mncompany.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mncompany.domain.entity.Usuario;
import mncompany.service.UsuarioService;

@RestController
@RequestMapping("/api/user")
public class usuarioResource {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private PasswordEncoder pass;

	@PostMapping("/autenticationUser")
	public ResponseEntity<Usuario> autentication(@RequestBody Usuario usuario){
		boolean email = service.getEmail(usuario.getEmail()) != null ? true : false;
		boolean senha =  service.verificarSenha(usuario.getSenha(), usuario) ? true : false;
		if(email && senha) {
			System.out.println("ok");
			return ResponseEntity.ok(service.getEmail(usuario.getEmail()));
		}
		System.out.println("no");
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("saveUser")
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario){
		if(usuario != null) {
			usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
			service.salvar(usuario);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
		}		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CONFLICT);
	}

}
