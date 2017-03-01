<!DOCTYPE html>
<%@tag description="Template Site tag" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@attribute name="title" fragment="true" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%-- Use title from .jsp --%>
    <%--<title><jsp:invoke fragment="title"/></title>--%>
    <title><spring:message code="page.title"/></title>

    <!-- Bootstrap Core CSS -->
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <link href="${bootstrap}" rel="stylesheet"/>

    <!-- Custom CSS -->
    <spring:url value="/resources/css/style.css" var="startertemplate"/>
    <link href="${startertemplate}" rel="stylesheet"/>

    <!-- Typeahead CSS -->
    <spring:url value="/resources/css/typeaheadjs.css" var="typeaheadcss"/>
    <link href="${typeaheadcss}" rel="stylesheet"/>

    <!-- Common CSS -->
    <spring:url value="/resources/css/common.css" var="common"/>
    <link href="${common}" rel="stylesheet"/>

    <!-- Custom Fonts -->
    <spring:url value="/resources/font-awesome/css/font-awesome.min.css" var="fontawesome"/>
    <link href="${fontawesome}" rel="stylesheet"/>

    <!-- jQuery -->
    <spring:url value="/resources/js/jquery.js" var="jqueryjs"/>
    <script src="${jqueryjs}"></script>

    <!-- Bootstrap Core JavaScript -->
    <spring:url value="/resources/js/bootstrap.min.js" var="js"/>
    <script src="${js}"></script>

    <!-- Typeahead -->
    <%--<spring:url value="/resources/js/typeahead.jquery.min.js" var="typeaheadjs"/>--%>
    <spring:url value="/resources/js/typeahead.bundle.min.js" var="typeaheadjs"/>
    <script src="${typeaheadjs}"></script>

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/welcome"><strong><spring:message code="navMenu.home"/></strong></a>
        </div>
    </div>
</nav>

<jsp:doBody/>

<div class="container">
    <hr>
    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p><spring:message code="page.footer"/></p>
            </div>
        </div>
    </footer>
</div>

</body>

</html>