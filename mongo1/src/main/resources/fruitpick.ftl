<html>
<head>
	<title>Fruit Picker</title>
</head>
<body>

<form action="/fav_fruit" method="POST">
	<p>What is your Favourite  fruit</p>
	<#list fruits as fruit>
	 <p>
	 	<input type="radio" name="fruit" value="${fruit}">${fruit}</input>
	 </p>
	</#list>
	<input type="submit" value="Submit" />
</form>

</body>
</html>