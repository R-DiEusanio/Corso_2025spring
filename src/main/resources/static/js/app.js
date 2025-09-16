function initCrud(config) {
    const { endpoint, formId, tableBodyId, fields } = config;

    const form = document.getElementById(formId);
    const tbody = document.getElementById(tableBodyId);
    const hiddenId = document.getElementById(`${formId}-id`);

    // Carica tutti i dati
    async function caricaDati() {
        const res = await fetch(endpoint);
        const data = await res.json();
        tbody.innerHTML = "";

        data.forEach(item => {
            const tr = document.createElement("tr");
            let rowHtml = "";
            fields.forEach(f => rowHtml += `<td>${item[f] ?? ""}</td>`);
            rowHtml += `
                <td>
                    <button class="edit-btn" onclick='modifica(${JSON.stringify(item)})'>Modifica</button>
                    <button class="delete-btn" onclick='elimina(${item.id})'>Elimina</button>
                </td>
            `;
            tr.innerHTML = rowHtml;
            tbody.appendChild(tr);
        });
    }

    // Salva nuovo o modifica esistente
    form.addEventListener("submit", async e => {
        e.preventDefault();
        const id = hiddenId.value;
        const body = {};
        fields.forEach(f => body[f] = document.getElementById(`${formId}-${f}`).value);

        const method = id ? "PUT" : "POST";
        const url = id ? `${endpoint}/${id}` : endpoint;

        await fetch(url, {
            method,
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(body)
        });

        form.reset();
        hiddenId.value = "";
        await caricaDati();
    });

    // Modifica
    window.modifica = (item) => {
        hiddenId.value = item.id;
        fields.forEach(f => document.getElementById(`${formId}-${f}`).value = item[f] ?? "");
    };

    // Elimina
    window.elimina = async (id) => {
        if (confirm("Sei sicuro di voler eliminare?")) {
            await fetch(`${endpoint}/${id}`, { method: "DELETE" });
            await caricaDati();
        }
    };

    // Reset form
    document.getElementById(`${formId}-reset`).addEventListener("click", () => {
        form.reset();
        hiddenId.value = "";
    });

    caricaDati().then(r => {});
}
