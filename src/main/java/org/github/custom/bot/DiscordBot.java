package org.github.custom.bot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.github.custom.bot.Response.ChattingReaction;
import org.github.custom.bot.Response.DrawReaction;

import java.util.EnumSet;

public class DiscordBot {

    public static void main(String[] args) {

        BotTokenManager tokenManager = new BotTokenManager();
        String token = tokenManager.getDiscordBotToken();

        // Bot 권한부여
        EnumSet<GatewayIntent> intents = EnumSet.of(
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_VOICE_STATES);

        JDABuilder.createDefault(token)
                .enableIntents(intents)
                .setActivity(Activity.customStatus("명령어 대기중..."))
                .addEventListeners(new ChattingReaction())
                .addEventListeners(new DrawReaction())
                .build();
    }
}
