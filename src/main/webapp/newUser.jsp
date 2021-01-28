<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="fr">
<head>
<meta charset="UTF-8" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<title>Gestion des candidats</title>
</head>
<body>

	<%@ include file='/parts/headerAdmin.jsp'%>

	<div id="global" class="container">
		<div class="row">

			<form action="/examJeeFayolleAlexandre3/CreateUser" method="post">
				<div class="form-group">
					<label for="login">Login</label>
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">@</div>
						</div>
						<input type="email" class="form-control" id="exampleInputEmail1"
							placeholder="Saisissez le login" name="login">
					</div>
				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fa fa-lock h-100"></i>
							</div>
						</div>
						<input type="password" class="form-control"
							id="exampleInputPassword1" placeholder="********" name="password">
					</div>
				</div>
				<div class="form-group">
					<label for="isAdmin">Est il admin ?</label>
					<div class="input-group mb-2">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="isAdmin"
								id="exampleRadios1" value="option1"> <label
								class="form-check-label" for="exampleRadios1" name="isAdmin">Oui</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="isAdmin"
								id="exampleRadios2" value="option2" checked> <label
								class="form-check-label" for="exampleRadios2" name="isAdmin">Non</label>
						</div>
					</div>
					<div class="form-group">
						<label for="profilePicture">Url photo de profil</label>
						<div class="input-group mb-2">
							<input type="url" class="form-control" id="photo"
								placeholder="Copiez collez l'url de votre photo ici"
								name="profilePicture">
						</div>
					</div>
					<div class="form-group">
						<label for="firstName">Prénom</label>
						<div class="input-group mb-2">
							<input type="text" class="form-control" id="prenom"
								placeholder="Entrez le prénom"
								name="firstName">
						</div>
					</div>
					<div class="form-group">
						<label for="lastName">Nom</label>
						<div class="input-group mb-2">
							<input type="text" class="form-control" id="nom"
								placeholder="Entrez le nom"
								name="lastName">
						</div>
					</div>
					<div class="form-group">
						<label for="hireDate">Date d'embauche</label>
						<div class="input-group mb-2">
							<input type="date" class="form-control" id="hireDate"
								name="hireDate">
						</div>
					</div>
					<div class="form-group">
						<label for="phoneNumber">Numéro de téléphone</label>
						<div class="input-group mb-2">
							<input type="text" class="form-control" id="phoneNumber"
								name="phoneNumber">
						</div>
					</div>
					
					<div class="row justify-content-center">
						<button type="submit" class="btn btn-connexion">Ajouter utilisateur</button>
					</div>
			</form>

		</div>

		<hr />
	</div>

	<%@ include file='/parts/footer.jsp'%>

</body>
</html>