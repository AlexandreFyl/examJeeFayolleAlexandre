<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous"> 
<title>Insert title here</title>
</head>
<body>
	<div class="row justify-content-md-center h-100">
		<div class="col-sm-4 my-auto">
			<img
					src="https://img.icons8.com/cotton/2x/contact-card.png"
					class="img-fluid logo" alt="Responsive image">
			<h1 class="downMargin">Formulaire de Connexion</h1>
			<form action="/examJeeFayolleAlexandre3/login" method="post">
				<div class="form-group">
					<label for="un">Login</label>
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">@</div>
						</div>
						<input type="email" class="form-control" id="exampleInputEmail1"
							placeholder="johndoe@gmail.com" name="un">
					</div>
				</div>
				<div class="form-group">
					<label for="pw">Password</label> 
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text"><i class="fa fa-lock h-100"></i></div>
						</div>
						<input type="password" class="form-control" id="exampleInputPassword1"
							placeholder="********" name="pw">
					</div>
				</div>
				<div class="row justify-content-center">
					<button type="submit" class="btn btn-connexion">Se
						connecter</button>
				</div>

			</form>
		</div>
	</div>



</body>
</html>