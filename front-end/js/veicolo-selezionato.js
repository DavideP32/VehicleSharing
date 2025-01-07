const map = L.map('map').setView([40.7982, 14.0747], 13); // Coordinate del luogo, + zoom livello 13

// Aggiungere il layer OpenStreetMap
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

// Aggiungere un marker
L.marker([40.7982, 14.0747]).addTo(map)
    .bindPopup('Bacoli, Napoli') // Popup con un messaggio
    .openPopup();

    document.addEventListener("DOMContentLoaded", function () {
        // Recupera i dettagli dell'auto dal localStorage
        const selectedVehicle = JSON.parse(localStorage.getItem('selectedVehicle'));
    
        if (selectedVehicle) {
            // Popola i dettagli dell'auto nella pagina
            document.getElementById('dettagli-auto').innerHTML = `
                <h3>${selectedVehicle.modello}</h3>
                <p><strong>Chilometraggio:</strong> ${selectedVehicle.km}</p>
                <p><strong>Carburante:</strong> ${selectedVehicle.carburante}</p>
                <p><strong>Potenza:</strong> ${selectedVehicle.potenza}</p>
                <p><strong>Prezzo:</strong> ${selectedVehicle.prezzo}</p>
            `;
        } else {
            // Se non ci sono dati salvati, mostra un messaggio di errore o di avviso
            document.getElementById('dettagli-auto').innerHTML = `<p>Dettagli auto non disponibili.</p>`;
        }
    });

