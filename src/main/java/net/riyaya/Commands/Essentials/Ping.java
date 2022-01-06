package net.riyaya.Commands.Essentials;

import net.riyaya.Commands.Command;
import org.javacord.api.event.message.MessageCreateEvent;

public class Ping implements Command {

    @Override
    public void action(String[] args, MessageCreateEvent event) {
        event.getChannel().sendMessage(":ping_pong: ***Pong!***");
    }

    @Override
    public String help() {
        return "pingをします";
    }

    @Override
    public String description() {
        return "pingをします";
    }
}
