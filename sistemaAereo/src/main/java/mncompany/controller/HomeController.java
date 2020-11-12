package mncompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mncompany.domain.Voo;
import mncompany.service.AssentoService;
import mncompany.service.VooService;

@Controller
public class HomeController {
	
	@Autowired
	private VooService service;
	
	@Autowired
	private AssentoService serviceAssento;
	
	@GetMapping("/paginaPrincipal")
	public String home(Voo voo) {
		return "home";
	}

	@GetMapping("/minhasReservas")
	public String minhasReservas() {
		return "reservas";
	}
	
	@PostMapping("/pesquisarPassagem")
	public String pesquisarPassagem(ModelMap model) {
		model.addAttribute("voo", service.buscarTodos() );
		model.addAttribute("assento", serviceAssento.buscarPorId(2L));
		return "passagens";
	}
	
}
