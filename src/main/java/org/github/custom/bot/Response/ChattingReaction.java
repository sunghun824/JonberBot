package org.github.custom.bot.Response;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;
import java.util.Map;

public class ChattingReaction extends ListenerAdapter {

    private final Map<String, String> responses;

    public ChattingReaction() {
        responses = new HashMap<>();
        responses.put("강동완","바보!");
        responses.put("최현빈", "멍청이!");
        responses.put("김재현", "바보!");
        responses.put("강동우", "멍청이!");
        responses.put("이주형", "바보!");
        responses.put("대답", "Reply!");
        responses.put("reply", "Reply!");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();

        if (responses.containsKey(message)) {
            String response = responses.get(message);
            event.getChannel().sendMessage(response).queue();
        }
    }
}
