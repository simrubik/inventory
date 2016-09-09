<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="inventory" tagdir="/WEB-INF/tags"%>

<html>

<jsp:include page="layout/header.jsp" />

<script type="text/javascript" src="<c:url value="/resources/js/createdScripts/employeeFile.js" />" ></script>

<body>
	<!-- 	<nav class="navbar navbar-default"> -->
	<!-- 		<div class="container-fluid"> -->
	<!-- 			<div class="collapse navbar-collapse" -->
	<!-- 				id="bs-example-navbar-collapse-1"> -->
	<!-- 				<ul class="nav navbar-nav"> -->
	<!-- 					<li class="active"><a href="#">Angajat<span class="sr-only">(current)</span></a></li> -->
	<!-- 					<li><a href="assets">Obiecte Inventar</a></li> -->
	<!-- 					<li><a href="inventory">Fisa Evidenta</a></li> -->
	<!-- 				</ul> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</nav> -->

	<inventory:bodyHeader menuName="employeeMenu" />

<%-- 	<c:set var="now" value="<%=new java.util.Date()%>" /> --%>

	<div class="row">
		<div class="col-lg-8 col-lg-offset-4">
			<label><h2><spring:message code="form.addEmployee.title" /></h2></label>
		</div>
	</div>

	<c:choose>
    	<c:when test="${action == 'add'}">
    		<c:set var="actionUrl" value="new"></c:set>
    	</c:when>
   		<c:otherwise>
        	<c:set var="actionUrl" value="${employeeId}"></c:set>
    	</c:otherwise>
	</c:choose>
	
	<form:form id="employeeForm" action="${actionUrl}" method="POST"
		commandName="employee" class="form-horizontal" role="form">
		<input type="hidden" name="id" value="${employeeId}" />
<%-- 		<input type="hidden" name="active" value="${active}" /> --%>
<%-- 		<form:hidden path="active"/> --%>
		
		<div class="form-group">
			<label class="control-label col-sm-2"><spring:message code="form.addEmployee.firstName" />:</label>
			<div class="col-xs-4">
				<form:input path="firstName" class="form-control" />
			</div>
			<div class="col-xs-3 messageContainer"></div>
			<form:errors class="col-xs-3" path="firstName" cssClass="error"></form:errors>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2"><spring:message code="form.addEmployee.secondName"/>:</label>
			<div class="col-xs-4">
				<form:input path="secondName" class="form-control" />
			</div>
			<div class="col-xs-3 messageContainer"></div>
			<form:errors class="col-xs-3" path="secondName" cssClass="error"></form:errors>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2"><spring:message code="form.addEmployee.type"/>:</label>
			<div class="col-xs-4">
				<form:input path="mark" class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2"><spring:message code="form.addEmployee.function"/>:</label>
			<div class="col-xs-4">
				<form:input id="test" path="function" class="form-control"/>
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2"><spring:message code="form.addEmployee.employmentDate"/>: </label>
			<div class="col-xs-4 ">
				<div class = "col-xs-12 input-group date datepicker">
<%-- 					<fmt:formatDate pattern="MM/dd/yyyy" var="theFormattedDate" value="${now}" /> --%>
					<form:input class="form-control readonly-data" path="employmentDate"  />
					<label class="input-group-addon btn"> <span
						class="glyphicon glyphicon-calendar" />
					</label>
				</div>
			</div>
			<div class="col-xs-3"></div>
			<form:errors class="col-xs-3" path="employmentDate" cssClass="error"></form:errors>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-xs-4 ">
				<button type="submit" class="btn btn-default pull-right"><spring:message code="form.btn.submit"/></button>
			</div>
		</div>
	</form:form>

</body>
</html>