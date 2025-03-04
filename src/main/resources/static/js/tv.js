let mensagens = [];
let mensagemIndex = 0;
let intervalId;
const url = `${window.location.protocol}//${window.location.hostname}/mensagens`;

const audio = new Audio("/audio/hospital-monitor-151929.mp3");

const

const disableButton = () => {
    const btn = document.getElementsByClassName("btn-primary")[0];
    btn.remove();
}

const lerMensagem = (mensagem) => {
    const utterance = new SpeechSynthesisUtterance(mensagem); // cria leitor de tela
    utterance.lang = "pt-br";
    utterance.rate = 1; // velocidade de fala
    utterance.pitch = 1; // altura de fala
    speechSynthesis.speak(utterance);
}

const atualizarTela = (mensagem) => {
    const tamanhoBase = 6; // Tamanho inicial da fonte (em rem)
    const vlReducao = 0.02;  // Redução por caractere (em rem)
    const tamanhoMensagem = mensagem.length; // Comprimento da mensagem atual
    const novoTamanho = Math.max(tamanhoBase - tamanhoMensagem * vlReducao, 2); // Limite mínimo de 1rem
    const mensagemDiv = document.getElementById('mensagem');
    mensagemDiv.style.fontSize = `${novoTamanho}rem`;
};

const exibirMensagem = () => {
    const mensagemDiv = document.getElementById('mensagem');
    if (mensagemIndex < mensagens.length) {
        const mensagem = mensagens[mensagemIndex].descricaoMensagem;
        atualizarTela(mensagem); // Atualiza o tamanho da fonte com base no texto
        audio.play();
        lerMensagem(mensagem);
        mensagemDiv.textContent = mensagem;
        mensagemIndex++;
    } else {
        clearInterval(intervalId);
        atualizarMensagens(); // Atualiza as mensagens novamente
    }
};

const atualizarMensagens = () => {
    fetch(url)
        .then(response => {
            if (!response.ok) {
                setInterval(atualizarMensagens,5000); // fica chamando a mensagem até ela funcionar
            }
            return response.json();
        })
        .then(data => {
            mensagens = data; // Atualiza a lista de mensagens
            mensagemIndex = 0; // Reseta o índice
            exibirMensagem(); // Exibe a primeira mensagem imediatamente
            intervalId = setInterval(exibirMensagem, 30000); // Mostra uma nova mensagem a cada 30 segundos
        })
        .catch(error => {
            console.error('Houve um problema com o fetch:', error);
        });
};

const esperarMeiaNoite = () => {
    const agora = new Date();
    const proximaMeiaNoite = new Date(agora);
    proximaMeiaNoite.setHours(24, 0, 0, 0); // Define a próxima meia-noite

    const tempoParaEspera = proximaMeiaNoite - agora; // Tempo em milissegundos até a próxima meia-noite
    setTimeout(() => {
        atualizarMensagens(); // Faz a primeira requisição às 00:00
        setTimeout(() => {
            atualizarMensagens(); // Faz uma nova requisição após 1min30s (90 segundos)
        }, 90000); // 1min30s em milissegundos
    }, tempoParaEspera);
}

esperarMeiaNoite();

const habilitaFetch = () => {
        setTimeout(atualizarMensagens,5000);
}
