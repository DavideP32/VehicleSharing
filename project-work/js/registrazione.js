// Richiamo il form
const form = document.querySelector('.form');

form.addEventListener('submit',  e => {

    e.preventDefault();

    //Raccolgo valori dell'input
    
    const name = form.name.value.trim();
    const surname = form.surname.value.trim();
    //DOBBIAMO INSERIRE LA DATA DI NASCITA
    const email = form.email.value.trim();
    const password = form.password.value.trim();
    const licenseFile = form.licenseFile.value.trim();

    //creazione oggetto utente
    const utente = {
        nome: name,
        cognome: surname,
        email: email,
        //DOBBIAMO INSERIRE LA DATA DI NASCITA
        password: password,


    };

});


