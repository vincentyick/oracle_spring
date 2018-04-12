<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="fragments/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${parameter == 'new'}">
			<h1>Add customer</h1>
		</c:when>
		<c:when test="${parameter == 'update'}">
			<h1>Update customer</h1>
		</c:when>
		<c:otherwise>
			<h1>View customer</h1>
		</c:otherwise>
	</c:choose>
	<br />
	<c:choose>
		<c:when test="${parameter == 'view'}">
			<spring:url value="/view" var="userActionUrl" />
		</c:when>
		<c:otherwise>
			<spring:url value="/customerForm" var="userActionUrl" />
		</c:otherwise>
	</c:choose>

	<form:form class="form-horizontal" method="post"
		modelAttribute="customerForm" action="${userActionUrl}">

		<spring:bind path="custAccount">
			<div class="form-group ''">
				<label class="col-sm-2 control-label">Customer account</label>
				<div class="col-sm-10">
					<form:input path="custAccount" type="text" class="form-control "
						id="custAccount" placeholder="CustAccount" readonly="${readonly}" />
					<form:errors path="custAccount" class="control-label" />
				</div>
			</div>
		</spring:bind>
		<spring:bind path="custName">
			<div class="form-group ''">
				<label class="col-sm-2 control-label">Customer name</label>
				<div class="col-sm-10">
					<form:input path="custName" type="text" class="form-control "
						id="custName" placeholder="CustName" readonly="${readonly_other}" />
					<form:errors path="custName" class="control-label" />
				</div>
			</div>
		</spring:bind>
		<spring:bind path="creditLimit">
			<div class="form-group ''">
				<label class="col-sm-2 control-label">Credit limit</label>
				<div class="col-sm-10">
					<form:input path="creditLimit" type="text" class="form-control "
						id="creditLimit" placeholder="CreditLimit"
						readonly="${readonly_other}" />
					<form:errors path="creditLimit" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${parameter == 'new'}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
					</c:when>
					<c:when test="${parameter == 'update'}">
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Back</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>

<jsp:include page="fragments/footer.jsp" />

</body>
</html>