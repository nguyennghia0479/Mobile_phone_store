<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

	<c:url value="" var="previousPage">
		<c:param name="page" value="${pagedListHolder.page - 1}"/>
	</c:url>

	<c:url value="" var="nextPage">
		<c:param name="page" value="${pagedListHolder.page + 1}"/>
	</c:url>

	<c:url value="" var="firstPage">
		<c:param name="page" value="0"/>
	</c:url>

	<c:url value="" var="lastPage">
		<c:param name="page" value="${pagedListHolder.pageCount}"/>
	</c:url>
						
	<c:if test="${pagedListHolder.pageCount > 1}">
		<div class="text-center">
			<nav aria-label="Page navigation example">
				 <ul class="pagination justify-content-center">
				 	<c:if test="${!pagedListHolder.firstPage}">
				 		<li class="page-item">
				 			<a class="page-link" href="${previousPage}" aria-lable="Previous">
				 				<span aria-hidden="true">&laquo;</span>
				 				<span class="sr-only">Previous</span>
				 			</a>
				 		</li>
				 	</c:if>
				 	<c:if test="${pagedListHolder.firstLinkedPage > 0}">
						<li class="page-item">
							<a class="page-link" href="${firstPage}">1</a>
						</li>
					</c:if>
					<c:if test="${pagedListHolder.firstLinkedPage > 1}">
						<li class="page-item"><span class="page-link">...</span><li>
					</c:if>
					<c:forEach begin="${pagedListHolder.firstLinkedPage}" end="${pagedListHolder.lastLinkedPage}" var="page">
						<c:url value="${pageURL}" var="pageLink">
							<c:param name="page" value="${page}"></c:param>
						</c:url>
						<c:choose>
							<c:when test="${pagedListHolder.page == page}">
								<li class="page-item active"><span class="page-link">${page+1}</span></li>
							</c:when>
							<c:otherwise>
								 <li class="page-item">
								 	<a class="page-link" href="${pageLink}">${page+1}</a>
								 </li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${pagedListHolder.lastLinkedPage < pagedListHolder.pageCount - 2}">
						<li class="page-item"><span class="page-link">...</span><li>
					</c:if>
					<c:if test="${pagedListHolder.lastLinkedPage < pagedListHolder.pageCount - 1}">
						<li class="page-item">
							<a class="page-link" href="${lastPage}">${pagedListHolder.pageCount}</a>
						</li>
					</c:if>
					<c:if test="${!pagedListHolder.lastPage}">
						<li class="page-item">
		             		<a class="page-link" href="${nextPage}" aria-label="Next">
		                        <span aria-hidden="true">&raquo;</span>
		                        <span class="sr-only">Next</span>
		                    </a>
		                </li>
					</c:if>
				 </ul>
			</nav>
		</div>
	</c:if>