<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Lista Corsi</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Academy</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/studenti/lista">Studenti</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/corsi/lista">Corsi</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/docenti/lista">Docenti</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <h2 class="text-center mb-4">Elenco Corsi</h2>

    <div class="mb-3 text-center">
        <a class="btn btn-success" href="/corsi/nuovo">Aggiungi Nuovo Corso</a>
    </div>

    <table class="table table-striped table-bordered">
        <thead class="table-light">
        <tr>
            <th>ID</th>
            <th>Nome Corso</th>
            <th>Anno Accademico</th>
            <th>Docente</th>
            <th>Azioni</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="corso" items="${corsi}">
            <tr>
                <td>${corso.id}</td>
                <td>${corso.nomeCorso}</td>
                <td>${corso.annoAccademico}</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty corso.docente}">
                            ${corso.docente.id}
                        </c:when>
                        <c:otherwise>
                            <em>Non assegnato</em>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a class="btn btn-sm btn-secondary" href="/corsi/${corso.id}/edit">Modifica</a>
                    <a class="btn btn-sm btn-danger" href="/corsi/${corso.id}/delete"
                       onclick="return confirm('Sei sicuro di voler eliminare questo corso?')">Elimina</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
