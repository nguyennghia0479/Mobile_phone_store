<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-expand-lg navbar-dark" style="background-color:black;">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/home">Logo</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
	    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
	        <c:choose>
	        	<c:when test="${pageContext.request.userPrincipal.name != null}">
	        		<li class="nav-item dropdown">
			            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       		<i class="fas fa-user"></i> ${pageContext.request.userPrincipal.name}
                        </a>
			            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
			            	<security:authorize access="hasRole('ADMIN')">
			            		<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/"><i class="fas fa-tasks"></i> Admin</a>
			            	</security:authorize>
			                <a class="dropdown-item" href="#"><i class="fas fa-user-edit"></i> Profile</a>
			                <a class="dropdown-item" href="${pageContext.request.contextPath}/logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
			            </div>
			        </li>
	        	</c:when>
	        	<c:otherwise>
	        		<li class="nav-item">
			            <a class="nav-link" href="${pageContext.request.contextPath}/login"><i class="fas fa-sign-in-alt"></i> Login</a>
			        </li>
	        	</c:otherwise>
	        </c:choose>
	        <li class="nav-item active">
	            <a class="nav-link" href="${pageContext.request.contextPath}/home"><i class="fas fa-home"></i> Home <span class="sr-only">(current)</span></a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link" href="#"><i class="fas fa-info-circle"></i> About</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link" href="#"><i class="fas fa-phone"></i> Contact</a>
	        </li>
	        <li>
	            <a class="nav-link" href="${pageContext.request.contextPath}/cart">
	                <i class="fa fa-shopping-cart"></i>
	                <span class="badge badge-primary" id="totalQuantity">${sessionScope.totalQuantity}</span>
	            </a>
	        </li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	        <li>
	            <form class="form-inline my-2 my-lg-0" method="post" role="search" action="${pageContext.request.contextPath}/search-product">
	                <input id="product" name="keyword" class="form-control mr-sm-2" type="text" placeholder="Search">
	                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit"><i class="fas fa-search"></i></button>
	            </form>
	        </li>
	    </ul>
	</div>
</nav>