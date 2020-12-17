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

import mncompany.domain.entity.SituacaoPagamento;
import mncompany.service.SituacaoPagamentoService;

@RestController
@RequestMapping(value = "/api/sitpag")
public class SituacaoPagResource {
	
	@Autowired
	private SituacaoPagamentoService sitpagService;
	
	@CrossOrigin
	@PostMapping("/save")
	public ResponseEntity<SituacaoPagamento> saveSit(@RequestBody SituacaoPagamento situacaoPagamento) {
		if(situacaoPagamento != null) {
			sitpagService.salvar(situacaoPagamento);
			return new ResponseEntity<SituacaoPagamento>(situacaoPagamento, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<SituacaoPagamento>(situacaoPagamento, HttpStatus.CONFLICT);
	}

	@CrossOrigin
	@PutMapping("/update")
	public ResponseEntity<SituacaoPagamento> updateSit(@RequestBody SituacaoPagamento situacaoPagamento) {
		if(situacaoPagamento != null) {
			sitpagService.editar(situacaoPagamento);
			return new ResponseEntity<SituacaoPagamento>(situacaoPagamento, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<SituacaoPagamento>(situacaoPagamento, HttpStatus.CONFLICT);
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<SituacaoPagamento> deletesit(@PathVariable("id") Long id) {
		SituacaoPagamento sit = sitpagService.buscarPorId(id);
		if(sit != null) {
			sitpagService.excluir(id);
			return new ResponseEntity<SituacaoPagamento>(sit, HttpStatus.OK);
		}
		
		return new ResponseEntity<SituacaoPagamento>(sit, HttpStatus.NOT_FOUND);
	}
	
	@CrossOrigin
	@GetMapping("/findall")
	public ResponseEntity<List<SituacaoPagamento>> findAll() {
		List<SituacaoPagamento> sit = sitpagService.buscarTodos();
		if(!sit.isEmpty())
			return new ResponseEntity<List<SituacaoPagamento>>(sit, HttpStatus.OK);
			//return ResponseEntity.ok(sit);
		
		return new ResponseEntity<List<SituacaoPagamento>>(sit, HttpStatus.NOT_FOUND);
		//return ResponseEntity.notFound().build();
	}
	
	@CrossOrigin
	@GetMapping("/findid/{id}")
	public ResponseEntity<SituacaoPagamento> findId(@PathVariable("id") Long id) {
		SituacaoPagamento sit = sitpagService.buscarPorId(id);
		
		if(sit != null)
			return new ResponseEntity<SituacaoPagamento>(sit, HttpStatus.OK);
		
		return new ResponseEntity<SituacaoPagamento>(sit, HttpStatus.NOT_FOUND);
	}
	
}
