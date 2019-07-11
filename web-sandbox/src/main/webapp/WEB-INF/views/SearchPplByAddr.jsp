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
		<h3>Find People using Street Name</h3>
		<form method="post" action="SearchPplByAddrView">
			<table>
				<tr>
<%--					<td><input type="text" name="street" size="30" /></td>--%>
						<select name="street">
							<c:forEach items="${SearchPplByAddr}" var="adr">
								<option value="${adr.street}">
										${adr.street}
								</option>
							</c:forEach>
						</select>
				</tr>
				<tr>
					<td><input type="submit" value="Search" /></td>
				</tr>
			</table>
		</form>
		</p>
	</jsp:body>
</tags:template>