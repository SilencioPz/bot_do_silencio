package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class VozDoSilencioBot extends TelegramLongPollingBot {

    private ChatBot chatBot;
    private String botToken;

    public VozDoSilencioBot() {
        this.chatBot = new ChatBot();
        this.botToken = System.getenv("TELEGRAM_BOT_TOKEN");

        if (botToken == null || botToken.isEmpty()) {
            throw new RuntimeException("Token do Telegram não encontrado. Defina a variável de ambiente TELEGRAM_BOT_TOKEN.");
        }
    }

    @Override
    public String getBotUsername() {
        return "VozDoSilencio17Bot";
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String mensagemRecebida = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            String resposta = chatBot.gerarResposta(mensagemRecebida);

            SendMessage mensagem = new SendMessage();
            mensagem.setChatId(String.valueOf(chatId));
            mensagem.setText(resposta);

            mensagem.setReplyMarkup(criarTeclado());

            try {
                execute(mensagem);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private ReplyKeyboardMarkup criarTeclado() {
        ReplyKeyboardMarkup teclado = new ReplyKeyboardMarkup();
        teclado.setResizeKeyboard(true);

        KeyboardRow linha1 = new KeyboardRow();
        linha1.add("Olá");
        linha1.add("Tchau");

        KeyboardRow linha2 = new KeyboardRow();
        linha2.add("Quem é você?");
        linha2.add("Preciso de ajuda");

        KeyboardRow linha3 = new KeyboardRow();
        linha3.add("Trabalho");
        linha3.add("Estudo");

        KeyboardRow linha4 = new KeyboardRow();
        linha4.add("Namoro");
        linha4.add("Casamento");

        KeyboardRow linha5 = new KeyboardRow();
        linha5.add("De boa");
        linha5.add("Qualé");

        KeyboardRow linha6 = new KeyboardRow();
        linha6.add("Findi");
        linha6.add("Feriado");

        KeyboardRow linha7 = new KeyboardRow();
        linha7.add("Churras");
        linha7.add("Comida");

        KeyboardRow linha8 = new KeyboardRow();
        linha8.add("Dormindo");
        linha8.add("Viajando");

        List<KeyboardRow> linhas = new ArrayList<>();
        linhas.add(linha1);
        linhas.add(linha2);
        linhas.add(linha3);
        linhas.add(linha4);
        linhas.add(linha5);
        linhas.add(linha6);
        linhas.add(linha7);
        linhas.add(linha8);

        teclado.setKeyboard(linhas);
        return teclado;
    }
}