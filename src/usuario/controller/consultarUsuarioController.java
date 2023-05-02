package usuario.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usuario.model.Usuario;

/**
 * Servlet implementation class buscarUsuariosController
 */
@WebServlet("/consultarUsuarioController")
public class consultarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultarUsuarioController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    String nome = request.getParameter("nome");
	    ArrayList<Usuario>usuarios = new Usuario().buscarUsuariosPeloNome(nome);
	    
	    request.setAttribute("usuarios", usuarios);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("consultarUsuario.jsp");
	    
        dispatcher.forward(request, response);
	    
//	    
//	    for(Usuario usuario : usuarios)
//	    	System.out.println("JAVAVAVA :" + usuario.getNome());
	    
	}

}
