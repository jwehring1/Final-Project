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
		<title>Address Book - Update</title>
		<h1 class = topHeader>Address Book</h1>
		<ul class = navWrapper>
			<li class = navButton><a href="Home">Home</a></li>
			<li class = navButton><a href="Search">Search</a></li>
			<li class = navButton><a href="Add">Add</a></li>
			<li class = active><a href="Update">Update</a></li>
			<li class = navButton><a href="Delete">Delete</a></li>
		</ul>
		<h1>Update</h1>
		<p>
		<table>
		<form method="post" action="UpdateView">
		<tr>
			<td>Name :</td>
		</tr>
		<tr><td><input type="text" name="name" size="30" placeholder="Current: ${p.name}"/></td></tr>
		<tr>
			<td>Age :</td>
		</tr>
		<tr><td><input type="number" name="age" size="10" placeholder="Current: ${p.age}"/></td></tr>
		<tr>
			<td>SSN :</td>
		</tr>
		<tr><td><input type="number" name="ssnnew" size="20" placeholder="Current: ${p.ssn}" /></td></tr>
		<tr>
			<td>Race :</td>
		</tr>
		<tr><td><input type="text" name="race" size="30" placeholder="Current: ${p.race}" /></td></tr>
		<tr>
			<td>Height :</td>
		</tr>
		<tr><td><input type="number" name="height" size="10" placeholder="Current: ${p.height}" /></td></tr>
		<tr>
			<td>Weight :</td>
		</tr>
		<tr><td><input type="number" name="weight" size="10" placeholder="Current: ${p.weight}" /></td></tr>
		<tr>
			<td>Street :</td>
		</tr>
		<tr><td>
			<select name="street">
				<c:forEach items="${SearchAllAddr}" var="adr">
					<c:if test = "${adr.addressId == p.addr.addressId}" >
					<option value="${adr.street}" selected>
							${adr.street}
					</option>
				</c:if>
					<c:if test = "${adr.addressId != p.addr.addressId}" >
						<option value="${adr.street}">
								${adr.street}
						</option>
					</c:if>
				</c:forEach>
			</select>
			<INPUT type="HIDDEN" name="ssn" value="${p.ssn}">
		</td></tr>
		<tr></tr>
		<tr>
			<td><input type="submit" value="Update" /></td>
		</tr>
	</form>
	</table>
		</p>
	</jsp:body>
</tags:template>