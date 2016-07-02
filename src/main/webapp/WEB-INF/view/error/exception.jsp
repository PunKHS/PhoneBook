<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<spring:message code="exception.pageHeader" var="exceptionPageHeader"/>
<spring:message code="exception.pageSmallHeader" var="exceptionPageSmallHeader"/>
<spring:message code="exception.home" var="exceptionHome"/>

<page:template>
    <jsp:body>
        <!-- Page Content -->
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${exceptionPageHeader}
                        <small>${exceptionPageSmallHeader}</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.html">${exceptionHome}</a>
                        </li>
                        <li class="active">Exception Handler</li>
                    </ol>
                </div>
            </div>
            <!-- /.row -->

            <!-- Content Row -->
            <div class="row">

                <div class="col-lg-12">
                    <p>При выполнении операции произошла ошибка:</p>
                    <b>${exceptionMsg}</b>
                </div>

            </div>
            <!-- /.row -->

            <hr>

        </div>
        <!-- /.container -->
    </jsp:body>
</page:template>