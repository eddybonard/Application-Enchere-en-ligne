<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
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
<title>Details Enchère</title>
</head>
<body>

	

	<header>
		
		<%@ include file="fragment/headerDisconnected.jsp" %>
		
	</header>
	
	<main>
	<% 			String article = (String) session.getAttribute("article");
				String description = (String) session.getAttribute("description");
 				String pseudo = (String) session.getAttribute("pseudo");
 				
 				int prix = (int) session.getAttribute("prix");
				String rue = (String) session.getAttribute("rue");
				String ville = (String) session.getAttribute("ville");
				String codePostal = (String) session.getAttribute("codePostal");
				%>
	
		<div class="formulaire" style="
										width: 40%; 
										margin: auto; 
										margin-top: 15px;		
												
										border-radius: 10px 10px;
										box-shadow: 10px 10px 10px 10px;
										padding-bottom: 10px;">
		
			<form method="post" action="ServletAfficherDetailEnchere">
			<div class="retour" style="margin-left: 600px;  "><a href="accueilConnecte.jsp" > <button type="button" class="btn btn-danger">X</button></a></div>
				
				<fieldset name="enchere" >
					<legend style="text-align: center;" id="enchere">Detail enchère</legend>
					
					<div class="container">
							<div class="row">
								<div class="col-lg-12"><label for="article">Article : <%= article %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label></div>
							</div>
							<div class="row">
								<div class="col-lg-12"><label for="description">Description :  <%= description %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label></div>
							</div>
							<div class="row">
								<div class="col-lg-12"><label for="categorie">Catégorie :  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label></div>
							</div>
							<div class="row">
								<div class="col-lg-12"><label for="offre">Meilleure offre : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></div>
							</div>
							<div class="row">
								<div class="col-lg-12"><label for="prix">Mise à prix :  <%= prix %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></div>
							</div>
							<div class="row">
								<div class="col-lg-12"><label for="finEnchere"> Fin de l'enchère  :  <%= LocalDate.now() %>&nbsp;&nbsp; </label></div>
							</div>
							<div class="row">
								<div class="col-lg-12"><label for="Retrait">Retrait :</label> <p><%= rue %><br>
																								<%= codePostal %> <%= ville %></p>
																								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </div>
							</div>
							
					
							<div style="text-align: center;"> <button type="submit" class="btn btn-warning">Enchérir</button>&nbsp;</div>
					</div>
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