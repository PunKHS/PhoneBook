<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<spring:message code="errorpage.pageHeader" var="errorpagePageHeader"/>
<spring:message code="errorpage.pageSmallHeader" var="errorpagePageSmallHeader"/>
<spring:message code="errorpage.home" var="errorpageHome"/>

<page:template>
    <jsp:body>
        <!-- Page Content -->
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${errorpagePageHeader}
                        <small>${errorpagePageSmallHeader}</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.html">${errorpageHome}</a>
                        </li>
                        <li class="active">Eroor 404</li>
                    </ol>
                </div>
            </div>
            <!-- /.row -->

            <!-- Content Row -->
            <%--<div class="row">--%>

                <%--<div class="col-lg-12">--%>
                    <%--<p>При выполнении операции произошла ошибка:</p>--%>
                    <%--<b>${exceptionMsg}</b>--%>
                <%--</div>--%>

            <%--</div>--%>
            <!-- /.row -->

        </div>
        <!-- /.container -->
    </jsp:body>
</page:template>