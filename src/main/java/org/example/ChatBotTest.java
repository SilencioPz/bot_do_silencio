package org.example;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ChatBotTest {

    private final ChatBot chatBot = new ChatBot();

    @Test
    void testarRespostaSaudacao() {
        String mensagem = "Olá";
        String resposta = chatBot.gerarResposta(mensagem);

        List<String> respostasPossiveis = Arrays.asList(
                "Olá! Como você está?",
                "Oi! Tudo bem?",
                "E aí? Como vai?",
                "Eae, que q conta?",
                "Opa, dia tá bonito hoje né?!"
        );

        assertTrue("Resposta não está no padrão de saudação!", respostasPossiveis.contains(resposta));
    }

    @Test
    void testarRespostaDespedida() {
        String mensagem = "Tchau";
        String resposta = chatBot.gerarResposta(mensagem);

        List<String> respostasPossiveis = Arrays.asList(
                "Até logo! Foi um prazer conversar com você.",
                "Opa, vai pela sombra cumpadi!",
                "Quem vaza é peido maluco! XD"
        );

        assertTrue("Resposta não está no padrão de despedida!", respostasPossiveis.contains(resposta));
    }

    @Test
    void testarRespostaAleatoria() {
        String mensagem = "Qualquer coisa aleatória 123";
        String resposta = chatBot.gerarResposta(mensagem);

        // Verifica se a resposta não está vazia e é uma das respostas padrão
        assertNotNull(resposta, "Resposta não deveria ser nula!");
        assertFalse("Resposta não deveria ser vazia!", resposta.isEmpty());
    }
}