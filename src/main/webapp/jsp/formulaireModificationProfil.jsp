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
<title>Accueil</title>
</head>
<body>

	<%@ include file="fragment/headerConnected.jsp" %>
	
	<main>
	
	
	<% String pseudo = (String) session.getAttribute("pseudo");
				String prenom = (String) session.getAttribute("prenom");
				String nom = (String) session.getAttribute("nom");
				String email = (String) session.getAttribute("email");
				String telephone = (String) session.getAttribute("telephone");
				String rue = (String) session.getAttribute("rue");
				String ville = (String) session.getAttribute("ville");
				String codePostal = (String) session.getAttribute("codePostal");%>
				
			
	
	<div class="formulaire" style="
										width: 40%; 
										margin: auto; 
										margin-top: 15px;		
												
										border-radius: 10px 10px;
										box-shadow: 10px 10px 10px 10px;
										padding-bottom: 10px;">
		
			<form method="post" action="ServletFormulaireModification">
			<div class="retour" style="margin-left: 600px;  "><a href="accueilConnecte.jsp" > <button type="button" class="btn btn-danger">X</button></a></div>
				<fieldset>
					<legend style="text-align: center;">Modifications</legend>
					<div class="container">
							<div class="row">
								<div class="col-lg-6"><label for="pseudo">Pseudo :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="text" name="pseudo" value="<%= pseudo %>"  required="required"></div>
								<div class="col-lg-6"><label for="nom">Nom :&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="text" name="nom" required="required" value="<%= nom %>"></div>
							</div>
							<div class="row">
								<div class="col-lg-6"><label for="prenom">Prenom :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="text" value="<%= prenom %>" name="prenom" required="required"></div>
								<div class="col-lg-6"><label for="email">E-mail :&nbsp;&nbsp; </label><input type="email" name="email" required="required" value="<%= email %>"></div>
							</div>
							<div class="row">
								<div class="col-lg-6"><label for="telephone">Téléphone :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="tel" name="telephone" required="required" value="<%= telephone %>"></div>
								<div class="col-lg-6"><label for="rue">Rue :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="text" name="rue" required="required" value="<%= rue %>"></div>
							</div>
							<div class="row">
								<div class="col-lg-6"><label for="codePostal">Code postal :&nbsp;&nbsp; </label><input type="text" name="codePostal" required="required" value="<%= codePostal %>"></div>
								<div class="col-lg-6"><label for="ville">Ville :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="text" name="ville" required="required" value="<%= ville %>"></div>
							</div>
							<div class="row">
								<div class="col-lg-6"><label for="motDePasseActuel">Mot de passe actuel :</label><input type="password" name="motDePasseActuel" required="required"></div>
							</div><br>
							<div class="row">
								<% String passWord = (String) request.getAttribute("motDePasse");
									String confPassWord = (String) request.getAttribute("confmotDePasse");
					
									if(passWord != confPassWord){
										
									%>
									<p style="color: red;"><%= application.getAttribute("erreur") %></p>
									<% }%>
									
								<div class="col-lg-6"><label for="motDePasse"> Nouveau Mot de passe :&nbsp;&nbsp; </label><p><em style="font-size: 12px; ">De 5 à 20 caractères maximum</em></p><input type="password" name="newMotDePasse" ></div>
								<div class="col-lg-6"><label for="confmotDePasse">Confirmer le mot de passe :&nbsp;&nbsp; </label><input type="password" name="confmotDePasse" ></div>
							</div><br>
							<div><label for="credit">Dépot crédit :&nbsp;&nbsp; </label><input type="tel" name="credit" value="0"></div><br>
							<div style="text-align: center;"> <button type="submit" class="btn btn-success">Enregistrer les modifications</button>&nbsp;<a href="<%= request.getContextPath() %>/jsp/ServletFormulaireModification" style="text-decoration: none;" > <button type="button" class="btn btn-danger">Supprimer mon compte</button></a></div>
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