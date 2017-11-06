<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c2" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>

    <%--FAVICON--%>
        <link href="/static/images/favicon.ico" rel="icon" type="image/x-icon" />
    <%--Jquery--%>
    <c:url value="/webjars/jquery/2.1.4/jquery.min.js" var="jquery" />
    <script src="${jquery}"></script>

    <%--Bootstrap--%>
    <c:url value="/webjars/bootstrap/3.3.4/js/bootstrap.min.js" var="bootstrapJS"/>
    <script src="${bootstrapJS}"></script>
    <%--BOOTSWATCH--%>
    <c:url value="/static/css/bootswatch_darkly.css" var="bootstrapCSS"/>
    <link href="${bootstrapCSS}" rel="stylesheet" media="screen" />
    <%--<c:url value="/webjars/bootstrap/3.3.4/css/bootstrap.min.css" var="bootstrapCSS"/>--%>
    <%--<link href="${bootstrapCSS}" rel="stylesheet" media="screen" />--%>


    <%--Custom JS--%>
    <c:url value="/static/js/common.js" var="common" />
    <script src="${common}"></script>

    <%--Custom CSS--%>
    <c:url value="/static/css/astrosite.css" var="bootstrapCUSTOM" />
    <link href="${bootstrapCUSTOM}" rel="stylesheet" media="screen"/>

    <title>Astronomy Resource Center</title>

</head>
<body>