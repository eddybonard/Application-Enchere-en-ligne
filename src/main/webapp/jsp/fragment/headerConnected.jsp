<header>
<% int credit = (int) session.getAttribute("credit"); %>

		<nav class="navbar navbar-expend-lg bg-dark">
			<div class="container">
				<div class="row">
					<div class="col-lg-3"><a class="navbar-brand" href="<%= request.getContextPath() %>/jsp/accueilConnecte.jsp" style="color: white;">ENI-Enchères</a></div>
				</div>
				<div class="row">
					<div class="col-lg-3"><a class="navbar-brand" href="<%= request.getContextPath() %>/jsp/ServletMesEncheres"  ><button type="button" class="btn btn-secondary">Mes Enchères</button></a></div>
					<div class="col-lg-3" ><a class="navbar-brand" href="<%= request.getContextPath() %>/jsp/ServletNouvelleEnchere"  ><button type="button" class="btn btn-secondary">+ Nouvelle enchère</button></a></div>
					<div class="col-lg-3"  style="margin-top: 5px; position: relative; left: 25px;">
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
					<div class="col-lg-3"   > <a href="<%= request.getContextPath() %>/jsp/formulaireModificationProfil.jsp" class="navbar-brand"><button type="button" class="btn btn-warning"><%= credit %> crédit</button></a></div>
				</div>
			</div>
		</nav>
	</header>