package net.riyaya.Listener;

import net.riyaya.Commands.Essentials.Help;
import net.riyaya.DataBase.Config;
import net.riyaya.Main;

public class MessageCreateEvent {
    private static final Config config = Main.config;

    public static void onMessageCreateEvent(org.javacord.api.event.message.MessageCreateEvent event) {
        if(event.getMessageAuthor().isBotUser()) {
            return;
        }
        if(!event.getMessage().getContent().startsWith(config.getPrefix())) {
            return;
        }
        if(event.getMessage().isPrivateMessage()) {
            return;
        }

        String[] commands = event.getMessage().getContent().replace(config.getPrefix(), "").split(" ");

        switch (commands[0]) {
            case "help" -> new Help().action(commands, event);
            case "ping" -> event.getChannel().sendMessage(":ping_pong: ***Pong!***");
        }
    }
}
