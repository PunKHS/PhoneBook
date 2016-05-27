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
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="${startertemplate}" rel="stylesheet" />

    <!-- Custom Fonts -->
    <spring:url value="/resources/css/font-awesome.min.css" var="fontawesome"/>
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
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">

        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html"><spring:message code="navMenu.home"/></a>
        </div>

        <%-- Search Box --%>
        <spring:message code="navMenu.searchText" var="searchText"/>
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="${searchText}"/>>
            </div>
            <%--<button type="submit" class="btn btn-default"><spring:message code="navMenu.searchButton"/></button>--%>
        </form>


        <%--<!-- Collect the nav links, forms, and other content for toggling -->--%>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="navMenu.option"/><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <%--<c:url value="/file.html" var="file"/>--%>
                        <%--<li>--%>
                            <%--<a href="${file}">Загрузка файла PDF и Excel</a>--%>
                        <%--</li>--%>
                        <%--<c:url value="/jdbc.html" var="jdbc"/>--%>
                        <%--<li>--%>
                            <%--<a href="${jdbc}">JDBC c JDBCTemplates</a>--%>
                        <%--</li>--%>
                    </ul>
                </li>

                <c:url value="/about.html" var="about"/>
                <li><a href="${about}"><spring:message code="navMenu.about"/></a>
                    <span class="glyphicon glyphicon-phone" aria-hidden="true"></span>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>


<jsp:doBody/>


<div class="container">
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