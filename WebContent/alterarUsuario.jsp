	<%@page import="usuario.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/stylee.css">
<body>
<nav class="usuarioNav">
		<ul>
			
			<li><img src="img/java" height="60px"></li>
			<li><a href="cadastrarUsuario.jsp" style="font-size: 20px;" >Cadastrar Usuario</a></li>
			<li><a href="consultarUsuario.jsp" style="font-size: 20px;" >Consultar Usuario</a></li>
		</ul>
	</nav>
	<main class="usuarioMain">
		<form action="alterarUsuario" method="post" class="usuarioForm">
			
			<%
			Usuario usuario = null;
			if (request.getAttribute("usuario") != null) {
				usuario = (Usuario)request.getAttribute("usuario");
			}
			%>
			
			<input type = "hidden" name ="id" value ="<%out.print(usuario.getIdpessoa());%>" style="font-size: 20px;">
			
			
			
			
				<label><strong>Nome:</strong></label>
				<input type="text"name="nome" value="<%out.print(usuario.getNome()); %>" style="font-size: 20px;">
			
			
			
				<label><strong>Sobrenome:</strong></label>
				<input type="text"name="sobrenome" value="<%out.print(usuario.getSobrenome()); %>" style="font-size: 20px;" >
			
			
			
				<label><strong>Cpf:</strong></label>
				<input type="text" name="cpf"  value="<%out.print(usuario.getCpf()); %>" style="font-size: 20px;" >
			

         
				<label><strong>email:</strong></label>
				<input type="text"name="email" value="<%out.print(usuario.getEmail()); %> " style="font-size: 20px;" >
			

	       
			
				<input id="usuarioButton" type="submit" name="salvar"
					value="Alterar Usuario " style="font-size: 20px;" >
			
			
			<div>
			 <input type="hidden" name="id">
			</div>
			<br>
			<div>
				
			<%
			String mensagem = (String) request.getAttribute("mensagem");
			if(mensagem!=null)
				out.print(mensagem);
			
			%>
			
			</div>
		</form>
	</main>
</body>
</html>