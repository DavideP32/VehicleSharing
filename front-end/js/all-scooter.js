fetch("http://localhost:8080/api/veicolo").then(response => {
    return response.json()
}).then(data => {
    const contenitoreCardDisponibili = document.getElementById("contenitore-card-disponibili");
    const contenitoreCardNonDisp = document.getElementById("contenitore-card-non-disponibili");
    console.log(data);

    let count = 0;
    data.forEach(element => {
        if(element.categoria === 'SCOOTER' && element.disponibilitaNoleggio === true){
           if(count < 15){
             count++;
           } else{
             count = 1;
           }    
           contenitoreCardDisponibili.innerHTML +=
            `<div class="col-md-6 col-lg-4 col-xxl-3 d-flex justify-content-center">
                    <div class="card" data-id="1">
                        <div class="availability-badge available">Disponibile</div>
                        <a href="veicolo-selezionato.html"><img src="./images/moto${count}.jpg" class="card-img-top"></a>
                        <div class="card-body">
                            <h5 class="card-title kaushan-script-regular">${element.descrizione}</h5>
                            <p class="card-text">
                                <strong>Alimentazione:</strong> ${element.alimentazione}<br>
                                <strong>Indirizzo:</strong> ${element.indirizzo}
                            </p>
                        </div>
                    </div>
                </div>`
        } else if(element.categoria === 'SCOOTER' && element.disponibilitaNoleggio === false){
            if(count < 15){
                count++;
              } else{
                count = 1;
              }
            contenitoreCardNonDisp.innerHTML +=
            `<div class="col-md-6 col-lg-4 col-xxl-3 d-flex justify-content-center">
                    <div class="card" data-id="1">
                        <div class="availability-badge not-available">Disponibile</div>
                        <a href="veicolo-selezionato.html"><img src="./images/moto${count}.jpg" class="card-img-top"></a>
                        <div class="card-body">
                            <h5 class="card-title kaushan-script-regular">${element.descrizione}</h5>
                            <p class="card-text">
                                <strong>Alimentazione:</strong> ${element.alimentazione}<br>
                                <strong>Indirizzo:</strong> ${element.indirizzo}
                            </p>
                        </div>
                    </div>
                </div>`
        }
    });

}).catch(err => {
    console.log(err);

});
