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
		<h1>Add Address</h1>
		<p>
		<h3>Add New Address</h3>
		<form method="post" action="AddAddressSuc">
			<table>
				<tr>
					<td>Street :</td>
				</tr>
				<tr><td><input type="text" name="street" size="30" required /></td></tr>
				<tr>
					<td>City :</td>
				</tr>
				<tr><td><input type="text" name="city" size="30" required /></td></tr>
				<tr>
					<td>State :</td>
				</tr>
				<tr><td><input type="text" name="state" size="30" required /></td></tr>
				<tr>
					<td>ZIP Code :</td>
				</tr>
				<tr><td><input type="number" step="1" name="zipcode" size="10" required /></td></tr>
				<tr></tr>
				<tr>
					<td><input type="submit" value="Add" /></td>
				</tr>
			</table>
		</form>
		</p>
	</jsp:body>
</tags:template>