package usuario.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usuario.model.Usuario;

/**
 * Servlet implementation class alterarUsuarioController
 */
@WebServlet("/alterarUsuarioController")
public class alterarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterarUsuarioController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");

	    String mensagem = "";
	    
	    String id = request.getParameter("id");
	    
	    
	    
	    String nome = request.getParameter("nome");
	    String sobrenome = request.getParameter("sobrenome");
	    String email = request.getParameter("email");
	    String cpf = request.getParameter("cpf") ;
        Usuario usuario1  = new Usuario();
	    
	    
	     if (nome != null && !nome.isEmpty() &&
	        sobrenome != null && !sobrenome.isEmpty() &&
	        email != null && !email.isEmpty() &&
	        request.getParameter("cpf") != null && !request.getParameter("cpf").isEmpty()) {
	        
	        

	        usuario1.setNome(nome);
	        usuario1.setSobrenome(sobrenome);
	        usuario1.setEmail(email);
	        usuario1.setCpf(cpf);
	        usuario1.setIdpessoa(Integer.valueOf(id));
	        usuario1.alterar();

	        mensagem = "Produto Alterado com sucesso!";
	    } else {
	        mensagem = "Todos os campos precisam ser preenchidos.";
	    }

	    // Exibe a mensagem para o usuário
	    request.setAttribute("mensagem", mensagem);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarUsuario.jsp");
	    dispatcher.forward(request, response);
		
	
	}

}
