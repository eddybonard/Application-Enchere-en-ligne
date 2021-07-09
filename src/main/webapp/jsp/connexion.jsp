<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initiale-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/connexion.css">
<title>Connexion</title>
</head>
<body>
	
	<header>
		<nav class="navbar navbar-expend-lg bg-dark">
			<div class="container">
				<div class="row">
				<div class="col-lg-4"><a class="navbar-brand" href="<%= request.getContextPath() %>/accueil.jsp" style="color: white;">ENI-Enchères</a></div>
				</div>
			</div>
		</nav>
	</header>
	
	<main>
		<div class="formulaire" >
			<form method="post" action="ServletConnexion" id="formulaire" >
			<fieldset>
				<legend>Connexion</legend>
				<label for="identifiant">Identifiant :&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;   </label><input type="text" name="identifiant" required="required"><br>
				<label for="password">Mot de passe :&nbsp; </label><input type="password" name="password" required="required"><br>
				<button type="submit" class="btn btn-primary">Connexion</button>
				<input type="checkbox" value="Remember" name="Remember"><label for="Remember">&nbsp; Se souvenir de moi</label>
				<a href="#" style="text-decoration: underline;">Mot de passe oublié</a><br>
				<a href="<%= request.getContextPath() %>/jsp/formulaireInscription.jsp"><button type="button" class="btn btn-primary">Créer un compte</button></a>
			</fieldset>
			</form>

		</div>
	</main>
	
	<%@ include file="fragment/piedDePage.html" %>
	
	
<!--Bootstrap Bundle with Popper-->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
</body>
</html>