<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<spring:message code="leftMenu.header" var="leftMenuHeader"/>
<spring:message code="rightMenu.header" var="rightMenuHeader"/>
<spring:message code="rightMenu.fio" var="rightMenuFio"/>
<spring:message code="rightMenu.structure" var="rightMenuStructure"/>
<spring:message code="rightMenu.profession" var="rightMenuProfession"/>
<spring:message code="rightMenu.phone" var="rightMenuPhone"/>

<page:template>

    <jsp:attribute name="title">Index</jsp:attribute>

    <jsp:body>
        <c:url value="/" var="queryFindAllEmployee" />

        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <!-- Left menu -->
                <div class="col-md-3 text-center">
                    <p class="lead">${leftMenuHeader}</p>
                </div>
                <!-- /.Left menu -->

                <!-- Page body -->
                <div class="col-md-9 text-center">
                    <p class="lead">${rightMenuHeader}</p>
                    <table class="table table-hover collaborator-table" style="width:100%">
                        <thead>
                        <tr>
                            <th data-sort="fio">${rightMenuFio}</th>
                            <th data-sort="structure">${rightMenuStructure}</th>
                            <th data-sort="post">${rightMenuProfession}</th>
                            <th data-sort="phone" class="text-right">${rightMenuPhone}</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="spinner">
                            <td colspan="4">
                                <span class="icon-spinner3"></span>
                            </td>
                        </tr>
                        </tbody>
                    </table>


                    <a href="${queryFindAllEmployee}" class="list-group-item">Find All Users</a>
                    <c:if test="${not empty resultObject}">
                        Result:
                        <c:if test="${resultObject == 'true'}">
                            <font color="green"><b>${resultObject}</b></font>
                        </c:if>
                        <c:if test="${resultObject == 'false'}">
                            <font color="red"><b>${resultObject}</b></font>
                        </c:if>
                        <c:if test="${resultObject !='true' and resultObject != 'false'}">
                            <p>${resultObject}</p>
                        </c:if>
                    </c:if>


                </div>
                <!-- /.Page body -->

            </div>

        </div>
        <!-- /.container -->

    </jsp:body>

</page:template>