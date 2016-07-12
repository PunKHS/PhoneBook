<!DOCTYPE html>
<%@tag description="Template Site tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@attribute name="title" fragment="true" %>
<html>
<head>
    <%-- Use title from .jsp --%>
    <%--<title><jsp:invoke fragment="title"/></title>--%>
    <title><spring:message code="page.title"/></title>

    <!-- Bootstrap Core CSS -->
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <link href="${bootstrap}" rel="stylesheet" />

    <!-- Custom CSS -->
    <spring:url value="/resources/css/style.css" var="startertemplate"/>
    <link href="${startertemplate}" rel="stylesheet" />

    <!-- Custom Fonts -->
    <spring:url value="/resources/font-awesome/css/font-awesome.min.css" var="fontawesome"/>
    <link href="${fontawesome}" rel="stylesheet" />

    <!-- jQuery -->
    <spring:url value="/resources/js/jquery.js" var="jqueryjs"/>
    <script src="${jqueryjs}"></script>

    <!-- Bootstrap Core JavaScript -->
    <spring:url value="/resources/js/bootstrap.min.js" var="js"/>
    <script src="${js}"></script>

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapsible">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><strong><spring:message code="navMenu.home"/></strong></a>
        </div>
        <div class="navbar-collapse collapse" id="navbar-collapsible">
            <spring:message code="navMenu.profil" var="navMenuProfil"/>
            <spring:message code="navMenu.favorites" var="navMenuFavorites"/>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span><strong> ${navMenuProfil}</strong></a></li>
                <li><a href="#"><span class="glyphicon glyphicon-heart"></span><strong> ${navMenuFavorites}</strong></a></li>
            </ul>
            <%-- Search Box --%>
            <spring:message code="navMenu.searchText" var="navMenuSearchText"/>
            <%--<form class="navbar-form">--%>
            <c:url value="/search/{searchText}" var="searchText"/>
            <%--<form class="navbar-form" action="${searchText}" method="post">--%>
            <form class="navbar-form" method="post">
                <div class="form-group" style="display:inline;">
                    <div class="input-group" style="display:table;">
                        <input class="form-control" name="searchText" placeholder="${navMenuSearchText}" autocomplete="off" autofocus="autofocus" type="text">
                        <span class="input-group-addon" style="width:1%;"><span class="glyphicon glyphicon-search"></span></span>
                    </div>
                </div>
            </form>
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
                <%--<a href="<%=request.getContextPath()%>?lang=en">EN</a>--%>
                <%--<a href="<%=request.getContextPath()%>?lang=ru">RU</a>--%>
                <p><spring:message code="page.footer"/></p>
            </div>
        </div>
    </footer>
</div>

</body>

</html>