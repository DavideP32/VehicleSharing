// Richiamo il form
const form = document.querySelector('form');

form.addEventListener('submit',  e => {

    e.preventDefault();

    //Raccolgo valori dell'input
    
    const name = form.name.value.trim();
    const surname = form.surname.value.trim();
    const dateOfBirth = form.birthdate.value.trim();
    const email = form.email.value.trim();
    const password = form.password.value.trim();
    const licenseFile = form.licenseFile.value.trim();

    //creazione oggetto utente
    const utente = {
        nome: name,
        cognome: surname,
        email: email,
        dataNascita: dateOfBirth,
        password: password,
        ruolo: "UTENTE"
    };

    fetch("http://localhost:8080/api/utente", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(utente)

    })
    .then(response =>{
        window.location.replace('http://localhost:5500/front-end/index.html');
        return response.json();
    })

});