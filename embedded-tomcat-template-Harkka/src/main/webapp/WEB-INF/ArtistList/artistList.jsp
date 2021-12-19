<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Artist List</title>
<!-- Muokkasin Script tiedoston aikaisemmasta mallista -->
<!-- Remove pois kommentoitu 
<script src="/scripts/app.js"></script>
-->
 <!-- Kopio stylen/ css linkityksen suoraan esimerkistä https://shoppinglist-ajax.herokuapp.com/list -->
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
</head>
<style>
	ul { max-width: 400px; margin-top: 20px;} ul li button { float: right; }
</style>
<body>
	<h1>Add new artist</h1>
	<form method="post">
		<input type="text" name="name" required placeholder="type new artist here..." autofocus>
		<input type="submit" value="Add to list" />
	</form>
	<!-- Talulukko -->
	<h1>All artists</h1>
	<ol>
		<c:forEach items="${ artists }" var="artist">
			<li id="artist-${ artist.getId() }">
				<c:out value="${ artist.getName() } "/>
				<!-- Remove button pois näkyvistä <button onclick="removeArtist(${ artist.getId() })">Remove</button> -->
			</li>	
		</c:forEach>
	</ol>
</body>
</html>