document.addEventListener('DOMContentLoaded', () => {
    verificaSessione()
        .then(utenteData => {
            updateUI(utenteData);
        })
        .catch(error => {
            console.log('Utente non autenticato');
            updateUI(null);
        });

    //pulsante di logout
    const logoutBtn = document.getElementById("logout");
    if (logoutBtn) {
        logoutBtn.addEventListener("click", () => {
            logout();
        });
    }
});

//Prendiamo la sessione dell'utente se è autenticato
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
        return response.json().then(data =>{
            console.log(data);
            return data;
        }
        );
    });
}

//aggiorniamo l'ui in base all'autenticazione
function updateUI(utenteLoggato) {
    const bollino = document.getElementById("bollino-profilo");
    const loginText = document.getElementById("login-text");
    const inizialeNome = document.getElementById("userBadge");
    // const inizialeNomeProfilo = document.getElementById("userBadgeProfilo");

    if(utenteLoggato){
        loginText.classList.add("d-none");
        bollino.classList.remove("d-none");
        inizialeNome.textContent = `${utenteLoggato.nome[0].toUpperCase()}`;
        // inizialeNomeProfilo.textContent = `${utenteLoggato.nome[0].toUpperCase()}`;
    }else{
        loginText.classList.remove("d-none");
        bollino.classList.add("d-none");
    }
}

//funzione per il pulsante logout
function logout() {
    return fetch('http://localhost:8080/api/utente/logout', {
        method: 'POST',
        credentials: 'include'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Errore durante il logout');
        }
        updateUI(null);
        window.location.replace('http://localhost:5500/front-end/login.html');
    })
    .catch(error => {
        console.error('Errore durante il logout:', error);
    });
}

/* 
Questo serve a gestire le pagine protette quando ci saranno. 

document.addEventListener('DOMContentLoaded', () => {
    const isLoginPage = window.location.pathname.endsWith('/login.html');

    verificaSessione()
        .then(utenteData => {
            if (utenteData && isLoginPage) {
                // Se l'utente è autenticato e si trova sulla pagina di login, reindirizzalo
                window.location.replace('http://localhost:5500/project-work/index.html');
            }
        })
        .catch(error => {
            if (!isLoginPage) {
                // Se l'utente non è autenticato e non è nella pagina di login, reindirizzalo al login
                window.location.replace('http://localhost:5500/project-work/login.html');
            }
        });
});
*/