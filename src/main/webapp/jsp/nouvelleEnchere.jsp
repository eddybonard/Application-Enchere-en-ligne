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
<title>Nouvelle Enchère</title>
</head>
<body>

	<%			String rue = (String) session.getAttribute("rue");
				String ville = (String) session.getAttribute("ville");
				String codePostal = (String) session.getAttribute("codePostal");
				 int credit = (int) session.getAttribute("credit");
				%>

	<header>
		<nav class="navbar navbar-expend-lg bg-dark">
			<div class="container">
				<div class="row">
					<div class="col-lg-3"><a class="navbar-brand" href="<%= request.getContextPath() %>/jsp/accueilConnecte.jsp" style="color: white;">ENI-Enchères</a></div>
				</div>
				<div class="row">
					<div class="col-lg-4"><a class="navbar-brand" href="<%= request.getContextPath() %>/jsp/ServletMesEncheres"  ><button type="button" class="btn btn-secondary">Mes Enchères</button></a></div>
					<div class="col-lg-4" style="margin-top: 5px;">
			 							<div class="dropdown">
								         	 <button class="btn btn-secondary dropdown-toggle" type="button" id="deroulantb" data-toggle="dropdown" ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-vinyl-fill" viewBox="0 0 16 16" style="color: green;">
		  								 	 	<path d="M8 6a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm0 3a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
		  								 	 	<path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM4 8a4 4 0 1 0 8 0 4 4 0 0 0-8 0z"/>
										  	</svg> Compte</button>
								         	 <div class="dropdown-menu" aria-labelledby="deroulantb">
								            	<a class="dropdown-item" href="<%= request.getContextPath() %>/jsp/ServletAfficherProfil">Profil</a><hr>
								           		 <a class="dropdown-item" href="<%= request.getContextPath() %>/accueil.jsp"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-vinyl-fill" viewBox="0 0 16 16" style="color: red;">
		  										<path d="M8 6a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm0 3a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
		  										<path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM4 8a4 4 0 1 0 8 0 4 4 0 0 0-8 0z"/>
											</svg> Déconexion</a>
								          </div>
			 							</div>	
					</div>
					<div class="col-lg-4"   > <a href="<%= request.getContextPath() %>/jsp/formulaireModificationProfil.jsp" class="navbar-brand"><button type="button" class="btn btn-warning"><%= credit %> crédit</button></a></div>
				</div>
			</div>
		</nav>
	</header>
	
	<main>
		<div class="formulaire" style="
										width: 40%; 
										margin: auto; 
										margin-top: 15px;		
												
										border-radius: 10px 10px;
										box-shadow: 10px 10px 10px 10px;
										padding-bottom: 10px;">
		
			<form method="post" action="ServletNouvelleEnchere">
			<div class="retour" style="margin-left: 600px;  "><a href="accueilConnecte.jsp" > <button type="button" class="btn btn-danger">X</button></a></div>
				
				<fieldset name="enchere" >
					<legend style="text-align: center;" id="enchere">Nouvelle enchère</legend>
					
					<div class="container">
							<div class="row">
								<div class="col-lg-12"><label for="article">Article :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="text" name="article"  required="required"></div>
							</div>
							<div class="row">
								<div class="col-lg-12"><label for="description">Description :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><textarea cols="20" rows="1" placeholder="..." name="description" wrap="hard" style="resize: none;" ></textarea></div>
							</div>
							<div class="row">
								<div class="col-lg-12"><label for="categorie">Catégorie :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><select name="categorie">
																																	<option value="1">Informatique</option>
																																	<option value="2">Ammeublement</option>
																																	<option value="3">Vêtement</option>
																																	<option value="4">Sport&Loisir</option>
																																			</select></div>
							</div>
							<div class="row">
								<div class="col-lg-12"><label for="photo">Photo de l'article :&nbsp;&nbsp; </label><input type="file" name="photo" accept=".png,.gif,.jpeg, .jfif"  ></div>
							</div>
							<div class="row">
								<div class="col-lg-12"><label for="prix">Mise à prix :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="number" name="prix"  min="1" required="required"></div>
							</div>
							<div class="row">
								<div class="col-lg-12"><label for="debutEnchere"> Début de l'enchère  :&nbsp;&nbsp; </label><input type="date" value="<%= LocalDate.now() %>" name="debutEnchere" ></div>
							</div>
							<div class="row">
								<div class="col-lg-12"><label for="finEnchere"> Fin de l'enchère  :&nbsp;&nbsp; </label><input type="date" name="finEnchere" ></div>
							</div>
							<fieldset>
								<legend>Retrait</legend>
									<div class="row">
										<div class="col-lg-12"><label for="rue">Rue :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </label><input type="text" name="rue"  required="required" value="<%= rue %>"></div>
									</div>
									<div class="row">
										<div class="col-lg-12"><label for="ville">Ville :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </label><input type="text" name="ville"  required="required" value="<%= ville %>"></div>
									</div>
									<div class="row">
										<div class="col-lg-12"><label for="codePostal">Code Postal :&nbsp; </label><input type="text" name="codePostal"  required="required" value="<%= codePostal %>"></div>
									</div>
							</fieldset><br>
							
							<div style="text-align: center;"> <button type="submit" class="btn btn-success">Créer l'enchère</button>&nbsp;</div>
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