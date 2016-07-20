<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="inventory" tagdir="/WEB-INF/tags" %>

<html>
<jsp:include page="layout/header.jsp"/>

<!-- <script type="text/javascript" src="resources/js/createdScripts/assetFile.js"></script> -->
	
<body>
<!-- 	<nav class="navbar navbar-default"> -->
<!-- 		<div class="container-fluid"> -->
<!-- 			<div class="collapse navbar-collapse" -->
<!-- 				id="bs-example-navbar-collapse-1"> -->
<!-- 				<ul class="nav navbar-nav"> -->
<!-- 					<li><a href="employees">Angajat</a></li> -->
<!-- 					<li class="active"><a href="#">Obiecte Inventar</a></li> -->
<!-- 					<li><a href="inventory">Fisa Evidenta</a></li> -->
<!-- 				</ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</nav> -->

	<inventory:bodyHeader menuName="assetMenu"/>
	
	<div class="row">
		<div class="col-lg-8 col-lg-offset-4">
			<label><h2><spring:message code="form.addAsset.title"/></h2></label>
		</div>
	</div>

	<form:form id="assetForm" action="assets" method="POST" commandName="asset"
		class="form-horizontal" role="form">
		<div class="form-group">
			<label class="control-label col-sm-2"><spring:message code="form.asset.assetName"/>:</label>
			<div class="col-xs-4">
				<form:input path="name" class="form-control" />
			</div>
			<div class="col-xs-3 messageContainer"></div>
			<form:errors class="col-xs-3" path="name" cssClass="error"></form:errors>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2"><spring:message code="form.asset.assetSerie"/>:</label>
			<div class="col-xs-4">
				<form:input path="serie" class="form-control" />
			</div>
			<div class="col-xs-3 messageContainer"></div>
			<form:errors class="col-xs-3" path="serie" cssClass="error"></form:errors>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-xs-4">
				<button type="submit" class="btn btn-default pull-right"><spring:message code="form.btn.submit"/></button>
			</div>
		</div>
	</form:form>
</body>
</html>