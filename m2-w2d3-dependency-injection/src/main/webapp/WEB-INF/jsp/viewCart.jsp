<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
		
<h2>Shopping Cart Contents</h2>

<c:choose>
	<c:when test="${empty shoppingCart.purchases}">
		<p>You have no items in your cart, go buy something!</p>
	</c:when>
	<c:otherwise>
		<table id="shoppingCart">
			<tr>
				<th>Product</th>
				<th>Price Per Item</th>
				<th>Quantity</th>
				<th>Total Cost</th>
			</tr>
			<c:forEach items="${shoppingCart.purchases}" var="purchase">
			<c:set var="product" value="${purchase.product}" />
			<tr>
				<td><c:out value="${product.name}" /></td>
				<td>$<c:out value="${product.price}" /></td>
				<td><c:out value="${purchase.quantity}" /></td>
				<td>$<c:out value="${purchase.total}" /></td>
			</tr>
			</c:forEach>
			<tr>
				<th colspan="3" class="total">Total</th>
				<td>$<c:out value="${shoppingCart.total}" /></td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>

<c:url var="productListHref" value="/productList" />
<a href="${productListHref}">&lt;&lt;&lt; Return to Catalog</a>

<c:import url="/WEB-INF/jsp/footer.jsp" />