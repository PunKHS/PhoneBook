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
    <spring:url value="/resources/js/typeahead.jquery.min.js" var="typeaheadjs"/>
    <script src="${typeaheadjs}"></script>

    <script type="text/javascript">
//        $(document).ready(function () {
//            var substringMatcher = function (strs) {
//                return function findMatches(q, cb) {
//                    var matches, substringRegex;
//
//                    // an array that will be populated with substring matches
//                    matches = [];
//
//                    // regex used to determine if a string contains the substring `q`
//                    substrRegex = new RegExp(q, 'i');
//
//                    // iterate through the pool of strings and for any string that
//                    // contains the substring `q`, add it to the `matches` array
//                    $.each(strs, function (i, str) {
//                        if (substrRegex.test(str)) {
//                            matches.push(str);
//                        }
//                    });
//
//                    cb(matches);
//                };
//            };
//
//            var states = ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California',
//                'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii',
//                'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana',
//                'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota',
//                'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire',
//                'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota',
//                'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island',
//                'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont',
//                'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'
//            ];
//
//            $('#searchText .form-control').typeahead({
//                    hint: true,
//                    highlight: true,
//                    minLength: 1
//                },
//                {
//                    name: 'states',
//                    source: substringMatcher(states)
//                });
//        });
    </script>

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
            <a class="navbar-brand" href="/"><strong><spring:message code="navMenu.home"/></strong></a>
        </div>
        <div class="navbar-collapse collapse" id="navbar-collapsible">
            <spring:message code="navMenu.profil" var="navMenuProfil"/>
            <spring:message code="navMenu.favorites" var="navMenuFavorites"/>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span><strong> ${navMenuProfil}</strong></a>
                </li>
                <li><a href="#"><span class="glyphicon glyphicon-heart"></span><strong> ${navMenuFavorites}</strong></a>
                </li>
            </ul>
            <%-- Search Box --%>
            <spring:message code="navMenu.searchText" var="navMenuSearchText"/>
            <form class="navbar-form" method="get" action="/search">
                <div class="form-group" style="display:inline;">
                    <div id="searchText" class="input-group" style="display:table;">
                        <input name="searchText" class="form-control" placeholder="${navMenuSearchText}"
                               autocomplete="off" autofocus="autofocus" type="text">
                        <span class="input-group-addon" style="width:1%;">
                            <span class="glyphicon glyphicon-search">
                            </span>
                        </span>
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
                <p><spring:message code="page.footer"/></p>
            </div>
        </div>
    </footer>
</div>

</body>

</html>