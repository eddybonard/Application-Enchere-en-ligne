<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initiale-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/formulaireInscrption.css">
	
<title>Inscription</title>
</head>
<body>

	

	<header>
		<nav class="navbar navbar-expend-lg bg-dark">
			<div class="container">
				<div class="row">
				<div class="col-lg-4"><a class="navbar-brand" href="accueil.jsp" style="color: white;">ENI-Enchères</a></div>
				</div>
			</div>
		</nav>
	</header>
	
	<main>
		<div class="formulaire" style="
										width: 40%; 
										margin: auto; 
										margin-top: 40px;
										border-radius: 10px 10px;
										box-shadow: 10px 10px 10px 10px;
										padding-bottom: 10px;">
		
			<form method="post" action="ServletFormulaireInscription">
			<div class="retour" style="margin-left: 600px;"><a href="connexion.jsp" > <button type="button" class="btn btn-danger">X</button></a></div>
			<fieldset>
				<legend>Inscription</legend>
					<div class="container">
						<div class="row">
							<div class="col-lg-6"><label for="pseudo">Pseudo :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="text" name="pseudo" required="required"></div>
							<div class="col-lg-6"><label for="nom">Nom :&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="text" name="nom" required="required"></div>
						</div>
						<div class="row">
							<div class="col-lg-6"><label for="prenom">Prenom :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="text" name="prenom" required="required"></div>
							<div class="col-lg-6"><label for="email">E-mail :&nbsp;&nbsp; </label><input type="email" name="email" required="required"></div>
						</div>
						<div class="row">
							<div class="col-lg-6"><label for="telephone">Téléphone :&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="tel" name="telephone" required="required"></div>
							<div class="col-lg-6"><label for="rue">Rue :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="text" name="rue" required="required"></div>
						</div>
						<div class="row">
							<div class="col-lg-6"><label for="codePostal">Code postal :&nbsp;&nbsp; </label><input type="text" name="codePostal" required="required"></div>
							<div class="col-lg-6"><label for="ville">Ville :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="text" name="ville" required="required"></div>
						</div>
						<div class="row">
							<% String passWord = (String) request.getAttribute("motDePasse");
								String confPassWord = (String) request.getAttribute("confmotDePasse");
								String erreur = (String) request.getAttribute("erreur");
				
								if(passWord != confPassWord){
									
								%>
								<p style="color: red;"><%= erreur  %></p>
								<% }%>
			
							<div class="col-lg-6"><label for="motDePasse">Mot de passe :<br>
												<em style="font-size: 12px; ">De 5 à 20 caractères maximum</em>&nbsp;&nbsp; </label><br>
												<input type="password" name="motDePasse" required="required"></div>
							<div class="col-lg-6"><label for="confmotDePasse">Confirmer le mot de passe :&nbsp;&nbsp; </label><input type="password" name="confmotDePasse" required="required"></div>
						</div><br>
						<div class="row">
							<div class="col-lg-6"><label for="credit">Offre de bienvenue :&nbsp;&nbsp; </label><input type="text" name="credit" value="500" readonly="readonly" ></div>
						</div><br>
						<div><button type="submit" class="btn btn-success">Valider</button>&nbsp;<button type="reset" class="btn btn-danger">Annuler</button></div>
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