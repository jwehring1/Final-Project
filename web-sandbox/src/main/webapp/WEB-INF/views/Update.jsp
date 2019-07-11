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
		<h1 name = title>Update</h1>
		<p>
		<table>
		<form method="post" action="UpdateForm">
			<tr><td>
			<select name="ssn">
				<c:forEach items="${SearchForAllPeople}" var="p">
					<option value="${p.ssn}">
							${p.name}
					</option>
				</c:forEach>
			</select></td></tr>
			</td></tr>
			<tr></tr>
			<tr>
				<td><input type="submit" value="Update"/></td>
			</tr>
		</form>
	</table>
		</p>
	</jsp:body>
</tags:template>