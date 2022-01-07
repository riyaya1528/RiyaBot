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
            if(args[1].equals("bot")) {
                event.getMessage().getChannel().sendMessage(
                        eb.setColor(Color.cyan)
                                .addField("ヘルプ - botカテゴリ",
                                        """
                                                `help` - ヘルプを表示します
                                                `ping` - pingをします
                                                `rate` - 現在のコマンド処理数を取得します
                                                """)
                                .setAuthor("RiyaBot")
                );
            }else if(args[1].equals("image")) {
                event.getMessage().getChannel().sendMessage(
                        eb.setColor(Color.cyan)
                                .addField("ヘルプ - imageカテゴリ", "`ecchi` `ero` `hentai` `maid` `milf` `oppai` `uniform`")
                                .setAuthor("RiyaBot")
                );
            }else {
            }
        }else {
            event.getMessage().getChannel().sendMessage(
                    eb.setColor(Color.cyan)
                            .addField("ヘルプ - カテゴリー一覧",
                                    """
                                            `bot` - botの情報を取得します
                                            `image` - 画像等を取得します
                                            """)
                            .setAuthor("RiyaBot")
            );
        }
    }

    @Override
    public String description() {
        return "コマンド一覧を表示します";
    }
}
