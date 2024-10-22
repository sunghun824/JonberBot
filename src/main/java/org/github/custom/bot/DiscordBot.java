package org.github.custom.bot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class DiscordBot {

    public static void main(String[] args) {

        BotTokenManager tokenManager = new BotTokenManager();
        String token = tokenManager.getDiscordBotToken();
        JDABuilder.createDefault(token)
                .setActivity(Activity.playing("봇만들기"))
                .build();
    }
}
