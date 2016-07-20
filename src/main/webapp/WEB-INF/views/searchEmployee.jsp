<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="inventory" tagdir="/WEB-INF/tags"%>

<html>

<jsp:include page="layout/header.jsp" />
<script type="text/javascript"
	src="<c:url value="/resources/js/createdScripts/employeeFile.js" />"></script>

<body>

	<inventory:bodyHeader menuName="employeeMenu" />

	<div class="container">

		<div class="row">
			<div class="col-xs-8">
				<form:form action="employees" method="POST">
					<div class="col-xs-8 input-group">
						<input type="text" class="form-control" placeholder="Search..."
							name="employeeName" /> <span class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<span class="glyphicon glyphicon-search"></span> GO
							</button>
						</span>
					</div>
				</form:form>
			</div>
			<div class="col-xs-4">
				<a class="btn icon-btn btn-success pull-right"
					href="<c:url value="employees/new" />"> <span
					class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>
					Add
				</a>
			</div>


		</div>

		<hr />

		<div>
			<table id="employeeSearch" class="table table-bordered table-striped"
				style="width: 100%">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Second Name</th>
						<th>Type</th>
						<th>Function</th>
						<th>EmploymentDate</th>
						<th>Active</th>
						<th>Action</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${employees}" var="employee" varStatus="vs">
						<tr class="employee-row">
							<td>${employee.firstName}</td>
							<td>${employee.secondName}</td>
							<td>${employee.mark}</td>
							<td>${employee.function}</td>
							<td>${employee.employmentDate}</td>
							<td><input class="text-center edit-flag" type="checkbox"
								${employee.active == 'true' ? '' : 'checked'} disabled /></td>
							<td>
								<div class="row container-action">
									<c:set var="disabled" value="${!employee.active}" />
									<a id="row${vs.index}disableEditBtn"
										class="btn icon-btn btn-info ${disabled ? 'disabled' : ''}"
										href="<c:url value="employees/${employee.id}" />"> <span
										class="glyphicon btn-glyphicon glyphicon-pencil img-circle text-info"></span>Edit
									</a> 
									<a class="btn icon-btn btn-danger ${disabled ? 'disabled' : ''}"
										href="<c:url value="employees/delete/${employee.id}" />">
										<span
										class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>Delete
									</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>