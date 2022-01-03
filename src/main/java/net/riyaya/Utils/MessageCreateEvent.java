package net.riyaya.Utils;

import net.riyaya.DataBase.Config;
import net.riyaya.Main;

public class MessageCreateEvent {
    private static Config config = Main.config;
    private static String[] commands;

    public static void messageCreateEvent(org.javacord.api.event.message.MessageCreateEvent event) {
        if(event.getMessageAuthor().isBotUser()) {
            return;
        }
        if(!event.getMessage().getContent().startsWith(config.getPrefix())) {
            return;
        }
        commands = event.getMessage().getContent().replace(config.getPrefix(), "").split(" ");

        switch (commands[0]) {
            case "help":
                event.getChannel().sendMessage("wakaranaidesu");
                break;

            case "ping":
                event.getChannel().sendMessage(":ping_pong: ***Pong!***");
                break;
        }
    }
}
