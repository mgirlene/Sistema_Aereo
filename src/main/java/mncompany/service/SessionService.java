package mncompany.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService<T> {

	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletRequest request;
	
	public void criarSession(String nome, T objeto) {
		if(request.getSession().getAttribute(nome) == null)
			request.getSession().setAttribute(nome, objeto);
	}
	
	public T getSession(String nome) {
		return (T)session.getAttribute(nome);
	}
	
	public void clearSession() {
		request.getSession().invalidate();
	}
}
