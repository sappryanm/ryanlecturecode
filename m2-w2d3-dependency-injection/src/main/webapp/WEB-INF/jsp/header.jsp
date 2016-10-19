<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>The Seed Store</title>
		<c:url var="cssHref" value="/css/site.css" />
		<link rel="stylesheet" href="${cssHref}" />
	</head>
	<body>
		<h1>Shopping Cart Exercise</h1>
		
		<c:url var="viewCartHref" value="/viewCart" />
		<a href="${viewCartHref}">View Cart</a>