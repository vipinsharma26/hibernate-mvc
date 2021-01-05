<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Page</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body class="bg-dark">
	<br>
	<br>
	<h1 class="d-flex justify-content-center text-info">Assessment
		Form</h1>

	<br>
	<br>

	<div class="d-flex justify-content-center text-light">
		<form:form action="/saveform" method="post" modelAttribute="userDto">
			<table class="table-hover" class="text-light">
				<tr>
					<td><label class="text-light" for="input1"
						style="color: black;">Year of Assessment: </label></td>
					<td><form:input type="text" class="form-input" id="input1"
							required="true" path="assessmentYear"></form:input></td>
				</tr>
				<tr>
					<td><label class="text-light" for="input2"
						style="color: black;">Name of the owner: </label></td>
					<td><form:input type="text" class="form-input" id="input2"
							required="true" path="userName"></form:input></td>
				</tr>
				<tr>
					<td><label class="text-light" for="input3"
						style="color: black;">Email: </label></td>
					<td><form:input type="text" class="form-input" id="input3"
							required="true" path="email"></form:input></td>
				</tr>
				<tr>
					<td><label class="text-light" for="input4"
						style="color: black;">Address of Property: </label></td>
					<td><form:input type="text" class="form-input" id="input4"
							required="true" path="address"></form:input></td>
				</tr>

				<tr>
					<td><label class="text-light">Zone Classification</label></td>
					<td><form:select class="text-danger" name="zoneName"
							path="zoneId" id="zone">
							<option>Select Zone</option>
							<c:forEach var="zone" items="${zones}">
								<option value="${zone.zoneId}">${zone.zoneName}</option>
							</c:forEach>
						</form:select></td>
				</tr>

				<tr>
					<td><label class="text-light">Description Of the
							Property</label></td>
					<td><form:select name="description" class="text-danger"
							path="propertyId" id="propertyInput">
							<option>Select Description</option>
							<c:forEach var="property" items="${properties}">
								<option value="<c:out value="${property.propertyId}"></c:out>">${property.description}</option>
							</c:forEach>
						</form:select></td>
				</tr>
				<tr>
					<td><label class="text-light">Status</label></td>
					<td><select name="status" class="text-danger" id="status">
							<option>Select Status</option>
							<option value="<c:out value="Tenanted"></c:out>">Tenanted</option>
							<option value="<c:out value="Owner"></c:out>">Owner</option>
					</select></td>
				</tr>

				<tr>
					<td><label class="text-light" for="input5"
						style="color: black;">Building Constructed Year: </label></td>
					<td><form:input type="text" class="form-input" id="input5"
							required="true" path="constructedYear"></form:input></td>
				</tr>
				<tr>
					<td><label class="text-light" for="input6"
						style="color: black;">Built up Area(Square feet): </label></td>
					<td><form:input type="text" class="form-input" id="input6"
							required="true" path="builtYear"></form:input></td>
				</tr>
				<tr>
					<td><label class="text-light" for="input7"
						style="color: black;">Total Tax Payable: </label></td>
					<td><form:input type="text" class="form-input1" id="input7"
							readonly="true" path="totalTax"></form:input></td>
				</tr>

			</table>

			<br>
			<br>
			<div align="center">
				<button type="button" onclick="history.back()"
					class="btn btn-outline-success">Cancel</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-outline-success">Pay
					Tax</button>
			</div>

		</form:form>

	</div>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$("#input7").click(function() {
		var builtYr = parseInt($("#input6").val());
		var constYr = parseInt($("#input5").val());
		var assessmentYear = parseInt($("#input1").val());

		var uav = ${zoneDetails}
		var rate = uav.filter(val => {
			
			return $("#zone").val() === String(val.zone.zoneId) && $("#propertyInput").val() === String(val.property.propertyId) && $("#status").val() === val.status;
			})[0].rate
		
		var total_1 = builtYr * rate * 10;
		var total_2 = total_1 - (((assessmentYear - constYr)/100) * total_1)
		var total_3 = total_2 * 0.2 * total_2
		var total_4 = total_3 * 0.24 * total_3
		var totalTax = total_3 + total_4		
		$("#input7:text").val(totalTax);
	})

</script>

</html>