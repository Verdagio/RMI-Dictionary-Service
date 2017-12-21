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
	background-color: #fff4cc;
	text-align: center;
	margin: auto;
	width: 75%;
	border: 1px solid blue;
	padding: 10px;
}
.def{
	background-color: #ccffee;
}


</style>
</head>
<body>
	<div class="center">
		<form action="DictionaryServlet" method="post">
			<h1>Dictionary</h1>
			<p>For the sake of the system the "dictionary" only contains
				words beginning with A</p>
			<input type="text" name="word" size="20px"> <input
				type="submit" value="submit"><br>
		</form>
		<form action="DictionaryServlet" method="get">
			<div class="def">
				<h3><%= request.getParameter("message") %></h3>
			</div>
		</form>
	</div>
</body>
</html>