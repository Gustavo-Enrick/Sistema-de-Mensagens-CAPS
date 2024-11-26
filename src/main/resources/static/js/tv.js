var mensagens = [];
var mensagemIndex = 0;

    function exibirMensagem() {
        var mensagemDiv = document.getElementById('mensagem');
        if (mensagemIndex < mensagens.length) {
            mensagemDiv.innerHTML = mensagens[mensagemIndex].descricaoMensagem || "Mensagem não disponível";
            mensagemIndex++;
        } else {
            mensagemDiv.innerHTML = "Nenhuma nova mensagem.";
            setTimeout(atualizarMensagens, 10000);
        }
    }

    function atualizarMensagens() {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "http://:2250/mensagens", true);

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                try {
                    mensagens = JSON.parse(xhr.responseText);
                    mensagemIndex = 0;

                    if (mensagens.length > 0) {
                        exibirMensagem();
                    } else {
                        document.getElementById('mensagem').innerHTML = "Nenhuma mensagem encontrada.";
                    }
                } catch (e) {
                    document.getElementById('mensagem').innerHTML = "Erro ao processar mensagens.";
                }
            } else if (xhr.readyState === 4) {
                document.getElementById('mensagem').innerHTML = "Erro ao carregar mensagens.";
            }
        };

        xhr.send(null);
    }

window.onload = atualizarMensagens;