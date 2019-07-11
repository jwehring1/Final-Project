<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<tags:template>
	<jsp:attribute name="head">  
		<script type="text/javascript">
			// inline JavaScript here 
		</script>
  	</jsp:attribute>
	<jsp:body>
		<link rel="stylesheet" type="text/css" href="resources/Stylesheet.css">
		<link rel="icon" href="cartoonHouse.png">
		<title>Address Book - Add</title>
		<h1 class = topHeader>Address Book</h1>
		<ul class = navWrapper>
			<li class = navButton><a href="Home">Home</a></li>
			<li class = navButton><a href="Search">Search</a></li>
			<li class = active><a href="Add">Add</a></li>
			<li class = navButton><a href="Update">Update</a></li>
			<li class = navButton><a href="Delete">Delete</a></li>
		</ul>
		<h1>Add Person</h1>
		<p>
		<h3>Add New Person</h3>
		<form method="post" action="AddPersonSuc">
			<table>
				<tr>
					<td>Name :</td>
				</tr>
				<tr><td><input type="text" name="name" size="30" required /></td></tr>
				<tr>
					<td>Age :</td>
				</tr>
				<tr><td><input type="number" step="1" name="age" size="10" required /></td></tr>
				<tr>
					<td>SSN :</td>
				</tr>
				<tr><td><input type="number" step="1" name="ssn" size="20" required /></td></tr>
				<tr>
					<td>Race :</td>
				</tr>
				<tr><td><input type="text" name="race" size="30" required /></td></tr>
				<tr>
					<td>Height :</td>
				</tr>
				<tr><td><input type="number" step="1" name="height" size="10" required/></td></tr>
				<tr>
					<td>Weight :</td>
				</tr>
				<tr><td><input type="number" name="weight" size="10" required/></td></tr>
				<tr>
					<td>Street :</td>
				</tr>
				<tr><td>
					<select name="street">
						<c:forEach items="${SearchAllAddr}" var="adr">
							<option value="${adr.street}">
									${adr.street}
							</option>
						</c:forEach>
					</select>
				</td></tr>
				<tr></tr>
				<tr>
					<td><input type="submit" value="Add" /></td>
				</tr>
			</table>
		</form>
		</p>
	</jsp:body>
</tags:template>