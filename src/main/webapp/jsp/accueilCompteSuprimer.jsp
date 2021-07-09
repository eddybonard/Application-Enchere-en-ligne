<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.time.LocalDate"%>
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
	<% String pseudo = (String) session.getAttribute("pseudo");
	String article = (String) session.getAttribute("article");
	int prix = 0;
	if(session.getAttribute("prix") != null){
		prix = (int) session.getAttribute("prix");
	}else{
		 prix = 0;
	}%>
	<%@ include file="fragment/headerDisconnected.jsp" %>
	
	<main>
		<div class="container" style="margin-top: 10px;">
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
		   			<h5 class="alert-heading">Compte supprimé</h5>
		   		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		     		 <span aria-hidden="true">×</span>
		  		 </button>
			</div>
		</div>
		
		<div class="jumbotron">
			<h2 style="text-align: center;">Bienvenue aux "ENI-Enchères" </h2>
		</div>
	
		<div class="container">
			<form method="post" action="/recherche/">
				<fieldset>
					<legend>Filtres :</legend>
					 <div class="input-group">
				        <div class="input-group-prepend">
				          <select id="oCategorie" name="oCategorie" class="form-control">
				            <option selected="selected" value="0">Catégorie</option>
				            <option value="1">Informatique</option>
				            <option value="1">Ameublement</option>
				            <option value="1">Vêtement</option>
				            <option value="1">Sport&Loisir</option>
				          </select>
				        </div>
				        <input id="oSaisie" name="oSaisie" type="text" class="form-control" aria-label="Saisie de mots clés" required="required">
				        <div class="input-group-append">
				          <button class="btn btn-primary" type="submit">Recherche</button>
				        </div>
				      </div>
				</fieldset>
			</form>
		</div>
		<div class="container">
					<div class="row">
						<div class="col-lg-4" style="margin-top: 10px;">
							<div class="card" style="width: 18em;">
								<img alt="photo de l'Article" src="<%= request.getContextPath() %>/img//photo.jfif">
									<div class="card-body">
										<h5><%= article %></h5>
										<p>Prix : <%= prix %> </p>
										<p>Fin d'enchère : <%= LocalDate.now() %> </p>
										<p>Vendeur : <%= pseudo %></p>
										<a href="<%= request.getContextPath() %>/jsp/ServletAfficherDetailEnchere"><button class="btn btn-info" type="button"  >Détails</button></a>
									</div>
								</div>
							</div>
							<div class="col-lg-4" style="margin-top: 10px; ">
							<div class="card" style="width: 18em;">
								<img alt="photo de l'Article" src="<%= request.getContextPath() %>/img//photo.jfif">
									<div class="card-body">
										<h5>Titre</h5>
										<p>Prix : </p>
										<p>Fin d'enchère : </p>
										<p>Vendeur :</p>
										<a href="<%= request.getContextPath() %>/jsp/ServletAfficherDetailEnchere"><button class="btn btn-info" type="button"  >Détails</button></a>
									</div>
								</div>
							</div>
							
						</div>
					</div>
	
	</main>
	
	<%@ include file="fragment/piedDePage.html" %>

<!--Bootstrap Bundle with Popper-->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
</body>
</html>