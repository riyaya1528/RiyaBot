package net.riyaya.Utils;

import net.riyaya.DataBase.Config;
import net.riyaya.Main;

public class MessageCreateEvent {
    private static final Config config = Main.config;

    public static void messageCreateEvent(org.javacord.api.event.message.MessageCreateEvent event) {
        if(event.getMessageAuthor().isBotUser()) {
            return;
        }
        if(!event.getMessage().getContent().startsWith(config.getPrefix())) {
            return;
        }

        String[] commands = event.getMessage().getContent().replace(config.getPrefix(), "").split(" ");

        switch (commands[0]) {
            case "help" -> event.getChannel().sendMessage("wakaranaidesu");
            case "ping" -> event.getChannel().sendMessage(":ping_pong: ***Pong!***");
        }
    }
}
