<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="editEmployee.header" var="editEmployeeHeader"/>
<spring:message code="editEmployee.surname" var="editEmployeeSurname"/>
<spring:message code="editEmployee.name" var="editEmployeeName"/>
<spring:message code="editEmployee.middleName" var="editEmployeeMiddleName"/>

<spring:message code="labelEmployee.new" var="labelOrdersNew"/>
<spring:message code="labelEmployee.update" var="labelOrdersUpdate"/>

<c:url value="/employee" var="employee"/>

<!-- Проверка редактирование/обновление -->
<%--<spring:eval expression="employee.id==null?labelEmployeeNew:labelEmployeeUpdate" var="formTitle"/>--%>

<page:template>

    <jsp:attribute name="title">Edit</jsp:attribute>

    <jsp:body>

        <%--<h1>${formTitle}</h1>--%>

        <!-- Page Content -->
        <div class="container">
            <div class="row">

                <!-- Page body -->
                <div>
                    <p class="lead">${editEmployeeHeader}</p>
                    <form:form modelAttribute="employee" id="employeeUpdateForm" method="POST">
                        <form:label path="employee.person">${editEmployeeSurname}</form:label>
                        <form:input path="employee.person"/>
                    </form:form>
                </div>
                <!-- /.Page body -->

            </div>
        </div>
        <!-- /.container -->

    </jsp:body>

</page:template>