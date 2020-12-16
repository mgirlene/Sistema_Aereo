package mncompany.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
			return ResponseEntity.ok(passagem);
		}

		return ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@PostMapping("/update")
	public ResponseEntity<Passagem> updatePassagem(@RequestBody Passagem passagem) {
		if (passagem != null) {
			passagemService.editar(passagem);
			return ResponseEntity.ok(passagem);
		}

		return ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Passagem> deletePassagem(@PathVariable("id") Long id) {
		Passagem passagem = passagemService.buscarPorId(id);
		if (passagem != null) {
			passagemService.excluir(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@GetMapping("/findall")
	public ResponseEntity<List<Passagem>> findAll() {
		List<Passagem> passagens = passagemService.buscarTodos();
		if (!passagens.isEmpty())
			return ResponseEntity.ok(passagens);

		return ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@GetMapping("/findid/{id}")
	public ResponseEntity<Passagem> findId(@PathVariable("id") Long id) {
		Passagem passagem = passagemService.buscarPorId(id);

		if (passagem != null)
			return ResponseEntity.ok(passagem);

		return ResponseEntity.notFound().build();
	}

}
