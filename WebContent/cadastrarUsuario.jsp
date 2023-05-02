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
		<ul style="text-align: left">
					
			<li><img src="img/java" height="50px"></li>
			
			<li><a href="consultarUsuario.jsp">Consultar Usuario</a></li>
		</ul>
	</nav>
	<br><br>
	<main class="usuarioMain">
		<form action="cadastrarUsuario" method="post" class="usuarioForm">
			<div>
				<label><strong>Nome:</strong></label><input type="text"
					name="nome" style="font-size: 20px;">
			</div>
			<div>
				<label><strong>Sobrenome:</strong></label><input type="text"
					name="sobrenome" style="font-size: 20px;">
			</div>
			<div>
				<label><strong>Cpf:</strong></label><input type="text"
					name="cpf" style="font-size: 20px;">
			</div>

            <div>
				<label><strong>email:</strong></label><input type="text"
					name="email" style="font-size: 20px;">
			</div>

	        <br>
			<div>
				<input id="usuarioButton" type="submit" name="salvar"
					value="Cadastrar"   style="font-size: 20px;" style="font-size: 20px;">
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