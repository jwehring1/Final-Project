<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tags:template>
	<jsp:attribute name="head">  
		<script type="text/javascript">
			// inline JavaScript here 
		</script>
  	</jsp:attribute>
	<jsp:body>
		<link rel="stylesheet" type="text/css" href="resources/Stylesheet.css">
		<link rel="icon" href="cartoonHouse.png">
		<title>Address Book - Search</title>
		<h1 class = topHeader>Address Book</h1>
		<ul class = navWrapper>
			<li class = navButton><a href="Home">Home</a></li>
			<li class = active><a href="Search">Search</a></li>
			<li class = navButton><a href="Add">Add</a></li>
			<li class = navButton><a href="Update">Update</a></li>
			<li class = navButton><a href="Delete">Delete</a></li>
		</ul>
		<h1>Search</h1>
		<p>
		<table class = viewtable>
			<tr class = viewth><td class = viewtd>Street</td><td class = viewtd>City</td><td class = viewtd>State</td><td class = viewtd>ZIP Code</td></tr>
			<c:forEach items="${ SearchAllAddr }" var = "adr">
				<tr class = viewth>
					<td class = viewtd>${adr.street}</td>
					<td class = viewtd>${adr.city}</td>
					<td class = viewtd>${adr.state}</td>
					<td class = viewtd>${adr.zipcode}</td>
				</tr>
			</c:forEach>
		</table>

		</p>
	</jsp:body>
</tags:template>