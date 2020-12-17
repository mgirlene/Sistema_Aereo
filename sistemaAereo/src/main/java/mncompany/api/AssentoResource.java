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

import mncompany.domain.entity.Assento;
import mncompany.service.AssentoService;

@RestController
@RequestMapping(value = "/api/assento")
public class AssentoResource {

	@Autowired
	private AssentoService assentoService;

	@CrossOrigin
	@PostMapping("/save")
	public ResponseEntity<Assento> saveAssento(@RequestBody Assento assento) {
		if (assento != null) {
			assentoService.salvar(assento);
			return new ResponseEntity<Assento>(assento, HttpStatus.CREATED);
		}

		return new ResponseEntity<Assento>(assento, HttpStatus.NOT_FOUND);
	}

	@CrossOrigin
	@PutMapping("/update")
	public ResponseEntity<Assento> updateAssento(@RequestBody Assento assento) {
		if (assento != null) {
			assentoService.editar(assento);
			return new ResponseEntity<Assento>(assento, HttpStatus.CREATED);
		}

		return new ResponseEntity<Assento>(assento, HttpStatus.NOT_FOUND);
	}

	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Assento> deleteAssento(@PathVariable("id") Long id) {
		Assento assento = assentoService.buscarPorId(id);
		if (assento != null) {
			assentoService.excluir(id);
			return new ResponseEntity<Assento>(assento, HttpStatus.OK);
		}

		return new ResponseEntity<Assento>(assento, HttpStatus.NOT_FOUND);
	}

	@CrossOrigin
	@GetMapping("/findall")
	public ResponseEntity<List<Assento>> findAll() {
		List<Assento> assentos = assentoService.buscarTodos();
		if (!assentos.isEmpty())
			return new ResponseEntity<List<Assento>>(assentos, HttpStatus.OK);

		return new ResponseEntity<List<Assento>>(assentos, HttpStatus.NOT_FOUND);
	}

	@CrossOrigin
	@GetMapping("/findid/{id}")
	public ResponseEntity<Assento> findId(@PathVariable("id") Long id) {
		Assento assento = assentoService.buscarPorId(id);

		if (assento != null)
			return new ResponseEntity<Assento>(assento, HttpStatus.OK);

		return new ResponseEntity<Assento>(assento, HttpStatus.NOT_FOUND);
	}

}
