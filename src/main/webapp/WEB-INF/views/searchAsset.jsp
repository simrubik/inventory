<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="inventory" tagdir="/WEB-INF/tags"%>

<html>

<head>

<jsp:include page="layout/header.jsp" />
<title>Search Asset Page</title>

</head>

<body>

	<inventory:bodyHeader menuName="assetMenu" />
	
	<div class="container">
		
		<div class="row">
			<div class="col-xs-8">
				<form:form action="assets" method="POST">
					<div class="col-xs-8 input-group">
						<input type="text" class="form-control" placeholder="Search..."
							name="searchTerm" /> <span class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<span class="glyphicon glyphicon-search"></span> GO
							</button>
						</span>
					</div>
				</form:form>
			</div>
			<div class="col-xs-4">
				<a class="btn icon-btn btn-success pull-right"
					href="<c:url value="assets/new" />"> <span
					class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>
					Add
				</a>
			</div>


		</div>

		<hr />
		
		<table id="assetSearch" class="table table-bordered table-striped" style="width: 100%">
			<thead>
				<tr>
					<th><spring:message code="form.asset.assetName" /></th>
					<th><spring:message code="form.asset.assetSerie" /></th>
					<th>Available</th>
					<th>Active</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${assets}" var="asset">
					<tr>
						<td>${asset.name}</td>
						<td>${asset.serie}</td>
						<td><input class="text-center edit-flag" type="checkbox" ${asset.available == 'true' ? 'checked' : ''} disabled/></td>
						<td><input class="text-center edit-flag" type="checkbox" ${asset.active == 'true' ? 'checked' : ''} disabled/></td>
						<td>
							<div class="row container-action">
								<c:set var="disabled" value="${!asset.active}" />
								<a class="btn icon-btn btn-info ${disabled ? 'disabled' : ''}"
									href="<c:url value="assets/editAsset/${asset.id}" />"> 
									<span class="glyphicon btn-glyphicon glyphicon-pencil img-circle text-info"></span>Edit 
								</a>
								<a class="btn icon-btn btn-danger ${disabled ? 'disabled' : ''}"
									href="<c:url value="assets/delete/${asset.id}" />">
									<span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>Delete 
								</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>

</html>