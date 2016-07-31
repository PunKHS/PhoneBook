<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<spring:message code="employee.add" var="employeeAdd"/>
<spring:message code="employee.fio" var="employeeFio"/>
<spring:message code="employee.structure" var="employeeStructure"/>
<spring:message code="employee.profession" var="employeeProfession"/>
<spring:message code="employee.email" var="employeeEmail"/>
<spring:message code="employee.phone" var="employeePhone"/>


<%--<c:url value="/employee" var="employee"/>--%>

<!-- Проверка редактирование/обновление -->
<%--<spring:eval expression="employee.id==null?labelEmployeeNew:labelEmployeeUpdate" var="formTitle"/>--%>

<page:templateWithSearch>

    <jsp:attribute name="title">Edit</jsp:attribute>

    <jsp:body>

        <!-- Page Content -->
        <div class="container">
            <div class="row">

                <!-- Page body -->
                <div>

                    <p class="lead">${employeeAdd}</p>

                    <c:url var="addAction" value="/employee/add"/>
                    <form:form action="${addAction}" commandName="employee">
                    <table>
                        <tr>
                            <td>
                                <form:label path="employeeFio">
                                    <spring:message text="Fio"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="employeeFio"/>
                            </td>
                        </tr>
                    </table>
                    </form:form>

                    <%--<table class="table table-hover">--%>

                        <%--<tr>--%>
                            <%--<td class="text-left" width="120">${employeeFio}</td>--%>
                            <%--<td class="text-left"><input type="text" class="form-control"></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td class="text-left" width="120">${employeeStructure}</td>--%>
                            <%--<td class="text-left"><input type="text" class="form-control"></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td class="text-left" width="120">${employeeProfession}</td>--%>
                            <%--<td class="text-left"><input type="text" class="form-control"></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td class="text-left" width="120">${employeeEmail}</td>--%>
                            <%--<td class="text-left"><input type="text" class="form-control"></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td class="text-left" width="120">${employeePhone}</td>--%>
                            <%--<td class="text-left"><input type="text" class="form-control"></td>--%>
                        <%--</tr>--%>
                    <%--</table>--%>

                    <%--<div class="btn-group btn-group-justified">--%>
                        <%--<div class="btn-group">--%>
                            <%--<button type="button" class="btn btn-success">Изменить</button>--%>
                        <%--</div>--%>
                        <%--<div class="btn-group">--%>
                            <%--<button type="button" class="btn btn-danger">Удалить</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                </div>
                <!-- /.Page body -->

            </div>
        </div>
        <!-- /.container -->

    </jsp:body>

</page:templateWithSearch>