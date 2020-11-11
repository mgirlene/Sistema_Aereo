package mncompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mncompany.domain.Voo;

@Controller
public class HomeController {

	@GetMapping("/paginaPrincipal")
	public String home(Voo voo) {
		return "home";
	}

	@GetMapping("/minhasReservas")
	public String minhasReservas() {
		return "reservas";
	}
	
	@PostMapping("/pesquisarPassagem")
	public String pesquisarPassagem(Voo voo) {
		//IMPLEMENTAR BUSCA
		return "passagens";
	}
	
}
