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

import mncompany.domain.entity.Passagem;
import mncompany.service.PassagemService;

@RestController
@RequestMapping(value = "/api/passagem")
public class PassagemResource {

	@Autowired
	private PassagemService passagemService;

	@CrossOrigin
	@PostMapping("/save")
	public ResponseEntity<Passagem> savePassagem(@RequestBody Passagem passagem) {
		if (passagem != null) {
			passagemService.salvar(passagem);
			return new ResponseEntity<Passagem>(passagem, HttpStatus.CREATED);
		}

		return new ResponseEntity<Passagem>(passagem, HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/update")
	public ResponseEntity<Passagem> updatePassagem(@RequestBody Passagem passagem) {
		if (passagem != null) {
			passagemService.editar(passagem);
			return new ResponseEntity<Passagem>(passagem, HttpStatus.CREATED);
		}

		return new ResponseEntity<Passagem>(passagem, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Passagem> deletePassagem(@PathVariable("id") Long id) {
		Passagem passagem = passagemService.buscarPorId(id);
		if (passagem != null) {
			passagemService.excluir(id);
			return new ResponseEntity<Passagem>(passagem, HttpStatus.OK);
		}

		return new ResponseEntity<Passagem>(passagem, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/findall")
	public ResponseEntity<List<Passagem>> findAll() {
		List<Passagem> passagens = passagemService.buscarTodos();
		if (!passagens.isEmpty())
			return new ResponseEntity<List<Passagem>>(passagens, HttpStatus.OK);

		return new ResponseEntity<List<Passagem>>(passagens, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/findid/{id}")
	public ResponseEntity<Passagem> findId(@PathVariable("id") Long id) {
		Passagem passagem = passagemService.buscarPorId(id);

		if (passagem != null)
			return new ResponseEntity<Passagem>(passagem, HttpStatus.OK);

		return new ResponseEntity<Passagem>(passagem, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/finduser/{id}")
	public ResponseEntity<List<Passagem>> findUser(@PathVariable("id") Long id) {
		List<Passagem> passagens = passagemService.buscarPorUsuario(id);
		
		if(passagens != null)
			return new ResponseEntity<List<Passagem>>(passagens, HttpStatus.OK);
		
		return new ResponseEntity<List<Passagem>>(passagens, HttpStatus.OK);
	}

}
