<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista Studenti</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Academy</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" href="/studenti/lista">Studenti</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/docenti/lista">Docenti</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <h2 class="text-center">Elenco Studenti</h2>

    <div class="text-center mb-3">
        <a class="btn btn-primary" href="/studenti/nuovo"> Aggiungi Nuovo Studente</a>
    </div>

    <table class="table table-bordered table-striped">
        <thead class="table-light">
        <tr>

            <th>ID</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Età</th>
            <th>Matricola</th>
            <th>città di residenza</th>
            <th>Azioni</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="studente" items="${studenti}">
            <tr>
                <td>${studente.id}</td>
                <td>${studente.nome}</td>
                <td>${studente.cognome}</td>
                <td>${studente.eta}</td>
                <td>${studente.matricola}</td>
                <td>${studente.cittaResidenza}</td>
                <td>
                    <a class="btn btn-sm btn-secondary" href="/studenti/${studente.id}/edit">Modifica</a>
                    <a class="btn btn-sm btn-danger" href="/studenti/${studente.id}/delete"
                       onclick="return confirm('Sei sicuro di voler eliminare questo studente?')">Elimina</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
