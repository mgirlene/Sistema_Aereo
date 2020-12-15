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

import mncompany.domain.entity.SituacaoPagamento;
import mncompany.service.SituacaoPagamentoService;

@RestController
@RequestMapping(value = "/api/sitpag")
public class situacaoPagResource {
	
	@Autowired
	private SituacaoPagamentoService sitpagService;
	
	@CrossOrigin
	@PostMapping("/savesit")
	public ResponseEntity<SituacaoPagamento> saveSit(@RequestBody SituacaoPagamento situacaoPagamento) {
		if(situacaoPagamento != null) {
			sitpagService.salvar(situacaoPagamento);
			return ResponseEntity.ok(situacaoPagamento);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@CrossOrigin
	@PostMapping("/updatesit")
	public ResponseEntity<SituacaoPagamento> updateSit(@RequestBody SituacaoPagamento situacaoPagamento) {
		if(situacaoPagamento != null) {
			sitpagService.editar(situacaoPagamento);
			return ResponseEntity.ok(situacaoPagamento);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@CrossOrigin
	@DeleteMapping("/deletesit")
	public ResponseEntity<SituacaoPagamento> deleteVoo(@RequestBody Long id) {
		SituacaoPagamento sit = sitpagService.buscarPorId(id);
		if(sit != null) {
			sitpagService.excluir(id);;
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@CrossOrigin
	@GetMapping("/findall")
	public ResponseEntity<List<SituacaoPagamento>> findAll() {
		List<SituacaoPagamento> sit = sitpagService.buscarTodos();
		if(!sit.isEmpty())
			return ResponseEntity.ok(sit);
		
		return ResponseEntity.notFound().build();
	}
	
	@CrossOrigin
	@GetMapping("/findid/{id}")
	public ResponseEntity<SituacaoPagamento> findId(@PathVariable("id") Long id) {
		SituacaoPagamento sit = sitpagService.buscarPorId(id);
		
		if(sit != null)
			return ResponseEntity.ok(sit);
		
		return ResponseEntity.notFound().build();
	}
	
	
	

}
