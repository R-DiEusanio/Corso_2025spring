<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista Discenti</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Academy</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" href="/discenti/lista">Discenti</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/corsi/lista">Corsi</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/docenti/lista">Docenti</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <h2 class="text-center">Elenco Discenti</h2>

    <div class="text-center mb-3">
        <a class="btn btn-primary" href="/discenti/nuovo">Aggiungi Nuovo Discente</a>
        <a href="/discenti/ordinati" class="btn btn-primary">Ordina per Nome (A-Z)</a>
    </div>

    <table class="table table-bordered table-striped">
        <thead class="table-light">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Corsi Iscritti</th>
            <th>Azioni</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="discente" items="${discenti}">
            <tr>
                <td>${discente.id}</td>
                <td>${discente.nome}</td>
                <td>${discente.cognome}</td>
                <td>
                    <c:forEach var="corso" items="${discente.corsi}">
                        ${corso.nomeCorso}<br/>
                    </c:forEach>
                </td>
                <td>
                    <a class="btn btn-sm btn-secondary" href="/discenti/${discente.id}/edit">Modifica</a>
                    <a class="btn btn-sm btn-danger" href="/discenti/${discente.id}/delete"
                       onclick="return confirm('Sei sicuro di voler eliminare questo discente?')">Elimina</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
