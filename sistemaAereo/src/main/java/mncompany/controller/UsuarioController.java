package mncompany.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import mncompany.domain.entity.Usuario;
import mncompany.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public String login(Usuario usuario) {
		return "login";

	}

	@PostMapping("/login")
	public ModelAndView entrar(Usuario usuario) {
		Usuario user = usuarioService.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());
		if (user != null) {
			return new ModelAndView("/pesquisarPassagem/{" + user.getUuid() + "}");
		}

		return new ModelAndView("redirect:/");
	}

	@PostMapping("/cadastro")
	public ModelAndView cadastrar(@RequestBody Usuario usuario) {
		usuarioService.salvar(usuario);
		return new ModelAndView("/pesquisarPassagem/{" + usuario.getUuid() + "}");
	}

}
