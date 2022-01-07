package net.riyaya.Commands.Image;

import net.riyaya.Commands.Command;
import net.riyaya.DataBase.HTTP;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;

public class Oppai implements Command {

    @Override
    public void action(String[] args, MessageCreateEvent event) {
        HTTP http = new HTTP();
        event.getChannel().sendMessage(new EmbedBuilder().setColor(Color.PINK)
                .setImage(http.getImage("nsfw", "oppai")));
    }

    @Override
    public String description() {
        return "nsfwのoppaiの画像を取得します";
    }
}