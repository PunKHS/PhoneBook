<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="login.authorization" var="Authorization"/>
<spring:message code="login.login" var="LogIn"/>
<spring:message code="login.createAnAccount" var="CreateAnAccount"/>
<spring:message code="login.username" var="Username"/>
<spring:message code="login.password" var="Password"/>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<page:templateWithoutSearch>
    <jsp:attribute name="title">Login</jsp:attribute>
    <jsp:body>

        <div class="container">

            <form method="POST" action="${contextPath}/login" class="form-signin">
                <h2 class="form-heading">${Authorization}</h2>

                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <span>${message}</span>
                    <input name="username" type="text" class="form-control" placeholder="${Username}"
                           autofocus="true"/>
                    <input name="password" type="password" class="form-control" placeholder="${Password}"/>
                    <span>${error}</span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <button class="btn btn-lg btn-primary btn-block" type="submit">${LogIn}</button>
                    <h4 class="text-center"><a href="${contextPath}/registration">${CreateAnAccount}</a></h4>
                </div>

            </form>

        </div>

    </jsp:body>
</page:templateWithoutSearch>