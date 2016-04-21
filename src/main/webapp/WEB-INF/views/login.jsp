<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
		<table>
			<tr>
				<td>Login</td>
				<td><input type ="text" name="j_username"></td>
			</tr>
			<tr>
				<td>Pass word </td>
				<td><input type="password" name="j_password"></td>
			</tr>
			<tr>
				<td> <input type="submit" value="Login"> </td>
			</tr>
		</table>
	
	</form>
</body>
</html>