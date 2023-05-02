<%@page import="usuario.model.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/stylee.css">

<meta charset="ISO-8859-1">
<title>CRUD-JSP</title>
</head>
<body>
	<nav class="usuarioNav">
		<ul>


			<li><img src="img/java" height="50px"></li>
			<li><a href="cadastrarUsuario.jsp" style="font-size: 20px;" >Cadastrar Usuario </a></li>
			<li><a href="consultarUsuario.jsp" style="font-size: 20px;">Consultar Usuario</a></li>
		</ul>
	</nav><br>

	
		<form action="consultarUsuario" method="post" >	
            
			<div class = "bb" style="font-size: 20px;">
				<label><strong>Buscar Usuario Nome: </strong> </label><input type="text"
					name="nome" style="font-size: 20px;" >
			
					
			
				<input id="usuarioButton" type="submit" name="salvar"
					value="Consultar Usuario" style="font-size: 20px;">
			</div><br>
			

			<div>
				<%
			String mensagem = (String) request.getAttribute("mensagem");
			if(mensagem!=null)
				out.print(mensagem);
			
			%>
			</div>


		</form>

		<%
  
  if(request.getAttribute("usuarios")!=null){
	  
	  List<?> usuarios = (List<?>)request.getAttribute("usuarios");
	  for(int contador = 0; contador<=(usuarios.size()-1);contador ++){
		  
	 Usuario usuario = (Usuario)usuarios.get(contador);
  
  %>

		<form action="modificarUsuario" method="post">

			<table class="tablepai" border="1" >
				<tr>
					<th>Id:</th>
					<th><%out.print(usuario.getIdpessoa());%></th>
					<th><input type="hidden" name="id"value="<%out.print(usuario.getIdpessoa());%>"></th>

                   
                      
             
                 

					<th>Nome:</th>
					<br>
					<td><span><%out.print(usuario.getNome());%></span></td>
					
					
					
					 
					
					
					
					
					<th>Sobrenome:</th>
					<td><span><%out.print(usuario.getSobrenome());%></span></td>
					
					
					
					
					<th>CPF:</th>
					<td><span><%out.print(usuario.getCpf());%></span></td>
				
					
					
					
					<th>Email:</th>
					<td><span><%out.print(usuario.getEmail());%></span></td>
					
					
					
					<th><input type="submit" name="alterar" value="Alterar" style="font-size: 20px;"></th>
					<th><input type="submit" name="apagar" value="Apagar" style="font-size: 20px;"></th>
					</tr>
				
			</table>
		</form>

		<%
			}}%>


	

</body>
</html>