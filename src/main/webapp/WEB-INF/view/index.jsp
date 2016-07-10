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
<%--<spring:message code="rightMenu.email" var="rightMenuEmail"/>--%>
<spring:message code="rightMenu.phone" var="rightMenuPhone"/>
<%--<c:url value="/index" var="findAllEmployee"/>--%>

<page:template>

    <jsp:attribute name="title">Index</jsp:attribute>

    <jsp:body>

        <!-- Page Content -->
        <div class="container">
            <div class="row">

                <!-- Left menu -->
                <div class="hidden-xs hidden-sm col-md-3 text-center">
                    <p class="lead">${leftMenuHeader}</p>
                </div>
                <!-- /.Left menu -->

                <!-- Page body -->
                <div class="col-xs-12 col-sm-12 col-md-9 text-center">
                    <p class="lead">${rightMenuHeader}</p>
                    <%--<a href="${findAllEmployee}" class="list-group-item">Find All Employee</a>--%>
                    <table class="table table-hover collaborator-table" style="width:100%">
                        <thead>
                        <tr>
                            <th data-sort="fio">${rightMenuFio}</th>
                            <th data-sort="structure">${rightMenuStructure}</th>
                            <th data-sort="profession">${rightMenuProfession}</th>
                                <%--<th data-sort="email">${rightMenuEmail}</th>--%>
                            <th data-sort="phone" class="text-right">${rightMenuPhone}</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${resultObject}" var="result">
                            <tr>
                                <td class="text-left"><c:out value="${result.person.name}"/></td>
                                <td class="text-left"><c:out value="${result.department.name}"/></td>
                                <td class="text-left"><c:out value="${result.profession.name}"/></td>
                                    <%--<td class="text-left"><c:out value="${result.email}"/></td>--%>
                                    <%--<th class="text-left"><a href="mailto:${result.email}">${result.email}</a></th>--%>
                                <td class="text-left"><c:out value="${result.phone}"/></td>
                                <td><c:out value=""/></td>
                            </tr>
                        </c:forEach>

                        <tr class="spinner">
                            <td colspan="4">
                                <span class="icon-spinner3"></span>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- /.Page body -->

            </div>
        </div>
        <!-- /.container -->

    </jsp:body>

</page:template>