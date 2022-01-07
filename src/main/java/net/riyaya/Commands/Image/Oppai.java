package net.riyaya.Commands.Image;

import net.dv8tion.jda.api.EmbedBuilder;
import net.riyaya.Commands.Command;
import net.riyaya.DataBase.HTTP;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class Oppai implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        HTTP http = new HTTP();
        event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                .setColor(Color.PINK).setImage(http.getImage("nsfw", "oppai"))
                .build()
        ).queue();
    }

    @Override
    public String description() {
        return "nsfwのoppaiの画像を取得します";
    }
}