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

    <script type="text/javascript">
        // http://stackoverflow.com/questions/22730407/typeahead-and-bloodhound-how-to-get-json-result
        $(document).ready(function () {
            var persons = new Bloodhound({
                datumTokenizer: Bloodhound.tokenizers.obj.whitespace('name'),
                queryTokenizer: Bloodhound.tokenizers.whitespace,
                remote: {
                    url: '/search-person?searchText=%QUERY',
                    wildcard: '%QUERY'
                }
            });

            persons.initialize();

            $('#searchText .form-control')
                .typeahead(
                    {
                        hint: true,
                        highlight: true,
                        minLength: 2
                    },
                    {
                        name: 'name',
                        limit: 10,
                        displayKey: function (response) {
                            return response.name;
                        },
                        source: persons.ttAdapter()
                    }
                )
                .bind("typeahead:selected", function () {
                    $("form").submit();
                });
        });
    </script>

</head>

<body>

<spring:message code="navMenu.home" var="NavHome"/>
<spring:message code="navMenu.profil" var="NavMenuProfil"/>
<spring:message code="navMenu.settings" var="NavMenuSettings"/>
<spring:message code="navMenu.searchText" var="NavMenuSearchText"/>
<spring:message code="navMenu.logout" var="Logout"/>
<spring:message code="page.footer" var="Footer"/>

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
            <a class="navbar-brand" href="/welcome">
                <div class="hidden-xs hidden-sm">
                    <strong>${NavHome}</strong>
                </div>
                <div class="hidden-md hidden-lg">
                    <span class="glyphicon glyphicon-earphone"></span>
                </div>
            </a>
        </div>
        <div class="navbar-collapse collapse" id="navbar-collapsible">
            <div class="hidden-xs hidden-sm">
                <ul class="nav navbar-nav navbar-right">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">

                        <li>
                            <a href="#">
                                <span class="glyphicon glyphicon-user"></span>
                                <strong> ${pageContext.request.userPrincipal.name}</strong>
                            </a>
                        </li>

                        <li>
                            <a onclick="document.forms['logoutForm'].submit()">
                                <span class="glyphicon glyphicon-off"></span>
                                <strong> ${Logout}</strong>
                            </a>
                        </li>

                        <form id="logoutForm" method="post" action="${contextPath}/logout">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>

                    </c:if>
                </ul>
            </div>
            <%-- Search Box --%>
            <form class="navbar-form" method="get" action="/search">
                <div class="form-group" style="display:inline;">
                    <div id="searchText" class="input-group" style="display:table;">
                        <input name="searchText" class="form-control" placeholder="${NavMenuSearchText}"
                               autocomplete="off" autofocus="autofocus" type="text">
                        <%--<span class="input-group-addon" style="width:1%;">--%>
                        <%--<span class="glyphicon glyphicon-search">--%>
                        <%--</span>--%>
                        <%--</span>--%>

                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit">
                                <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>

                        <%--<span class="input-group-btn">--%>
                        <%--<button class="btn btn-default" type="button">Go!</button>--%>
                        <%--</span>--%>
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
                <p>${Footer}</p>
            </div>
        </div>
    </footer>
</div>

</body>

</html>