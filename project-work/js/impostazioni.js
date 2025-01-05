document.querySelectorAll('.elimina').forEach(button => {
    button.addEventListener('click', () => {
        Swal.fire({
            title: 'Sei sicuro?',
            text: "Non potrai recuperare questo metodo di pagamento!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sì, elimina!',
            cancelButtonText: 'Annulla'
        }).then((result) => {
            if (result.isConfirmed) {
                const metodoPagamento = button.closest('.metodo-pagamento'); // Trova il contenitore del metodo di pagamento
                if (metodoPagamento) {
                    metodoPagamento.classList.add('animate__animated', 'animate__zoomOut'); // Animazione sobria
                    metodoPagamento.addEventListener('animationend', () => {
                        metodoPagamento.remove(); // Rimuovi elemento dopo animazione
                    });
                }
            }
        });
    });
});

// Funzione per eliminare un metodo di pagamento
document.querySelectorAll('.elimina').forEach(button => {
    button.addEventListener('click', () => {
        Swal.fire({
            title: 'Sei sicuro?',
            text: "Non potrai recuperare questo metodo di pagamento!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sì, elimina!',
            cancelButtonText: 'Annulla'
        }).then((result) => {
            if (result.isConfirmed) {
                const metodoPagamento = button.closest('.metodo-pagamento'); // Trova il contenitore del metodo di pagamento
                if (metodoPagamento) {
                    metodoPagamento.classList.add('animate__animated', 'animate__zoomOut'); // Animazione sobria
                    metodoPagamento.addEventListener('animationend', () => {
                        metodoPagamento.remove(); // Rimuovi elemento dopo animazione
                    });
                }
            }
        });
    });
});



// Funzione per aggiungere un metodo di pagamento
document.querySelector('.btn-metodo-pagamento').addEventListener('click', () => {
    Swal.fire({
        title: 'Aggiungi metodo di pagamento',
        html: `
            <input type="text" id="metodo" class="swal2-input" placeholder="Tipo carta (Visa, MasterCard, etc.)">
            <input type="text" id="titolo" class="swal2-input" placeholder="Numero carta">
        `,
        focusConfirm: false,
        showCancelButton: true,  // Aggiungi il bottone annulla
        cancelButtonText: 'Annulla',  // Testo del bottone annulla
        preConfirm: () => {
            const metodo = document.getElementById('metodo').value;
            const titolo = document.getElementById('titolo').value;
            
            // Validazione dei campi
            if (!metodo || !titolo) {
                Swal.showValidationMessage('Per favore, inserisci tutti i campi');
                return false;
            }

            // Validazione del numero della carta (verifica solo lunghezza, come esempio)
            if (!/^\d{16}$/.test(titolo)) {
                Swal.showValidationMessage('Numero carta non valido. Deve essere composto da 16 cifre.');
                return false;
            }

            return { metodo, titolo };
        }
    }).then((result) => {
        if (result.isConfirmed) {
            const { metodo, titolo } = result.value;

            // Funzione per mascherare il numero della carta
            const titoloMascherato = `**** **** **** ${titolo.slice(-4)}`;

            const newMetodoHtml = `
                <div class="d-flex align-items-center metodo-pagamento">
                    <span class="carta-di-credito">${metodo} ${titoloMascherato}</span>
                    <button class="elimina btn btn-sm btn-danger ms-auto">Elimina</button>
                </div>
            `;
            const newMethodElement = document.createElement('div');
            newMethodElement.innerHTML = newMetodoHtml;

            // Aggiungi il nuovo metodo di pagamento nella lista
            const settingsSection = document.querySelector('.pay');
            settingsSection.insertBefore(newMethodElement, settingsSection.querySelector('.settings-item.mt-5'));
            
            // Aggiungi l'evento per eliminare e applica animazione al nuovo metodo
            newMethodElement.querySelector('.elimina').addEventListener('click', () => {
                Swal.fire({
                    title: 'Sei sicuro?',
                    text: "Non potrai recuperare questo metodo di pagamento!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Sì, elimina!',
                    cancelButtonText: 'Annulla'
                }).then((result) => {
                    if (result.isConfirmed) {
                        // Aggiungi animazione all'eliminazione del nuovo metodo
                        newMethodElement.classList.add('animate__animated', 'animate__zoomOut'); // Animazione sobria
                        newMethodElement.addEventListener('animationend', () => {
                            newMethodElement.remove(); // Rimuovi elemento dopo animazione
                        });
                    }
                });
            });
        } else if (result.isDismissed) {
            // Se l'utente ha cliccato "Annulla", puoi aggiungere eventuali azioni qui (opzionale)
            console.log('Operazione annullata');
        }
    });
});




//Aggiorna patente
const fileInput = document.getElementById("licenseFile");
const updateButton = document.getElementById("updateButton");
const confirmationMessage = document.getElementById("confirmationMessage");

fileInput.addEventListener("change", function() {
    if (fileInput.files.length > 0) {
        updateButton.style.display = "inline-block";
    }
});

updateButton.addEventListener("click", function() {
    // Mostra il messaggio di conferma
    confirmationMessage.style.display = "block";
    // Nascondi il pulsante dopo l'aggiornamento
    updateButton.style.display = "none";
});