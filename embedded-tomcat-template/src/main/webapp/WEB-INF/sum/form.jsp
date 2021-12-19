<!doctype html>
<html>
	<head>
		<title>Sum of two integers</title>
	</head>
<body>
	<h1> Inputy two integers </h1>
	<!--  method määrittelee pyynnön tyypin, joka on oletuksena get. action minne pyyntö lähetetään -->
	<form method="post" action="/laske">
		<!-- name määrittelee, minkä nimiseen http-parametriin asetetaan. -->
		a = <input type="number" name="a"> <br />
		b = <input type="number" name="b"> <br />
		<!-- subit on lomakkeen lähetys -->
		<input type="submit">
	</form>
</body>
</html>