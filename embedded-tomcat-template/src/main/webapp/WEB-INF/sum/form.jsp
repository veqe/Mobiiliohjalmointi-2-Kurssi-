<!doctype html>
<html>
	<head>
		<title>Sum of two integers</title>
	</head>
<body>
	<h1> Inputy two integers </h1>
	<!--  method m��rittelee pyynn�n tyypin, joka on oletuksena get. action minne pyynt� l�hetet��n -->
	<form method="post" action="/laske">
		<!-- name m��rittelee, mink� nimiseen http-parametriin asetetaan. -->
		a = <input type="number" name="a"> <br />
		b = <input type="number" name="b"> <br />
		<!-- subit on lomakkeen l�hetys -->
		<input type="submit">
	</form>
</body>
</html>