package net.riyaya.Listener;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.riyaya.Commands.Essentials.Help;
import net.riyaya.Commands.Essentials.Ping;
import net.riyaya.Commands.Essentials.Rate;
import net.riyaya.Commands.Image.*;
import net.riyaya.DataBase.Config;
import net.riyaya.Main;

public class MessageCreateEvent extends ListenerAdapter {
    private static final Config config = Main.config;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        if (!event.getMessage().getContentRaw().startsWith(config.getPrefix())) {
            return;
        }
        if (event.getChannel().getType().equals(ChannelType.PRIVATE)) {
            return;
        }
        if (Main.rate.getRate() >= Main.config.getMaxRate()) {
            event.getChannel().sendMessage("現在、コマンドの処理数が上限に達しました。しばらくしてから再度実行してください");
            return;
        }

        String[] commands = event.getMessage().getContentRaw().replace(config.getPrefix(), "").split(" ");

        Main.rate.setRate(Main.rate.getRate() + 1);

        switch (commands[0]) {
            case "help":
                new Help().action(commands, event);
                break;

            case "ping":
                new Ping().action(commands, event);
                break;

            case "rate":
                new Rate().action(commands, event);
                break;

            case "ecchi":
                new Ecchi().action(commands, event);
                break;

            case "ero":
                new Ero().action(commands, event);
                break;

            case "hentai":
                new Hentai().action(commands, event);
                break;

            case "maid":
                new Maid().action(commands, event);
                break;

            case "milf":
                new Milf().action(commands, event);
                break;

            case "oppai":
                new Oppai().action(commands, event);
                break;

            case "uniform":
                new Uniform().action(commands, event);
                break;

        }

        Main.rate.setRate(Main.rate.getRate() - 1);
    }
}
