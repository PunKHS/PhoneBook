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
<spring:message code="button.save" var="buttonSave"/>

<spring:message code="query.confirm" var="queryConfirm"/>
<spring:message code="query.delete" var="queryDelete"/>

<spring:message code="employee.view" var="employeeView"/>
<spring:message code="employee.edit" var="employeeEdit"/>

<spring:message code="employee.fio" var="employeeFio"/>
<spring:message code="employee.structure" var="employeeStructure"/>
<spring:message code="employee.profession" var="employeeProfession"/>
<spring:message code="employee.email" var="employeeEmail"/>
<spring:message code="employee.phone" var="employeePhone"/>

<spring:url value="/edit" var="edit"/>

<page:templateWithoutSearch>

    <jsp:attribute name="title">Edit</jsp:attribute>

    <jsp:body>

        <!-- Page Content -->
        <div class="container">
            <div class="row">
                <br>

                <!-- Page body -->
                <div class="col-xs-12 col-sm-12 col-md-12">

                    <p class="lead">${employeeView}</p>

                    <table class="table table-hover">
                            <%--Скрытый элемент, необходимый для передачи ID employee--%>
                        <tr hidden="true">
                            <td class="text-left" width="120"></td>
                            <td class="text-left">${employee.id}</td>
                        </tr>
                        <tr>
                            <td class="text-left" width="120">${employeeFio}</td>
                            <td class="text-left">${employee.person.name}</td>
                        </tr>
                        <tr>
                            <td class="text-left" width="120">${employeeStructure}</td>
                            <td class="text-left">${employee.department.name}</td>
                        </tr>
                        <tr>
                            <td class="text-left" width="120">${employeeProfession}</td>
                            <td class="text-left">${employee.profession.name}</td>
                        </tr>
                        <tr>
                            <td class="text-left" width="120">${employeeEmail}</td>
                            <td class="text-left"><a href="mailto:${employee.email}">${employee.email}</a></td>
                        </tr>
                        <tr>
                            <td class="text-left" width="120">${employeePhone}</td>
                            <td class="text-left">${employee.phone}</td>
                        </tr>
                    </table>

                    <div>
                        <a class="btn btn-success" href="${edit}/${employee.id}?form">${buttonEdit}</a>
                        <a class="btn btn-danger" data-toggle="modal" data-target="#myModal">${buttonDelete}</a>
                        <a class="btn btn-default" href="/">${buttonCancel}</a>
                    </div>

                    <!-- Modal Window -->
                    <form:form modelAttribute="employee" action="/disableEmployee/${employee.id}?form" method="post">
                        <%--<form:input path="id"/>--%>
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">${queryConfirm}</h4>
                                    </div>
                                    <div class="modal-body">
                                        <p>${queryDelete}</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">${buttonCancel}</button>
                                        <button type="submit" class="btn btn-primary">${buttonSave}</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form:form>
                    <!-- /.Modal Window -->

                </div>
                <!-- /.Page body -->

            </div>
        </div>
        <!-- /.container -->

    </jsp:body>

</page:templateWithoutSearch>