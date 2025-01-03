document.addEventListener("DOMContentLoaded", function () {
    // Aggiungere un event listener per ogni card
    document.querySelectorAll('.card').forEach(card => {
        card.addEventListener('click', function () {
            // Ottieni l'ID dell'auto dalla card cliccata
            const autoId = parseInt(card.getAttribute('data-id')); 

            // Recupera i dettagli dell'auto in base all'ID
            const autoDetails = getAutoDetailsById(autoId); 

            // Salva i dettagli nel localStorage
            localStorage.setItem('selectedVehicle', JSON.stringify(autoDetails));

            // Reindirizza alla pagina dei dettagli
            window.location.href = 'veicolo-selezionato.html';
        });
    });
});

// Funzione per ottenere i dettagli dell'auto in base all'ID
function getAutoDetailsById(autoId) {
    const autoDatabase = [
        {id: 1, modello: "Auto 1", km: "55.580", carburante: "Benzina", potenza: "136 CV", prezzo: "25,000"}, 
        {id: 2, modello: "Auto 2", km: "40.000", carburante: "Diesel", potenza: "150 CV", prezzo: "30,000"},
        // Aggiungi qui altre auto, se necessario
    ];

    // Trova e restituisci i dettagli dell'auto con l'ID corrispondente
    return autoDatabase.find(auto => auto.id === autoId);
}