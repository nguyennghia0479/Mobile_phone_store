<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>${product.productName}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/fontawesome/css/all.min.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/css/jquery-ui.min.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/css/product_details.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/css/search_product.css"></spring:url>'>
    
    <script src='<spring:url value="/resources/js/jquery-3.3.1.min.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/jquery-ui.min.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/bootstrap.min.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/product_details.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/add_cart.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/search_product.js"></spring:url>'></script>
</head>
<body>
    <jsp:include page="jumbotron.jsp"/>
    <jsp:include page="menu_navbar.jsp"/>
    <div class="container-fluid" style="margin-top: 20px;">
        <div class="row">
            <div class="col-sm-12 col-md-6">
                <div id="demo" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ul class="carousel-indicators">
                    <c:forEach items="${images}" var="image" varStatus="loop">
                    	<li data-target="#demo" data-slide-to="${loop.index+1}" class="active"></li>
                    </c:forEach>
                    </ul>
                    <!-- The slideshow -->
                    <div class="carousel-inner">
                    	<c:forEach items="${images}" var="image">
                    		 <div class="carousel-item">
	                            <img src="data:image/jpeg;base64,${image.base64}" alt="${product.productName}">
	                        </div>
                    	</c:forEach>
                    </div>
                    <!-- Left and right controls -->
                    <a class="carousel-control-prev" href="#demo" data-slide="prev">
                        <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#demo" data-slide="next">
                        <span class="carousel-control-next-icon"></span>
                    </a>
                </div>
                <div class="card">
                    <div class="card-header">
                        Comment box
                    </div>
                    <div class="card-body">
	                    <c:choose>
	                    	<c:when test="${pageContext.request.userPrincipal.name != null}">
	                    		<form:form action="post-comment" method="post" modelAttribute="commentInfo">
	                    			<form:input path="commentId" type="hidden"/>
	                     			<form:input path="product.productId" type="hidden" value="${product.productId}"/>
	                     			<form:input path="username" type="hidden" value="${pageContext.request.userPrincipal.name}"/>
	                         		<form:textarea path="content" class="form-control" rows="3" placeholder="Share your comments"></form:textarea>
	                    			<br>
	                    			<button type="submit" class="btn btn-primary">Share</button>
	                    		</form:form>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<textarea class="form-control" rows="3" placeholder="Share your comments"></textarea>
	                    		<br>
	                    		<a href="${pageContext.request.contextPath}/login" class="btn btn-primary">
	                    			Login to comment
	                    		</a>
	                    	</c:otherwise>
	                    </c:choose>
                    </div>
                </div>
                <br>
                <div class="card">
                    <div class="card-header">
                        Reviews
                    </div>
                    <div class="card-body">
                    	<c:forEach items="${comments}" var="comment">
                    		<br>
                    		<blockquote class="blockquote mb-0">
	                            <p>${comment.content}</p>
	                            <footer class="blockquote-footer">${comment.username}</footer>
	                        	<footer class="blockquote-footer"><fmt:formatDate value="${comment.date}" pattern="dd-MM-yyyy"/></footer>
	                        </blockquote>
                    	</c:forEach>    
                    	<br>
                    		<blockquote class="blockquote mb-0">
	                            <p>Good</p>
	                            <footer class="blockquote-footer">Anonymous - 24-12-2019</footer>
	                        </blockquote>
	                   	<br>
                    		<blockquote class="blockquote mb-0">
	                            <p>I'm very happy</p>
	                            <footer class="blockquote-footer">Anonymous - 24-12-2019</footer>
	                        </blockquote>                      
                        <br>
                        <div class="text-center">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="text-center">${product.productName}</h5>
                    </div>
                    <div class="card-body">
                        <div class="attribute-item py mx">
                            <h5 class="w40 font-weight-bold">General</h5>
                            <p class="w60"></p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">Brand</p>
                            <p class="w60">${product.brand}</p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">Name</p>
                            <p class="w60">${product.productName}</p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">Price</p>
                            <p class="w60"><fmt:formatNumber value="${product.productPrice}" type="number" maxFractionDigits="3"/> VND</p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">Color</p>
                            <p class="w60">${product.color}</p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">Guarantee</p>
                            <p class="w60">${product.guarantee} months</p>
                        </div>
                        <div class="attribute-item py mx">
                            <h5 class="w40 font-weight-bold">Screen</h5>
                            <p class="w60"></p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">Type Screen</p>
                            <p class="w60">${product.typeScreen}</p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">Resolution</p>
                            <p class="w60">${product.resolution} Pixels</p>
                        </div>
                        <div class="attribute-item py mx">
                            <h5 class="w40 font-weight-bold">Camera</h5>
                            <p class="w60"></p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">Front Camera</p>
                            <p class="w60">${product.frontCamera}</p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">Rear Camera</p>
                            <p class="w60">${product.rearCamera}</p>
                        </div>
                        <div class="attribute-item py mx">
                            <h5 class="w40 font-weight-bold">System</h5>
                            <p class="w60"></p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">Chip</p>
                            <p class="w60">${product.chip}</p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">RAM</p>
                            <p class="w60">${product.ram} GB</p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">Storage</p>
                            <p class="w60">${product.storage} GB</p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">Battery</p>
                            <p class="w60">${product.battery} mAh</p>
                        </div>
                        <div class="attribute-item py mx">
                            <p class="w40 ml10 font-weight-bold">Operating System</p>
                            <p class="w60">${product.operatingSystem}</p>
                        </div>
                    </div>
                </div>
                <form class="attribute-item py mx">
                	<input type="hidden" class="productId" name="productId" value="${product.productId}">
                	<button type="submit" class="btn btn-primary w40 ml10" formmethod="post" formaction="${pageContext.request.contextPath}/buy-item">Buy</button>
                   	<button class="btn btn-outline-primary w60 ml10 add-cart">Add cart</button>
               	</form>
            </div>
        </div>
    </div>
    <br>
    <jsp:include page="footer.jsp"/>
</body>
</html>