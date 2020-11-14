package mncompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mncompany.domain.entity.Assento;
import mncompany.domain.entity.Usuario;
import mncompany.domain.entity.Voo;
import mncompany.service.AssentoService;
import mncompany.service.UsuarioService;
import mncompany.service.VooService;

@Controller
public class SistemaController {
	
	@Autowired
	private UsuarioService serviceUsuario;
	
	@Autowired
	private VooService serviceVoo;
	
	@Autowired
	private AssentoService serviceAssento;
	
	private Usuario usuario;
	
	private List<Voo> voos;
	
	private Voo voo;
	
	private Assento assento;

	@GetMapping("/")
	public String login(Usuario usuario) {
		return "login";
	}
	
	@GetMapping("/paginaPrincipal")
	public String home(Voo voo) {
		this.voo = voo;
		this.voos = serviceVoo.buscarPorVoos(voo.getOrigem(), voo.getDestino(), voo.getData_saida());
		this.assento.setId_voo(voo);
		return "home";
	}

	@GetMapping("/minhasReservas")
	public String minhasReservas() {
		return "reservas";
	}
	
	@PostMapping("/fazerLogin")
	public String fazerLogin(Usuario usuario) {
		this.usuario = serviceUsuario.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());
		return "home";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Usuario usuario) {
		serviceUsuario.salvar(usuario);
		this.usuario = serviceUsuario.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());
		return "home";
	}

	@PostMapping("/pesquisarPassagem")
	public String pesquisarPassagem(ModelMap model) {
		model.addAttribute("voo", this.voos);
		model.addAttribute("assento", serviceAssento.buscarPorAssentos(this.assento.getId_voo()));
		return "passagens";
	}
	
	
}
