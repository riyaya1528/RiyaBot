package net.riyaya.Commands.Essentials;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.riyaya.Commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.riyaya.Main;

import java.awt.*;

public class Help implements Command {
    private final EmbedBuilder eb = new EmbedBuilder();

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(args.length > 1) {
            if(args[1].equals("bot")) {
                event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                        .setColor(Color.cyan)
                        .addField("ヘルプ - botカテゴリ",
                        "`help` - ヘルプを表示します" +
                                "\n`ping` - pingをします",
                                true)
                        .setAuthor("RiyaBot")
                        .build()
                ).queue();
            }else if(args[1].equals("image")) {
                event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                        .setColor(Color.cyan)
                        .addField("ヘルプ - imageカテゴリ",
                                "`ass` `ecchi` `ero` `hentai` `maid` `milf` `oppai` `uniform`",
                                true)
                        .setAuthor("RiyaBot")
                        .build()
                ).queue();
            }else {
            }
        }else {
            event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                    .setColor(Color.cyan)
                    .addField("ヘルプ - カテゴリー一覧",
                              "`"+ Main.config.getPrefix() + "help (カテゴリ)`" +
                                    "\n" +
                                    "\n`bot` - botの情報を取得します" +
                                    "\n`image` - 画像等を取得します",
                            true)
                    .setAuthor("RiyaBot")
                    .build()
            ).queue();
        }
    }

    @Override
    public String description() {
        return "コマンド一覧を表示します";
    }
}
