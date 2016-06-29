<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="inventory" tagdir="/WEB-INF/tags"%>

<html>

<jsp:include page="layout/header.jsp" />

<script type="text/javascript" src="<c:url value="/resources/js/createdScripts/showEmployeeFile.js" />" ></script>

<body>

	<inventory:bodyHeader menuName="inventoryMenu" />

	<div class="row">
		<div class="col-lg-10 col-lg-offset-2">
			<label><h2><spring:message code="form.showEmployee.title"/></h2></label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-xs-offset-1 control-label col-xs-1"><spring:message code="form.showEmployee.choseEmployee" />:</label>
		<div class="btn-group">
			<a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#"><spring:message code="form.showEmployee.dropdownDefault" /><span class="caret"></span></a>
			<ul class="dropdown-menu">
				<c:forEach items="${employees}" var="employee">
					<li><a href="inventory/${employee.id}">${employee.firstName} ${employee.secondName}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>

</html>