<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
		
<h2><c:out value="${product.name}" /></h2>

<c:url var="productImgSrc" value="/img/product${product.id}.jpg" />
<img src="${productImgSrc}" alt="Picture of ${product.name}" class="product" />

<strong>Price: </strong>$<c:out value="${product.price}" />
<c:url var="formAction" value="/addToCart" />
<form action="${formAction}" method="POST">
	<input type="hidden" name="productId" value="${product.id}" />
	<label for="quantity">Quantity: </label>
	<input type="text" size="3" name="quantity" id="quantity" />
	<input type="submit" value="Add To Cart" />
</form>

<c:url var="productListHref" value="/productList" />
<a href="${productListHref}">&lt;&lt;&lt; Return to Catalog</a>

<c:import url="/WEB-INF/jsp/footer.jsp" />