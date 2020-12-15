package mncompany.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mncompany.domain.entity.Passagem;
import mncompany.domain.entity.PesquisaVoo;
import mncompany.domain.entity.Usuario;
import mncompany.domain.entity.Voo;
import mncompany.service.PassagemService;
import mncompany.service.SessionService;
import mncompany.service.UsuarioService;
import mncompany.service.VooService;

@RestController
public class IndexController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private VooService vooService;
	
	@Autowired
	private PassagemService passagemService;
	
	@Autowired
	private SessionService<Usuario> serviceSession;
	
	@GetMapping("/")
	public String login(Usuario usuario) {
		return "login";

	}
	
	@GetMapping("/teste/{id}")
	public Usuario teste(@PathVariable(value = "id") Long id) {
		return usuarioService.buscarPorId(id);

	}
	
	@GetMapping("/paginaPrincipal")
	public String home(Usuario usuario) {
		return "home";
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Usuario usuario) {
		Usuario user = usuarioService.buscarPorEmail(usuario.getEmail());
		
		if(user != null) {
			return new ModelAndView("login");
		}
		
		usuarioService.salvar(usuario);
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("usuario", usuario).addObject("logado", serviceSession.getSession("usuario-logado"));
		return mv;
		
	}
	
	@PostMapping("/login")
	public ModelAndView entrar(Usuario usuario) {		
		Usuario user = usuarioService.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());
		
		if(user == null) {
			return new ModelAndView("login");
		}
		
		ModelAndView mv = new ModelAndView("home");
		serviceSession.criarSession("usuario-logado", user);
		mv.addObject("usuario", user);
		mv.addObject("logado", serviceSession.getSession("usuario-logado"));
		return mv;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		serviceSession.clearSession();
		Usuario usuario = new Usuario();
		return new ModelAndView("login").addObject("usuario", usuario);
	}
	
	@PostMapping("/pesquisarPassagem")
	public ModelAndView busca(PesquisaVoo pesquisaVoo) {
		List<Voo> voosIda = vooService.buscarPorVoos(pesquisaVoo.getOrigem(), pesquisaVoo.getDestino(), pesquisaVoo.getDataIda());
		ModelAndView mv = new ModelAndView("passagens");
		mv.addObject("voosIda", voosIda);
		
		List<Voo> voosVolta = vooService.buscarPorVoos(pesquisaVoo.getDestino(), pesquisaVoo.getOrigem(), pesquisaVoo.getDataVolta());
		mv.addObject("voosVolta", voosVolta);
		
		/*List<Assento> assentos = assentoService.buscarAssentosDisponiveis(voosIda.get(0));
		mv.addObject("assentos", assentos);
		
		ModelAndView mv = new ModelAndView("passagens");
		mv.addObject("voos", vooService.buscarTodos());*/
		
		return mv;
	}
	
	@GetMapping("/minhasReservas")
	public ModelAndView reservas() {
		List<Passagem> passagens = passagemService.buscaPorJoin(serviceSession.getSession("usuario-logado").getId());
		
		ModelAndView mv = new ModelAndView("reservas");
		mv.addObject("passagens", passagens);
		
		return mv;
	}
	
}
