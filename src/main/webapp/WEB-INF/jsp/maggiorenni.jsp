<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Studenti Maggiorenni</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>
<body>

<div class="container mt-4">
    <h2 class="text-center mb-4">Lista Studenti Maggiorenni</h2>

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Età</th>
            <th>Matricola</th>
            <th>Città di Residenza</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="studente" items="${studenti}">
            <tr>
                <td>${studente.nome}</td>
                <td>${studente.cognome}</td>
                <td>${studente.eta}</td>
                <td>${studente.matricola}</td>
                <td>${studente.cittaResidenza}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/studenti/lista" class="btn btn-secondary">Torna alla Lista</a>
</div>

</body>
</html>
