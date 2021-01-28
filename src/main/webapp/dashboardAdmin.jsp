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

			<c:forEach var="user" items="${listUser}">
				<div class="col-md-6 m-10">
					<div class="card" style="width: 18rem; margin-top: 10px;">
						<div class="card-body">
							<img
								src="https://img.icons8.com/ios/24/000000/user-male-circle.png"
								class="img-fluid" />
							<h5 class="card-title text-center">${user.lastName}</h5>
							<h6 class="card-subtitle mb-2 text-muted">${user.firstName}</h6>
							<a href="/examJeeFayolleAlexandre3/Detail?user_id=${user.user_id}" class="card-link">Détail</a>
							<a href="/examJeeFayolleAlexandre3/UpdateUser?login=${user.login}&profilePicture=${user.profilePicture}&firstName=${user.firstName}&lastName=${user.lastName}&phoneNumber=${user.phoneNumber}" class="card-link">Modifier</a>
							<a href="/examJeeFayolleAlexandre3/DeleteUser?user_id=${user.user_id}" class="card-link">Supprimer</a>
						</div>
					</div>
				</div>
			</c:forEach>


		</div>

		<hr />
	</div>

	<%@ include file='/parts/footer.jsp'%>

</body>
</html>