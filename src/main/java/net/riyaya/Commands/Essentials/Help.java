package net.riyaya.Commands.Essentials;

import net.riyaya.Commands.Command;
import net.riyaya.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;

public class Help implements Command {
    private final EmbedBuilder eb = new EmbedBuilder();

    @Override
    public void action(String[] args, MessageCreateEvent event) {
        if(args.length > 1) {

        }else {
            event.getMessage().getChannel().sendMessage(
                    eb.setColor(Color.cyan)
                            .addField("ヘルプ - カテゴリー一覧",
                                    """
                                            `bot` - botの情報を取得します
                                            `server` - サーバーの情報を取得します
                                            `search` - サーチしたものを取得します
                                            `test`""")
                            .setAuthor("RiyaBot")
            );
        }
    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public String description() {
        return "コマンド一覧を表示します";
    }
}
