package net.riyaya.Commands;

import org.javacord.api.event.message.MessageCreateEvent;

public interface Command {
    void action(String[] args, MessageCreateEvent event);
    String help();
    String description();
}
