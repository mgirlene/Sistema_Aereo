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
import mncompany.domain.entity.Passagem;
import mncompany.domain.entity.SituacaoPagamento;
import mncompany.service.AssentoService;
import mncompany.service.PassagemService;
import mncompany.service.SituacaoPagamentoService;

@RestController
@RequestMapping(value = "/api/passagem")
public class PassagemResource {

	@Autowired
	private PassagemService passagemService;
	
	@Autowired
	private AssentoService assentoService;
	
	@Autowired
	private SituacaoPagamentoService pagamentoService;

	@CrossOrigin
	@PostMapping("/save")
	public ResponseEntity<Passagem> savePassagem(@RequestBody Passagem passagem) {
		if (passagem != null) {
			/*Assento assento = assentoService.buscarPorId(passagem.getAssento().getId());
			passagem.setAssento(assento);
			SituacaoPagamento pagamento = pagamentoService.buscarPorId(passagem.getAssento().getId());
			passagem.setPagamento(pagamento);*/
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

		return new ResponseEntity<List<Passagem>>(passagens, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/findid/{id}")
	public ResponseEntity<Passagem> findId(@PathVariable("id") Long id) {
		Passagem passagem = passagemService.buscarPorId(id);
		
		return new ResponseEntity<Passagem>(passagem, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/finduser/{usuario}")
	public ResponseEntity<List<Passagem>> findUser(@PathVariable("usuario") String usuario) {

		List<Passagem> passagens = passagemService.buscarPorUsuario(usuario);

		return new ResponseEntity<List<Passagem>>(passagens, HttpStatus.OK);
	}

}
