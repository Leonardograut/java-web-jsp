package usuario.model;


import java.util.ArrayList;


import usuario.dao.UsuarioDao;

public class Usuario {


	private int idpessoa;
	private String nome;
	private String sobrenome;
	private String  cpf;
	private String email;
	
	
	
	
	public String getCpf() {
		return cpf;
	}





	public void setCpf(String cpf) {
		this.cpf = cpf;
	}





	public int getIdpessoa() {
		return idpessoa;
	}





	public void setIdpessoa(int idpessoa) {
		this.idpessoa = idpessoa;
	}


 



	public Usuario(int idpessoa, String nome, String sobrenome, String cpf, String email) {
		super();
		this.idpessoa = idpessoa;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
	}


	


	public Usuario() {

	}

	




	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getSobrenome() {
		return sobrenome;
	}




	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}




	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	
	
	public void salvar() {
		new UsuarioDao().cadastrarUsuario(this);
	}
	
	

	public ArrayList<Usuario> buscarUsuariosPeloNome(String nome) {
		
		return new UsuarioDao().buscarUsuariosPeloNome(nome);
	}
	
	
	
	public void excluir(int idpessoa) {
		new UsuarioDao().ExcluirUsuario(idpessoa);
	}
	
	
	public void alterar() {
		
		new UsuarioDao().AlterarProduto(this);
	}
	
	
	public Usuario buscarUsuarioPorId(int idpessoa) {
		
		return new UsuarioDao().BuscarUsuarioPorId(idpessoa);
		
		
	}

}
