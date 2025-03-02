const relogio = document.getElementById("relogio");

const formataHorario = (horario) => {
    return horario < 10 ? "0" + horario : horario;
}

const atualizarRelogio = () => {
    const data = new Date();
    let hora = data.getHours();
    let minuto = data.getMinutes();
    relogio.innerHTML = formataHorario(hora) + ":" + formataHorario(minuto);
}

atualizarRelogio();

setInterval(atualizarRelogio, 1000);