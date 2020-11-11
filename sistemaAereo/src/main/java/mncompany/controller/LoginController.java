package mncompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mncompany.domain.Usuario;
import mncompany.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping("/")
	public String login(Usuario usuario) {
		return "login";
	}
	
	@PostMapping("/fazerLogin")
	public String fazerLogin(Usuario usuario) {
		//IMPLEMENTAR BUSCA POR EMAIL E SENHA
		return "home";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Usuario usuario) {
		service.salvar(usuario);
		return "redirect:/login";
	}
}
