package net.riyaya.Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Command {
    void action(String[] args, MessageReceivedEvent event);
    String description();
}
