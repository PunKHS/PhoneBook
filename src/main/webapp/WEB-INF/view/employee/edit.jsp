<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="button.ok" var="buttonOk"/>
<spring:message code="button.cancel" var="buttonCancel"/>
<spring:message code="button.add" var="buttonAdd"/>
<spring:message code="button.edit" var="buttonEdit"/>
<spring:message code="button.delete" var="buttonDelete"/>

<spring:message code="employee.view" var="employeeView"/>
<spring:message code="employee.edit" var="employeeEdit"/>

<spring:message code="employee.fio" var="employeeFio"/>
<spring:message code="employee.structure" var="employeeStructure"/>
<spring:message code="employee.profession" var="employeeProfession"/>
<spring:message code="employee.email" var="employeeEmail"/>
<spring:message code="employee.phone" var="employeePhone"/>
<spring:message code="employee.mobilePhone" var="employeeMobilePhone"/>

<page:templateWithoutSearch>

    <jsp:attribute name="title">Edit</jsp:attribute>

    <jsp:body>

        <!-- Page Content -->
        <div class="container">
            <div class="row">

                <!-- Page body -->
                <div class="col-xs-12 col-sm-12 col-md-12">

                    <p class="lead">${employeeEdit}</p>

                    <form:form modelAttribute="employee" action="/update" method="post">

                        <table class="table table-hover">
                            <tr hidden="true">
                                <td class="text-left" width="120"></td>
                                <td class="text-left"><form:input path="id"/></td>
                            </tr>
                            <tr>
                                <td class="text-left" width="120">${employeeFio}</td>
                                <td class="text-left">${employee.person.name}</td>
                                <td hidden="true">
                                    <form:select path="person.id">
                                        <form:options items="${person}" itemValue="id" itemLabel="name"/>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-left" width="120">${employeeStructure}</td>
                                <td>
                                    <form:select path="department.id">
                                        <form:options items="${department}" itemValue="id" itemLabel="name"/>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-left" width="120">${employeeProfession}</td>
                                <td>
                                    <form:select path="profession.id">
                                        <form:options items="${profession}" itemValue="id" itemLabel="name"/>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-left" width="120">${employeeEmail}</td>
                                <td class="text-left"><form:input path="email"/></td>
                            </tr>
                            <tr>
                                <td class="text-left" width="120">${employeePhone}</td>
                                <td class="text-left"><form:input path="phone"/></td>
                            </tr>
                            <tr>
                                <td class="text-left" width="120">${employeeMobilePhone}</td>
                                <td class="text-left"><form:input path="mobilePhone"/></td>
                            </tr>
                        </table>

                        <div>
                            <button class="btn btn-success" type="submit">${buttonOk}</button>
                            <a class="btn btn-default">${buttonCancel}</a>
                        </div>

                    </form:form>
                </div>

                <!-- /.Page body -->

            </div>
        </div>
        <!-- /.container -->

    </jsp:body>

</page:templateWithoutSearch>