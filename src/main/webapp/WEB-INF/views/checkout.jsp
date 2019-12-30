<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Checkout</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/fontawesome/css/all.min.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/css/checkout.css"></spring:url>'>
    
    <script src='<spring:url value="/resources/js/jquery-3.3.1.min.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/bootstrap.min.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/checkout.js"></spring:url>'></script>
 
</head>
<body class="bg-light">
    <div class="container">
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
            <h2>Checkout form</h2>
        </div>
        <div class="row">
            <div class="col-md-4 order-md-2 mb-4 scrollable">
                <h4 class="d-flex justify-content-between align-items-center mb-3">
                    <span class="text-muted">Your cart</span>
                    <span class="badge badge-primary badge-pill">${totalItems}</span>
                </h4>
                <ul class="list-group mb-3">
                	<c:forEach items="${cartItems}" var="item">
                		<li class="list-group-item d-flex justify-content-between lh-condensed">
	                        <div>
	                            <h6 class="my-0">${item.productInfo.productName}</h6>
	                            <small class="text-muted">Quantity: ${item.quantity}</small>
	                        </div>
	                        <span class="text-muted"><fmt:formatNumber value="${item.productInfo.productPrice}" type="number" maxFractionDigits="3"/> VND</span>
	                    </li>
                	</c:forEach>
                    <li class="list-group-item d-flex justify-content-between">
                        <span>Total</span>
                        <strong><fmt:formatNumber value="${totalPrice}" type="number" maxFractionDigits="3"/> VND</strong>
                    </li>
                </ul>
            </div>
            <div class="col-md-8 order-md-1">
                <h4 class="mb-3">Billing address</h4>
                <form:form class="needs-validation" id="form-validation" modelAttribute="billInfo">
                	<form:input path="billId" type="hidden"/>
                    <div class="mb-3">
                        <form:label path="fullName" for="fullName">Full Name</form:label>
                        <form:input path="fullName" type="text" class="form-control" id="fullName" placeholder="Your full name" readonly="${account}"/>
                        <div class="invalid-feedback">
                            Please enter your full name.
                        </div>
                    </div>

                    <div class="mb-3">
                        <form:label path="shippingAddress" for="address">Shipping Address</form:label>
                        <form:input path="shippingAddress" type="text" class="form-control" id="address" placeholder="Shipping address"/>
                        <div class="invalid-feedback">
                            Please enter your shipping address.
                        </div>
                    </div>

                    <div class="mb-3">
                        <form:label path="phoneNumber" for="phoneNumber">Phone number</form:label>
                        <form:input path="phoneNumber" type="text" class="form-control" id="phoneNumber" placeholder="Your phone number" readonly="${account}"/>
                        <div class="invalid-feedback">
                            Please enter your phone number.
                        </div>
                    </div>

                    <div class="mb-3">
                        <form:label path="email" for="email">Email <span class="text-muted">(Optional)</span></form:label>
                        <form:input path="email" type="email" class="form-control" id="email" placeholder="Your email" readonly="${account}"/>
                        <div class="invalid-feedback">
                            Please enter a valid email address for shipping updates.
                        </div>
                    </div>
                    
                    <hr class="mb-4">
                    <h4 class="mb-3">Payment</h4>
                    <div class="d-block my-3">
                    	<div class="custom-control custom-radio">
                            <form:radiobutton path="payment" id="cash" name="paymentMethod" value="cash" class="custom-control-input"/>
                            <form:label path="payment" class="custom-control-label" for="cash">Cash</form:label>
                        </div>
                        <div class="custom-control custom-radio">
                            <form:radiobutton path="payment" id="credit" name="paymentMethod" value="credit card" class="custom-control-input"/>
                            <form:label path="payment" class="custom-control-label" for="credit">Credit card</form:label>
                        </div>
                        <div class="custom-control custom-radio">
                            <form:radiobutton path="payment" id="debit" name="paymentMethod" value="debit card" class="custom-control-input"/>
                            <form:label path="payment" class="custom-control-label" for="debit">Debit card</form:label>
                        </div>
                        <div class="custom-control custom-radio">
                            <form:radiobutton path="payment" id="paypal" name="paymentMethod" value="paypal" class="custom-control-input"/>
                            <form:label path="payment" class="custom-control-label" for="paypal">Paypal</form:label>
                        </div>
                    </div>
                    <hr class="mb-4">
                    <c:if test="${!empty cartItems}">
                    	<button class="btn btn-success btn-lg btn-block" type="submit">Complete</button>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/cart" class="btn btn-danger btn-lg btn-block">Cancel</a>
                </form:form>
            </div>
        </div>
    </div>
    <br>
    <jsp:include page="footer.jsp"/>
</body>
</html>