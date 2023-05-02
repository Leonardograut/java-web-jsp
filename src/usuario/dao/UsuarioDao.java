package usuario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import usuario.bd.MysqlConnection;
import usuario.model.Usuario;

public class UsuarioDao {

	private Connection connection;
	
	
	public UsuarioDao() {
		connection = MysqlConnection.getConnection();
	}
			
	
	public void cadastrarUsuario(Usuario usuario) {
		
	  try {
		
		  PreparedStatement pstm = connection.prepareStatement("INSERT INTO user (nome,sobrenome,cpf,email)values (?,?,?,?)");
		  pstm.setString(1, usuario.getNome());
		  pstm.setString(2, usuario.getSobrenome());
		  pstm.setString(3, usuario.getCpf());
		  pstm.setString(4, usuario.getEmail());
		  pstm.executeUpdate();
		  
		  pstm.close();
		  connection.close();
	  
		  
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
		
	
	
	
	
	public Usuario BuscarUsuarioPorId(int id) {
	    Usuario usuario = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	    try {
	        pstm = connection.prepareStatement("SELECT * FROM user WHERE idpessoa =?");
	        pstm.setInt(1, id);
	        rs = pstm.executeQuery();
	        if(rs != null && rs.next()) {
	            usuario = new Usuario();
	            usuario.setIdpessoa(rs.getInt("idpessoa"));
	            usuario.setNome(rs.getString("nome"));
	            usuario.setSobrenome(rs.getString("sobrenome"));
	            usuario.setCpf(rs.getString("cpf"));
	            usuario.setEmail(rs.getString("email"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (pstm != null) {
	            try {
	                pstm.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return usuario;
	}


		
	
	

	
	
	public ArrayList<Usuario> buscarUsuariosPeloNome(String nome) {
	    
		
	    ArrayList<Usuario> usuarios = new ArrayList<>();
	    
	    try {
	    	PreparedStatement pstm = connection.prepareStatement("SELECT * FROM user WHERE nome LIKE '%" +nome+ "%'");
	         	
	    	
	         ResultSet rs = pstm.executeQuery();
	            
	        while(rs.next()) {
	            Usuario usuario = new Usuario(); 
	            usuario.setIdpessoa(rs.getInt("idpessoa"));
                usuario.setNome(rs.getString("nome"));
	            usuario.setSobrenome(rs.getString("sobrenome"));
	            usuario.setCpf(rs.getString("cpf"));
	            usuario.setEmail(rs.getString("email"));
	            usuarios.add(usuario);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return usuarios;
	}

	
	
	
	
	
	public void ExcluirUsuario(int idpessoa) {
		
		try {
			
			PreparedStatement pstm = connection.prepareStatement("DELETE FROM user WHERE idpessoa = ?");
			
            pstm.setInt(1, idpessoa);
            pstm.executeUpdate();
			
			
		 
		} catch (Exception e) {
		   e.printStackTrace();
		}
		
	}
		
		public void AlterarProduto(Usuario usuario) {
			
			
			try {
				
				PreparedStatement pstm = connection.prepareStatement("UPDATE user SET  nome =?, sobrenome =?, cpf =?, email=? WHERE idpessoa = ?");
				pstm.setString(1,usuario.getNome());
				pstm.setString(2, usuario.getSobrenome());
				pstm.setString(3, usuario.getCpf());
				pstm.setString(4, usuario.getEmail());
				pstm.setInt(5, usuario.getIdpessoa());
				pstm.execute();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		
		
	}
	
	

	}          	
		
            	
            
            
            
          

 
        
      
    

	
	
	
	
	
