<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Hello Spring Framework</title>
</head>
<body>
	<h1>Hello Spring Framework</h1>
	<table border="1px" cellpadding="8px">
	<c:forEach var="customer" items="${customerList}">
		<tr>
			<td><c:out value="${customer.custAccount}" /></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>