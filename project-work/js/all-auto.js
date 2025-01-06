// function selezionaVeicolo(modello, km, carburante, potenza, prezzo, immagine) {
//     // Oggetto con i dettagli del veicolo
//     const vehicleDetails = {
//         modello,
//         km,
//         carburante,
//         potenza,
//         prezzo,
//         immagine
//     };

//     // Salva i dettagli nel localStorage
//     localStorage.setItem('selectedVehicle', JSON.stringify(vehicleDetails));
// }

fetch("http://localhost:8080/api/veicolo").then(response => {
    return response.json()
}).then(data => {
    console.log(data);

}).catch(err => {
    console.log(err);

});
