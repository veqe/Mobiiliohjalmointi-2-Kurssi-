<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Shopping List</title>
<!-- Script app.js on tehtävän annossa annettu.  -->
<script src="/scripts/app.js"></script>
<!-- Kopio stylen/ css linkityksen suoraan esimerkistä https://shoppinglist-ajax.herokuapp.com/list -->
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
</head>
<style>
	ul { max-width: 400px; margin-top: 20px;} ul li button { float: right; }
</style>
<body>
	<h1>Shopping list</h1>
	<form method="post">
		<input type="text" name="title" required placeholder="type new item here..." autofocus>
		<input type="submit" value="Add to list" />
	</form>
	<!-- taulukko -->
			<ul>
				<c:forEach items="${ items }" var="shoppingListItem">
					<li id="product-${ shoppingListItem.getId() }">
					<c:out value="${ shoppingListItem.getTitle() } ${ shoppingListItem.getId() }" />
					<button onclick="removeProduct(${ shoppingListItem.getId() })">Remove</button>
					</li>
				</c:forEach>
			</ul>
</body>
</html>