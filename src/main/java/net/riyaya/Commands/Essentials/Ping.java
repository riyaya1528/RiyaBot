package net.riyaya.Commands.Essentials;

import net.riyaya.Commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Ping implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getChannel().sendMessage(":ping_pong: ***Pong!***").queue();
    }

    @Override
    public String description() {
        return "pingをします";
    }
}
