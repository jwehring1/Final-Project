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


		<table class = viewtable>
			<tr class = viewth><td class = viewtd>Street</td><td class = viewtd>City</td><td class = viewtd>State</td><td class = viewtd>ZIP Code</td>
		<tr class = viewth>
				<td class = viewtd>${p.street}</td>
				<td class = viewtd>${p.city}</td>
				<td class = viewtd>${p.state}</td>
				<td class = viewtd>${p.zipcode}</td>
			</tr>
		</table>


		<h3>Success!</h3>

		</p>
	</jsp:body>
</tags:template>