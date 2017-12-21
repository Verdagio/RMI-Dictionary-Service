<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DS Assignment</title>
<style type="text/css">
.center {
	background-color: #1c1c1c;
	text-align: center;
	margin: auto;
	width: 75%;
	border: 1px solid black;
	padding: 10px;
	color: white;
}
.def{
	background-color: #ccffee;
	color: #2d2d2d;
}
.btn{
    background-color: #11a4ff;
    border: none;
    color: white;
    padding: 1px 50px;
    text-align: center;
    display: inline-block;
    font-size: 20px;
}
.b{
	background-color: #303030;
}


</style>
</head>
<body class="b">
	<div class="center">
		<form action="DictionaryServlet" method="post">
			<h1>Dictionary</h1>
			<p>For the sake of the system the dictionary only contains
				approximately 5000 words beginning with A</p>
			<input type="text" name="word" size="20px"> 
			<input class="btn" type="submit" value="submit"><br>
		</form>
		<form action="DictionaryServlet" method="get">
			<div class="def">
				<h3><%= request.getParameter("message") %></h3>
			</div>
		</form>
	</div>
</body>
</html>