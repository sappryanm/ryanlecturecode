<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
		
<h2>Garden Vegetable Seeds</h2>
<ul>
<c:forEach var="product" items="${products}">
	<c:url var="productHref" value="/productDetail">
		<c:param name="productId">${product.id}</c:param>
	</c:url>
	<li>
		<a href="${productHref}"><c:out value="${product.name}" /></a>
	</li>
</c:forEach>
</ul>
	
<c:import url="/WEB-INF/jsp/footer.jsp" />