<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>${corso.id == null ? 'Nuovo Corso' : 'Modifica Corso'}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg border-0 rounded-4">
        <div class="card-body p-5">
            <h2 class="text-center mb-4 text-primary fw-bold">
                ${corso.id == null ? 'Aggiungi Nuovo Corso' : 'Modifica Corso'}
            </h2>

            <form action="/corsi" method="post" class="needs-validation" novalidate>
                <c:if test="${corso.id != null}">
                    <input type="hidden" name="id" value="${corso.id}" />
                </c:if>

                <div class="mb-4">
                    <label class="form-label fw-semibold">Nome Corso</label>
                    <input type="text" class="form-control" name="nomeCorso"
                           value="${corso.nomeCorso}" required />
                </div>

                <div class="mb-4">
                    <label class="form-label fw-semibold">Anno Accademico</label>
                    <input type="number" class="form-control" name="annoAccademico"
                           value="${corso.annoAccademico}" required />
                </div>

                <div class="mb-4">
                    <label class="form-label fw-semibold">ID Docente</label>
                    <input type="number" class="form-control" name="docente.id"
                           value="${corso.docente != null ? corso.docente.id : ''}" required />
                </div>

                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-primary px-4">Salva</button>
                    <a href="/corsi/lista" class="btn btn-outline-secondary px-4">Annulla</a>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
