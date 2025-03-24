package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChatBot {
    private Map<String, String[]> respostasMap;

    public ChatBot() {
        respostasMap = new HashMap<>();
        inicializarRespostas();
    }

    private void inicializarRespostas() {
        respostasMap.put(".*(olá|oi|eaí|bom dia|boa tarde|boa noite).*",
                new String[]{"Olá! Como você está?", "Oi! Tudo bem?", "E aí? Como vai?", "Eae, que q conta?", "Opa, " +
                        "dia tá bonito hoje né?!"});

        respostasMap.put(".*(tchau|até logo|flw|vou vazar).*",
                new String[]{"Até logo! Foi um prazer conversar com você.", "Opa, vai pela sombra cumpadi!", "Quem vaza " +
                        "é peido maluco! XD"});

        respostasMap.put(".*(quem é você|qual seu nome|o que você faz).*",
                new String[]{"Eu sou um ChatBot criado pelo meu parça SilencioPz! Estou aqui para ajudar.", "Do que " +
                        "você precisa exatamente?", "Eu não faço muita coisa não, e vc?! ;D"});

        respostasMap.put(".*(ajuda|socorro|preciso de ajuda).*",
                new String[]{"Claro! Posso ajudar com informações básicas. O que você precisa?", "Ajuda? Tô fora meu " +
                        "patrão!!!", "Eita, onde que tá pegando fogo doido?! u_u'"});

        respostasMap.put(".*(trabalho|estudo|atividade).*",
                new String[]{"Trabalho? Tô fora meu amigo, quero sombra e água fresca! ^_^", "Que mané estudar meu " +
                        "chapa, tem que curtir a vida tá ligado?! :)", "Atividade? Só se for a do Charlie Brown! :P"});

        respostasMap.put(".*(namoro|casamento|ficar).*",
                new String[]{"Namorar? Pra que meu fii? Dá dinheiro não! ;)", "Casamento? Meu Jesus, tô saindo fora!",
                        "Ficar por ficar eu não queeeeeeeeeeeeeeeeeero..."});

        respostasMap.put(".*(de boa|to ligado|quale).*",
                new String[]{"De boaaaaaaaça, e tu?!", "Quem tá ligado é tomada meu chapa!", "Quale neguim, qualé!!!"});

        respostasMap.put(".*(findi|fim de semana|folga|feriado).*",
                new String[]{"Findisemana chegano e coitado tá no osso mermão...", "Findi?! Sabia não!!!", "Folga? " +
                        "Robô não folga meu truta!", "Feriado? Tá maluco? Tem que trabalhar, só boleto chegano maluco!"});

        respostasMap.put(".*(churras|churrasco|comida|bóia|bucho cheio).*",
                new String[]{"Churras? Onde? Boralá?!", "Churrasco e bom chimarrão, Fandango, trago e mulher! XD",
                        "Comida é pasto! Você tem fome de quê?", "Bóia? Não tem piscina aqui! :)", "Buchim chei é? " +
                        "Cuidado pra não rolar! o_O"});

        respostasMap.put(".*(dormindo|viajando|vacilando|noiado|maluco).*",
                new String[]{"Dormindo? Robô não dorme abestado! :D", "Viajando? Só se for na maionese!!! ;D", "Que " +
                        "vacilo maluco, sou fura-olho não morô?!", "Noiado só se for de café! =D"});

        // Respostas padrão
        respostasMap.put(".*",
                new String[]{"Tô de boa, e tu?", "Opa, tranquilo meu brother! Esquenta não que hoje é Sexta morô?",
                        "Qualé cumpadi, vamo fica sussa que hoje o dia tá light tá ligado?!"});
    }

    public String gerarResposta(String mensagem) {
        mensagem = mensagem.toLowerCase();

        for (Map.Entry<String, String[]> entry : respostasMap.entrySet()) {
            if (mensagem.matches(entry.getKey())) {
                String[] respostas = entry.getValue();
                return respostas[new Random().nextInt(respostas.length)];
            }
        }

        return "Hmm... não entendi direito. Pode repetir?";
    }
}