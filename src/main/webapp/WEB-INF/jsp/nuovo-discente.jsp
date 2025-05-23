<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Form Discente</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>
<body>

<div class="container mt-4">
    <h2 class="text-center">
        <c:choose>
            <c:when test="${not empty discente.id}">
                Modifica Discente
            </c:when>
            <c:otherwise>
                Aggiungi Nuovo Discente
            </c:otherwise>
        </c:choose>
    </h2>

    <c:choose>
        <c:when test="${not empty discente.id}">
            <c:set var="formAction" value="${pageContext.request.contextPath}/discenti/${discente.id}/edit"/>
        </c:when>
        <c:otherwise>
            <c:set var="formAction" value="${pageContext.request.contextPath}/discenti"/>
        </c:otherwise>
    </c:choose>

    <form method="post" action="${formAction}">
        <input type="hidden" name="id" value="${discente.id}"/>

        <div class="mb-3">
            <label for="nome" class="form-label">Nome</label>
            <input type="text" class="form-control" id="nome" name="nome" value="${discente.nome}" required>
        </div>

        <div class="mb-3">
            <label for="cognome" class="form-label">Cognome</label>
            <input type="text" class="form-control" id="cognome" name="cognome" value="${discente.cognome}" required>
        </div>

        <div class="mb-3">
            <label for="eta" class="form-label">Età</label>
            <input type="number" class="form-control" id="eta" name="eta" value="${discente.eta}" required>
        </div>

        <div class="mb-3">
            <label for="matricola" class="form-label">Matricola</label>
            <input type="text" class="form-control" id="matricola" name="matricola" value="${discente.matricola}" required>
        </div>

        <div class="mb-3">
            <label for="cittaResidenza" class="form-label">Città di Residenza</label>
            <input type="text" class="form-control" id="cittaResidenza" name="cittaResidenza" value="${discente.cittaResidenza}" required>
        </div>

        <div class="mb-3">
            <label for="idCorso" class="form-label">ID Corso</label>
            <input type="number" class="form-control" id="idCorso" name="idCorso" placeholder="Inserisci ID corso (opzionale)">
        </div>

        <button type="submit" class="btn btn-success">Salva</button>
        <a href="/discenti/lista" class="btn btn-secondary">Annulla</a>
    </form>
</div>

</body>
</html>
