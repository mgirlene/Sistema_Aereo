package mncompany.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

import mncompany.domain.entity.Voo;
import mncompany.service.VooService;

@RestController
@RequestMapping(value = "/api/voo")
public class vooResource {

	@Autowired
	private VooService vooService;

	@CrossOrigin
	@PostMapping("/savevoo")
	public ResponseEntity<Voo> saveVoo(@RequestBody Voo voo) {
		if (voo != null) {
			vooService.salvar(voo);
			return ResponseEntity.ok(voo);
		}

		return ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@PostMapping("/updatevoo")
	public ResponseEntity<Voo> updateVoo(@RequestBody Voo voo) {
		if (voo != null) {
			vooService.editar(voo);
			return ResponseEntity.ok(voo);
		}

		return ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@DeleteMapping("/deletevoo/{id}")
	public ResponseEntity<Voo> deleteVoo(@PathVariable("id") Long id) {
		Voo voo = vooService.buscarPorId(id);
		if (voo != null) {
			vooService.excluir(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@GetMapping("/findall")
	public ResponseEntity<List<Voo>> findAll() {
		List<Voo> voos = vooService.buscarTodos();
		if (!voos.isEmpty())
			return ResponseEntity.ok(voos);

		return ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@GetMapping("/findid/{id}")
	public ResponseEntity<Voo> findId(@PathVariable("id") Long id) {
		Voo voo = vooService.buscarPorId(id);

		if (voo != null)
			return ResponseEntity.ok(voo);

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/findvoo/{origem}/{destino}/{data}")
	public ResponseEntity<List<Voo>> findVoo(@PathVariable("origem") String origem,
			@PathVariable("destino") String destino, @PathVariable("data") String data) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(data, formatter);

		List<Voo> voos = vooService.buscarPorVoos(origem, destino, date);

		if (!voos.isEmpty())
			return ResponseEntity.ok(voos);

		return ResponseEntity.notFound().build();
	}

}