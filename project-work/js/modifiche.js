

//Per cambiare colore al bollino (Non funzionante)
// Mostra la tavolozza dei colori quando clicchi sull'icona di modifica
document.querySelector('.edit-icon').addEventListener('click', function () {
    document.getElementById('colorPicker').style.display = 'block';
});

// Cambia il colore cliccando sui pulsanti della tavolozza
document.querySelectorAll('.color-btn').forEach(btn => {
    btn.addEventListener('click', function () {
        const selectedColor = this.getAttribute('data-color');
        // Seleziona l'elemento con la classe .badge-circle e cambia il suo colore
        document.querySelector('.badge-circle').style.backgroundColor = selectedColor;
        document.getElementById('colorPicker').style.display = 'none';  // Nascondi il color picker
    });
});

// Permette di applicare il colore manuale tramite il selettore di colore
document.getElementById('applyColor').addEventListener('click', function () {
    const newColor = document.getElementById('colorInput').value;
    // Seleziona l'elemento con la classe .badge-circle e cambia il suo colore
    document.querySelector('.badge-circle').style.backgroundColor = newColor;
    document.getElementById('colorPicker').style.display = 'none';  // Nascondi il color picker
});

// Annulla la selezione del colore
document.getElementById('cancelColor').addEventListener('click', function () {
    document.getElementById('colorPicker').style.display = 'none';  // Nascondi il color picker
});









//Per annullare le modifiche del profilo
document.querySelector('.btn-cancel').addEventListener('click', function () {
    // Seleziona tutti gli input nel profilo
    const inputs = document.querySelectorAll('.profile-content input');

    // Ripristina il valore originale di ogni campo
    inputs.forEach(input => {
        input.value = input.defaultValue; // Resetta al valore iniziale
    });
});








// Per cancellare la prenotazione
document.querySelectorAll('.annulla-prenotazione').forEach(button => {
    button.addEventListener('click', () => {
        Swal.fire({
            title: 'Sei sicuro?',
            text: "La tua prenotazione varrà cancellata!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sì, annulla!',
            cancelButtonText: 'Annulla'
        }).then((result) => {
            if (result.isConfirmed) {
                const card = button.closest('.card'); // Trova il contenitore della prenotazione
                if (card) {
                    // Aggiungi animazione di uscita
                    card.classList.add('animate__animated', 'animate__zoomOut');
                    card.addEventListener('animationend', () => {
                        card.remove(); // Rimuovi l'elemento dopo animazione
                    });
                }
            }
        });
    });
});

