package mncompany.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mncompany.domain.entity.Voo;
import mncompany.service.VooService;

@RestController
@RequestMapping(value = "/api/voo")
public class vooResource {
	
	@Autowired
	private VooService vooService;
	
	@GetMapping("/listavoo")
	public List<Voo> listarVoos() {
		return vooService.buscarTodos();
	}
	
	@GetMapping("/listavoo/{id}")
	public Voo lista(@PathVariable("id") Long id) {
		return vooService.buscarPorId(id);
	}
	
	@GetMapping("/listavoo/{origem}/{destino}")
	public List<Voo> lista(@PathVariable("origem") String origem, 
			@PathVariable("destino") String destino) {
		return vooService.buscarPorCidades(origem, destino);
	}
	
}
