<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Form Studente</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>
<body>

<div class="container mt-4">
    <h2 class="text-center">
        <c:choose>
            <c:when test="${not empty studente.id}">
                Modifica Studente
            </c:when>
            <c:otherwise>
                Aggiungi Nuovo Studente
            </c:otherwise>
        </c:choose>
    </h2>

    <c:choose>
        <c:when test="${not empty studente.id}">
            <c:set var="formAction" value="${pageContext.request.contextPath}/studenti/${studente.id}/edit"/>
        </c:when>
        <c:otherwise>
            <c:set var="formAction" value="${pageContext.request.contextPath}/studenti"/>
        </c:otherwise>
    </c:choose>

    <form method="post" action="${formAction}">
        <input type="hidden" name="id" value="${studente.id}"/>

        <div class="mb-3">
            <label for="nome" class="form-label">Nome</label>
            <input type="text" class="form-control" id="nome" name="nome" value="${studente.nome}" required>
        </div>

        <div class="mb-3">
            <label for="cognome" class="form-label">Cognome</label>
            <input type="text" class="form-control" id="cognome" name="cognome" value="${studente.cognome}" required>
        </div>

        <div class="mb-3">
            <label for="eta" class="form-label">Età</label>
            <input type="number" class="form-control" id="eta" name="eta" value="${studente.eta}" required>
        </div>

        <div class="mb-3">
            <label for="matricola" class="form-label">Matricola</label>
            <input type="text" class="form-control" id="matricola" name="matricola" value="${studente.matricola}" required>
        </div>

        <div class="mb-3">
            <label for="cittaResidenza" class="form-label">Città di Residenza</label>
            <input type="text" class="form-control" id="cittaResidenza" name="cittaResidenza" value="${studente.cittaResidenza}" required>
        </div>

        <button type="submit" class="btn btn-success">Salva</button>
        <a href="/studenti/lista" class="btn btn-secondary">Annulla</a>
    </form>
</div>

</body>
</html>
