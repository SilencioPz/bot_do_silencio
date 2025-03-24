package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

//VozDoSilencio17Bot --- "Nome" do Bot no Telegram

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new VozDoSilencioBot());
            System.out.println("Bot iniciado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}