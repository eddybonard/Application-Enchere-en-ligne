<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="fr.eni.enchere.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initiale-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/connexion.css">
<title>Accueil</title>
</head>
<body>

	<%@ include file="fragment/headerConnected.jsp" %>
	
	<main>
	
	<div class="formulaire" style="
										width: 40%; 
										margin: auto; 
										margin-top: 40px;
										border-radius: 10px 10px;
										box-shadow: 10px 10px 10px 10px;
										padding-bottom: 10px;">
		
			<form method="post" action="ServletAfficherProfil">
			<div class="retour" style="margin-left: 600px; margin-top: 5px;"><a href="accueilConnecte.jsp" > <button type="button" class="btn btn-danger">X</button></a></div>
			<fieldset>
				<h2 style="text-align: center">Profil</h2>
				<% 
				
				String pseudo = (String) session.getAttribute("pseudo");
				String prenom = (String) session.getAttribute("prenom");
				String nom = (String) session.getAttribute("nom");
				String email = (String) session.getAttribute("email");
				String telephone = (String) session.getAttribute("telephone");
				String rue = (String) session.getAttribute("rue");
				String ville = (String) session.getAttribute("ville");
				String codePostal = (String) session.getAttribute("codePostal");
				
				%>
				<p><label for="pseudo">Pseudo : </label><%= pseudo %></p>
				<p><label for="nom">Nom :  </label><%= nom %></p>
				<p>Prenom : <%= prenom %></p>
				<p>Email : <%= email %></p>
				<p>Telephone : <%= telephone %></p>
				<p>Rue : <%= rue %></p>
				<p>Code postal : <%= codePostal %></p>
				<p>Ville : <%= ville %></p>
				<div style="text-align: center;"><button type="submit" class="btn btn-warning">Modifier</button></div>
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