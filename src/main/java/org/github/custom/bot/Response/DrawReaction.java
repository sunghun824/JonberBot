package org.github.custom.bot.Response;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawReaction extends ListenerAdapter {

    private List<String> list = new ArrayList<>();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();

        if (message.startsWith("!add")) {
            // '!add 이름' 형식으로 입력받고 리스트에 추가
            String names = message.substring(5).trim();
            String[] namesArray = names.split(",");
            for (String name : namesArray) {
               list.add(name.trim());
                event.getChannel().sendMessage(name + "님이 명단에 추가되었습니다.").queue();
            }
        } else if (message.equals("!draw") || message.contains("?")) {
            // 명단에서 무작위로 한명을 선택
            if( list.isEmpty()) {
                event.getChannel().sendMessage("명단에 존재하는 사람이 없습니다.").queue();
            } else {
                Random rand = new Random();
                String selected = list.get(rand.nextInt(list.size()));
                event.getMessage().reply("당첨된 사람은 " + selected + "님 입니다.").queue();
            }
        } else if (message.equals("!reset")) {
            // 리스트 초기화
            list.clear();
            event.getChannel().sendMessage("명단이 초기화 되었습니다.").queue();
        }
    }
}
