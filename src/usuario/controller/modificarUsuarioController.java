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
 * Servlet implementation class modificarUsuarioController
 */
@WebServlet("/modificarUsuarioController")
public class modificarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarUsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    
	    String apagar = request.getParameter("apagar");	  
	    String id = request.getParameter("id");
	    String alterar =request.getParameter("alterar");  
	    
	    
	    
	     if(apagar !=null && id!= null) {
	    	 new Usuario().excluir(Integer.valueOf(id));
	    	 RequestDispatcher dispatcher = request.getRequestDispatcher("consultarUsuario.jsp");
	    	 request.setAttribute("mensagem", "Usuario apagado com Sucesso");
	    	 
	    	 dispatcher.forward(request, response);
	     }else if (alterar != null && id !=null) {
	    	 Usuario usuario = new Usuario().buscarUsuarioPorId(Integer.valueOf(id));
	    	 RequestDispatcher dispatcher = request.getRequestDispatcher("alterarUsuario.jsp");
             request.setAttribute("usuario", usuario);
	    	 
	    	 dispatcher.forward(request, response);
	    	 
	     }
	}

}
