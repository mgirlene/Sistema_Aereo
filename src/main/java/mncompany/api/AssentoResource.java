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
import mncompany.domain.entity.Voo;
import mncompany.service.AssentoService;
import mncompany.service.VooService;

@RestController
@RequestMapping(value = "/api/assento")
public class AssentoResource {

	@Autowired
	private AssentoService assentoService;

	@Autowired
	private VooService vooService;

	@CrossOrigin
	@PostMapping("/save")
	public ResponseEntity<Assento> saveAssento(@RequestBody Assento assento) {
		if (assento != null) {
			assentoService.salvar(assento);
			return new ResponseEntity<Assento>(assento, HttpStatus.CREATED);
		}

		return new ResponseEntity<Assento>(assento, HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/update")
	public ResponseEntity<Assento> updateAssento(@RequestBody Assento assento) {
		if (assento != null) {
			assentoService.editar(assento);
			return new ResponseEntity<Assento>(assento, HttpStatus.CREATED);
		}

		return new ResponseEntity<Assento>(assento, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Assento> deleteAssento(@PathVariable("id") Long id) {
		Assento assento = assentoService.buscarPorId(id);
		if (assento != null) {
			assentoService.excluir(id);
			return new ResponseEntity<Assento>(assento, HttpStatus.OK);
		}

		return new ResponseEntity<Assento>(assento, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/findall")
	public ResponseEntity<List<Assento>> findAll() {
		List<Assento> assentos = assentoService.buscarTodos();

		return new ResponseEntity<List<Assento>>(assentos, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/findid/{id}")
	public ResponseEntity<Assento> findId(@PathVariable("id") Long id) {
		Assento assento = assentoService.buscarPorId(id);
		return new ResponseEntity<Assento>(assento, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/findassento/{id}")
	public ResponseEntity<List<Assento>> findAssento(@PathVariable("id") Long id) {
		Voo voo = vooService.buscarPorId(id);
		List<Assento> assentos = assentoService.buscarPorAssentos(voo);

		return new ResponseEntity<List<Assento>>(assentos, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/findassentodisp/{id}")
	public ResponseEntity<List<Assento>> findAssentoDisp(@PathVariable("id") Long id) {
		Voo voo = vooService.buscarPorId(id);
		List<Assento> assentos = assentoService.buscarAssentosDisponiveis(voo);

		return new ResponseEntity<List<Assento>>(assentos, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/findassentodispclasse/{id}/{classe}")
	public ResponseEntity<List<Assento>> findAssentoDispClasse(@PathVariable("id") Long id,
			@PathVariable("classe") String classe) {
		Voo voo = vooService.buscarPorId(id);
		List<Assento> assentos = assentoService.buscarAssentosDisponiveisClasse(voo, classe);

		return new ResponseEntity<List<Assento>>(assentos, HttpStatus.OK);
	}
}
