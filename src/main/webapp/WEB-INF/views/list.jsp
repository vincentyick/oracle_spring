<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="fragments/header.jsp" />

<body>

	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>All customers</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Customer account</th>
					<th>Name</th>
					<th>Credit limit</th>
					<th>Created date</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="customer" items="${customerList}">
				<tr>
					<td>
						${customer.custAccount}
					</td>
					<td>${customer.custName}</td>
					<td>${customer.creditLimit}</td>
					<td>${customer.createdDate}</td>
					<td>
						<spring:url value="/${customer.custAccount}/view" var="userUrl" />
						<spring:url value="/${customer.custAccount}/delete" var="deleteUrl" /> 
						<spring:url value="/${customer.custAccount}/update" var="updateUrl" />
						<button class="btn btn-info" onclick="location.href='${userUrl}'">View</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="fragments/footer.jsp" />

</body>
</html>