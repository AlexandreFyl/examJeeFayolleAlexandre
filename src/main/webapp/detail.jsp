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

			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="${user.profilePicture}" alt="profile picture">
				<div class="card-body">
					<h5 class="card-title">${user.lastName}</h5>
					<h6 class="card-subtitle mb-2 text-muted">${user.firstName}</h6>
					<h6 class="card-subtitle mb-2">Numéro de téléphone : ${user.phoneNumber}</h6>
					<h6 class="card-subtitle mb-2">Role : ? (code non fonctionnel) </h6> <%-- ${user.isAdmin ? 'Yes' : 'No'} --%>
				</div>
			</div>


		</div>

		<hr />
	</div>

	<%@ include file='/parts/footer.jsp'%>

</body>
</html>