<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Docente</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>

<body class="container mt-5">

    <h1>
        <c:choose>
            <c:when test="${docente.id != null}">Modifica Docente</c:when>
            <c:otherwise>Nuovo Docente</c:otherwise>
        </c:choose>
    </h1>

    <c:choose>
        <c:when test="${docente.id != null}">
        <c:set var="formAction" value="${pageContext.request.contextPath}/docenti/${docente.id}/edit" />
        </c:when>
        <c:otherwise>
            <c:set var="formAction" value="${pageContext.request.contextPath}/docenti" />
        </c:otherwise>
    </c:choose>

    <form:form method="POST" modelAttribute="docente" action="${formAction}">
        <div class="mb-3">
            <label for="nome" class="form-label">Nome:</label>
            <form:input path="nome" id="nome" class="form-control" required="true"/>
        </div>

        <div class="mb-3">
            <label for="cognome" class="form-label">Cognome:</label>
            <form:input path="cognome" id="cognome" class="form-control" required="true"/>
        </div>

        <div class="mb-3">
            <label for="dataNascita" class="form-label">Data di Nascita:</label>
            <form:input path="dataNascita" id="dataNascita" type="date" class="form-control" required="true"/>
        </div>

        <div class="mb-3">
            <button type="submit" class="btn btn-success">Salva</button>
            <a href="${pageContext.request.contextPath}/docenti/lista" class="btn btn-secondary">Annulla</a>
        </div>
    </form:form>

</body>
</html>
