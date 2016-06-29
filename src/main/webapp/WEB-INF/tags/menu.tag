<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="name" required="true" rtexprvalue="true"
              description="Name of the active menu: employee, asset, inventory" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<c:url value="/resources/css/createdCss/appStyle.css" />" >

<%-- Static navbar --%>
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
            	<li><span><a class="language" href="?language=en">EN</a> | <a class="language" href="?language=ro">RO</a></span></li> 
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${name eq 'employeeMenu'}">
                        <c:set var="cssMenu" value="active"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="cssMenu" value=""/>
                    </c:otherwise>
                </c:choose>
                <li class="${cssMenu}"><a href="<c:url value="/employees" />" ><span><spring:message code="menu.employeeMenu" /></span></a></li>
                <c:choose>
                    <c:when test="${name eq 'assetMenu'}">
                        <c:set var="cssMenu" value="active"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="cssMenu" value=""/>
                    </c:otherwise>
                </c:choose>
                <li class="${cssMenu}"><a href="<c:url value="/assets" />" ><span><spring:message code="menu.assetMenu"/></span></a></li>
                <c:choose>
                    <c:when test="${name eq 'inventoryMenu'}">
                        <c:set var="cssMenu" value="active"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="cssMenu" value=""/>
                    </c:otherwise>
                </c:choose>
                <li class="${cssMenu}"><a href="<c:url value="/inventory" />" ><span><spring:message code="menu.inventoryMenu"/></span></a></li>
            </ul>
            
            
          
        </div> <%--/.nav-collapse --%>        
    </div> <%--/.container-fluid --%>    
</nav>
