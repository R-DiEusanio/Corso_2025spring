<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Elenco Docenti</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Academy</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" href="<c:url value='/docenti/lista'/>">Docenti</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/studenti/lista'/>">Studenti</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<body class="container mt-4">

<h1>Elenco Docenti</h1>

<a class="btn btn-primary mb-3" href="<c:url value='/docenti/nuovo'/>">Nuovo Docente</a>

<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Cognome</th>
        <th>Data di Nascita</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="d" items="${docenti}">
        <tr>
            <td>${d.id}</td>
            <td>${d.nome}</td>
            <td>${d.cognome}</td>
            <td><fmt:formatDate value="${d.dataNascita}" pattern="dd/MM/yyyy"/></td>
            <td>
                <a class="btn btn-sm btn-secondary" href="<c:url value='/docenti/${d.id}/edit'/>">Modifica</a>
                <a class="btn btn-sm btn-danger" href="<c:url value='/docenti/${d.id}/delete'/>"
                   onclick="return confirm('Sei sicuro?')">Elimina</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
