const map = L.map('map').setView([40.7982, 14.0747], 13); // Coordinate del luogo, + zoom livello 13

// Aggiungere il layer OpenStreetMap
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

// Aggiungere un marker
L.marker([40.7982, 14.0747]).addTo(map)
    .bindPopup('Bacoli, Napoli') // Popup con un messaggio
    .openPopup();
