<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="inventory" tagdir="/WEB-INF/tags"%>

<html>
<jsp:include page="layout/header.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/createdScripts/inventoryFile.js" />" ></script>

<body>
	<!-- 	<nav class="navbar navbar-default"> -->
	<!-- 		<div class="container-fluid"> -->
	<!-- 			<div class="collapse navbar-collapse" -->
	<!-- 				id="bs-example-navbar-collapse-1"> -->
	<!-- 				<ul class="nav navbar-nav"> -->
	<!-- 					<li><a href="employees">Angajat</a></li> -->
	<!-- 					<li><a href="assets">Obiecte Inventar</a></li> -->
	<!-- 					<li class="active"><a href="inventory">Fisa Evidenta</a></li> -->
	<!-- 				</ul> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</nav> -->

	<inventory:bodyHeader menuName="inventoryMenu" />

	<div class="row">
		<div class="col-lg-10 col-lg-offset-2">
			<label><h2><spring:message code="form.inventoryFile.title"/></h2></label>
		</div>
	</div>

	<%-- 	<form:form class="form-horizontal" role="form" method="POST"  action="inventory" commandName="empl"> --%>
	<!-- 		<div class="form-group"> -->
	<!-- 			<label class="control-label col-sm-2">Alege Angajatul:</label> -->
	<!-- 			<div class="col-xs-2"> -->
	<%-- 				<form:select class="js-example-basic-single form-control" path="id"> --%>
	<%-- 					<c:forEach items="${employees}" var="employee"> --%>
	<%-- 						<form:option value="${employee.id}" >${employee.firstName} --%>
	<%-- 							${employee.secondName}</form:option> --%>
	<%-- 					</c:forEach> --%>
	<%-- 					</form:select> --%>
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 		<div class="form-group"> -->
	<!-- 			<div class="col-sm-offset-2 col-xs-2"> -->
	<!-- 				<button type="submit" class="btn btn-default pull-right">Submit</button> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<%-- 	</form:form> --%>

	<form:form class="form-horizontal" role="form" method="POST"
		action="../inventory" commandName="inventoryList">
<!-- 		<div class="form-group"> -->
<!-- 			<label class="control-label col-sm-2">Alege Angajatul:</label> -->
<!-- 			<div class="col-sm-2"> -->
<!-- 				<select class="js-example-basic-single form-control" name="emplId"> -->
<!-- 					<option value="" >--Choose employee--</option> -->
<%-- 					<c:forEach items="${employees}" var="employee"> --%>
<%-- 						<option value="${employee.id}">${employee.firstName} --%>
<%-- 							${employee.secondName}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<input type="hidden" name="employeeId" value="${employeeId}" />
		<c:set var="disabled" value="${!employee.active}" />
		
		<div class="form-group">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<table id="inventory" class="table table-bordered table-hover">
					<tr>
						<th rowspan="2" style="width: 10%"><spring:message code="form.inventoryFile.table.assetName"/></th>
						<th rowspan="2" style="width: 10%"><spring:message code="form.inventoryFile.table.assetSerie"/></th>
						<th rowspan="2" style="width: 5%"><spring:message code="form.inventoryFile.table.useTerm"/></th>
						<th rowspan="2" style="width: 5%"><spring:message code="form.inventoryFile.table.pu"/></th>
						<th rowspan="2" style="width: 5%"><spring:message code="form.inventoryFile.table.um"/></th>
						<th colspan="4" style="width: 15%"><spring:message code="form.inventoryFile.table.reception"/></th>
						<th colspan="4" style="width: 15%"><spring:message code="form.inventoryFile.table.returning"/></th>
						<th rowspan="2" style="width: 5%"><spring:message code="form.inventoryFile.table.action" /></th>
					</tr>
					<tr>
						<th class="text-center" style="width: 10%"><spring:message code="form.inventoryFile.table.receptionDate"/></th>
						<th class="text-center" style="width: 5%"><spring:message code="form.inventoryFile.table.receptionType"/></th>
						<th class="text-center" style="width: 5%"><spring:message code="form.inventoryFile.table.receptionNumber"/></th>
						<th class="text-center" style="width: 5%"><spring:message code="form.inventoryFile.table.receptionQuantity"/></th>
						<th class="text-center" style="width: 10%"><spring:message code="form.inventoryFile.table.returningDate"/></th>
						<th class="text-center" style="width: 5%"><spring:message code="form.inventoryFile.table.returningType"/></th>
						<th class="text-center" style="width: 5%"><spring:message code="form.inventoryFile.table.returningNumber"/></th>
						<th class="text-center" style="width: 5%"><spring:message code="form.inventoryFile.table.returningQuantity"/></th>
					</tr>
					<c:forEach items="${inventoryList.inventoryList}" varStatus="vs">
						<tr class="asset-row">
							<form:hidden path="inventoryList[${vs.index}].employeeAssetId"/>
							<td>
								<form:select class="asset-name form-control" name="assetName" path="inventoryList[${vs.index}].assetName" disabled="true">
									<c:forEach items="${assets}" var="asset">
										<form:option value="${asset}">${asset} </form:option>
									</c:forEach>
								</form:select>
<%-- 								<select class="asset-name form-control" name="inventoryList[${vs.index}].assetName" > --%>
<%-- 									<c:forEach items="${assets}" var="asset"> --%>
<%-- 										<option value="${asset}" ${asset==inventoryList.inventoryList[vs.index].assetName ? "selected" : "" }>${asset} </option> --%>
<%-- 									</c:forEach> --%>
<!-- 								</select> -->
								<form:errors path="inventoryList[${vs.index}].assetName" cssClass="error"></form:errors>
							</td>
							<td>
								<form:select class="asset-serie form-control" name="assetSerie" path="inventoryList[${vs.index}].assetSerie" disabled="true">
									<c:forEach items="${assetSerie}" var="assetSerie">
										<form:option value="${assetSerie.id}" >${assetSerie.serie}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="inventoryList[${vs.index}].assetSerie" cssClass="error"></form:errors>
							</td>
							<td>
								<form:input name="useTime" style="width: 100%;" path="inventoryList[${vs.index}].useTime" />
								<form:errors path="inventoryList[${vs.index}].useTime" cssClass="error"></form:errors>
							</td>
							<td><form:input name="pu" style="width: 100%;" path="inventoryList[${vs.index}].pu" /></td>
							<td><form:input name="um" style="width: 100%;" path="inventoryList[${vs.index}].um" /></td>
							<td>
								<div class="input-group date datepicker">
									<form:input type="text" class="form-control" name="receptionDate" path="inventoryList[${vs.index}].receptionDate" />
									<label class="input-group-addon btn"> <span class="glyphicon glyphicon-calendar"></span></label>
								</div>
							</td>
							<td><form:input name="receptionType" style="width: 100%;"
									path="inventoryList[${vs.index}].receptionType" /></td>
							<td><form:input name="receptionNumber" style="width: 100%;"
									path="inventoryList[${vs.index}].receptionNumber" /></td>
							<td>
								<form:input name="receptionQuantity" style="width: 100%;" path="inventoryList[${vs.index}].receptionQuantity" />
								<form:errors path="inventoryList[${vs.index}].receptionQuantity" csscssClass="error" ></form:errors>
							</td>
							<td>
								<div class="input-group date datepicker">
									<form:input type="text" class="form-control"
										name="returningDate"
										path="inventoryList[${vs.index}].returningDate" />
									<label class="input-group-addon btn"> <span
										class="glyphicon glyphicon-calendar"></span>
									</label>
								</div>
							</td>
							<td>
								<form:input name="returningType" style="width: 100%;" path="inventoryList[${vs.index}].returningType" />
							</td>
							<td>
								<form:input name="returningnNumber" style="width: 100%;" path="inventoryList[${vs.index}].returningnNumber" />
							</td>
							<td>
								<form:input name="returningQuantity" style="width: 100%;" path="inventoryList[${vs.index}].returningQuantity" />
							</td>
							<td>
								<a class="btn icon-btn btn-warning remove-row-btn ${disabled ? 'disabled' : ''}">
									<span class="glyphicon btn-glyphicon glyphicon-minus img-circle text-warning"></span>Remove
								</a>
							</td>
						</tr>
					</c:forEach>


					<tr class="asset-row hidden asset-row-template">
						<input type="hidden" name="employeeAssetId" class="employeeAsset_id" />
					
						<td><select class="asset-name form-control" name="assetName">
								<c:forEach items="${assets}" var="asset">
									<option value="${asset}">${asset}</option>
								</c:forEach>
						</select></td>
						<td><select class="asset-serie form-control"
							name="assetSerie">
								<c:forEach items="${assetSerie}" var="assetSerie">										
									<option value="${assetSerie.id}">${assetSerie.serie}</option>
								</c:forEach>
						</select></td>
						<td><input name="useTime" style="width: 100%;" class="use-time"/></td>
						<td><input name="pu" style="width: 100%;" class="pu"/></td>
						<td><input name="um" style="width: 100%;" class="um"/></td>
						<td>
							<div class="input-group date datepicker reception-date-click">
								<input type="text" class="form-control reception-date"
									name="receptionDate" />
								<label class="input-group-addon btn"> <span
									class="glyphicon glyphicon-calendar"></span>
								</label>
							</div>
						</td>
						<td><input name="receptionType" style="width: 100%;" class="reception-type" /></td>
						<td><input name="receptionNumber" style="width: 100%;" class="reception-number" /></td>
						<td><input name="receptionQuantity" style="width: 100%;" class="reception-quantity" /></td>
						<td>
							<div class="input-group date datepicker">
								<input type="text" class="form-control returning-date"
									name="returningDate"  />
								<label class="input-group-addon btn"> <span
									class="glyphicon glyphicon-calendar"></span>
								</label>
							</div>
						</td>
						<td><input name="returningType" style="width: 100%;" class="returning-type" /></td>
						<td><input name="returningnNumber" style="width: 100%;" class="returning-number" /></td>
						<td><input name="returningQuantity" style="width: 100%;" class="returning-quantity" /></td>
						<td>
							<a class="btn icon-btn btn-warning remove-row-btn">
								<span class="glyphicon btn-glyphicon glyphicon-minus img-circle text-warning"></span>Remove
							</a>
						</td>
					</tr>
				</table>
			</div>
			<div class="col-sm-1"></div>
		</div>

		<div class="form-group">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<input class="btn btn-default plusbtn ${disabled ? 'disabled' : ''}" type="button" ${disabled ? 'disabled' : ''} value="<spring:message code="form.btn.addRow"/>" />

				<button type="submit" class="btn btn-default pull-right ${disabled ? 'disabled' : ''}" ${disabled ? 'disabled' : ''}><spring:message code="form.btn.submit"/></button>
			</div>
			<div class="col-sm-1"></div>
		</div>
		
	</form:form>
</body>
</html>