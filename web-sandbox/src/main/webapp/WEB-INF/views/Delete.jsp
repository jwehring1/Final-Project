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
		<title>Address Book - Delete</title>
		<h1 class = topHeader>Address Book</h1>
		<ul class = navWrapper>
			<li class = navButton><a href="Home">Home</a></li>
			<li class = navButton><a href="Search">Search</a></li>
			<li class = navButton><a href="Add">Add</a></li>
			<li class = navButton><a href="Update">Update</a></li>
			<li class = active><a href="Delete">Delete</a></li>
		</ul>
		<h1 name = title>Delete</h1>
		<p>

		<h4>Delete a Person from the Address Book After Death</h4>
		<table>
			<tr>
			<form method="post" action="DeleteView">

						<%--					<td><input type="text" name="street" size="30" /></td>--%>
					<select name="ssn">
						<c:forEach items="${Delete}" var="p">
							<option value="${p.ssn}">
									${p.name}
							</option>
						</c:forEach>
					</select>
				</tr>
				<tr>
					<td><input type="submit" value="Delete" /></td>
				</form>
				</tr>
			</table>


		</p>
	</jsp:body>
</tags:template>