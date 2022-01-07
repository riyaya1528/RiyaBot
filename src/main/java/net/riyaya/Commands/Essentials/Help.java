package net.riyaya.Commands.Essentials;

import net.dv8tion.jda.api.EmbedBuilder;
import net.riyaya.Commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class Help implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
            event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                    .setColor(Color.cyan)
                    .addField("ヘルプ",
                            "\nbotカテゴリ" +
                                    "\n`help` `ping`" +
                                    "\n" +
                                    "\nimageカテゴリ" +
                                    "\n`ass` `ecchi` `ero` `hentai` `maid`" +
                                    "\n`milf` `oppai` `uniform` `oral` `paizuri`" +
                                    "\n`selfies` `waifu`"
                            ,
                            true)
                    .setAuthor("RiyaBot")
                    .build()
            ).queue();
    }

    @Override
    public String description() {
        return "コマンド一覧を表示します";
    }
}
