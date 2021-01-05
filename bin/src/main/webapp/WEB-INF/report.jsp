<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Zonal Report</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body class="bg-dark">
	<br>
	<br>

	<div class="d-flex justify-content-center">
		<h1 class="text-info">ZONAL WISE REPORT</h1>
	</div>

	<br>
	<br>

	<div>
		<table class="table table-hover">
			<thead>
				<tr class="text-warning">
					<th>Zone Name</th>
					<th>Property Type</th>
					<th>Amount Collected</th>
				</tr>
			</thead>
			<tbody class="text-light">
				<c:forEach items="${report}" var="entry">
					<tr>
						<td rowspan="2"><c:out value="${entry.key}"></c:out></td>
						<c:forEach var="abc" items="${entry.value}" varStatus="stats">
							<c:if test="${stats.index eq 0}">
								<td><c:out value="${abc.key}"></c:out></td>
								<td><c:out value="${abc.value}"></c:out></td>
							</c:if>
						</c:forEach>
					</tr>
					<c:forEach var="abc" items="${entry.value}" varStatus="stats">
						<c:if test="${stats.index gt 0}">

							<tr>
								<td><c:out value="${abc.key}"></c:out></td>
								<td><c:out value="${abc.value}"></c:out></td>
							</tr>
						</c:if>
					</c:forEach>

				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>