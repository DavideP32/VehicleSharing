let form = document.querySelector("form");

form.addEventListener("submit", e =>{
    e.preventDefault();

    const email = form.email.value.trim();
    const password = form.password.value.trim();

    const utente = {
        email: email,
        password: password
    };


    fetch("http://localhost:8080/api/utente/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(utente),
        credentials: 'include'

    })
    .then(response =>{
        if (!response.ok) {
            console.error('Errore durante il login:', response.status, response.statusText);
            throw new Error("Login fallito");
        }
        return response.json()
    })
    .then(utenteData => {  
        console.log('Login riuscito:', utenteData);
        localStorage.setItem('utente', JSON.stringify(utenteData));
        // window.location.href = '/impostazioni.html'; 
        window.location.replace('http://localhost:5500/project-work/index.html');
    })
    .catch(error => {
        console.error('Errore durante il login:', error);
        alert('Login fallito. Controlla le credenziali.');
    });
})

