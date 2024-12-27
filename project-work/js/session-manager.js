function verificaSessione() {
    return fetch('http://localhost:8080/api/utente/isLogged', {
        method: 'GET',
        credentials: 'include',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            // const storedUser = localStorage.getItem('utente');
            // if (storedUser) {
            //     return JSON.parse(storedUser);
            // }
            throw new Error('Utente non autenticato');
        }
        return response.json();
    });
}

function updateUI(utenteLoggato) {
    const bollino = document.getElementById("bollino-profilo");
    const loginText = document.getElementById("login-text");

    if(utenteLoggato){
        loginText.classList.add("d-none");
        bollino.classList.remove("d-none");
    }else{
        loginText.classList.remove("d-none");
        bollino.classList.add("d-none");
    }
}


function logout() {
    return fetch('http://localhost:8080/api/utente/logout', {
        method: 'POST',
        credentials: 'include'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Errore durante il logout');
        }
        window.location.replace('http://localhost:5500/project-work/login.html');
    });
}


document.addEventListener('DOMContentLoaded', () => {
    verificaSessione()
        .then(utenteData => {
            updateUI(utenteData);
        })
        .catch(error => {
            console.log('Utente non autenticato');
            updateUI(null);
        });
});