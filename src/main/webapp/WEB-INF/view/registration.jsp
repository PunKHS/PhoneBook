<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="registration.createYourAccount" var="CreateYourAccount"/>
<spring:message code="registration.submit" var="Submit"/>
<spring:message code="registration.username" var="Username"/>
<spring:message code="registration.password" var="Password"/>
<spring:message code="registration.confirmYourPassword" var="ConfirmYourPassword"/>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<page:templateWithoutSearch>
    <jsp:attribute name="title">Registration</jsp:attribute>
    <jsp:body>

        <div class="container">

            <form:form method="POST" modelAttribute="userForm" class="form-signin">
                <h2 class="form-signin-heading">${CreateYourAccount}</h2>
                <spring:bind path="username">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="username" class="form-control" placeholder="${Username}"
                                    autofocus="true"></form:input>
                        <form:errors path="username"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="password" class="form-control"
                                    placeholder="${Password}"></form:input>
                        <form:errors path="password"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="confirmPassword">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="confirmPassword" class="form-control"
                                    placeholder="${ConfirmYourPassword}"></form:input>
                        <form:errors path="confirmPassword"></form:errors>
                    </div>
                </spring:bind>

                <button class="btn btn-lg btn-primary btn-block" type="submit">${Submit}</button>
            </form:form>

        </div>

    </jsp:body>
</page:templateWithoutSearch>