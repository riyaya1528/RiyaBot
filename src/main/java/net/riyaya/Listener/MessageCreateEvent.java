package net.riyaya.Listener;

import net.riyaya.Commands.Essentials.Help;
import net.riyaya.Commands.Essentials.Ping;
import net.riyaya.Commands.Essentials.Rate;
import net.riyaya.Commands.Image.*;
import net.riyaya.DataBase.Config;
import net.riyaya.Main;

public class MessageCreateEvent {
    private static final Config config = Main.config;

    public static void onMessageCreateEvent(org.javacord.api.event.message.MessageCreateEvent event) {
        if(event.getMessageAuthor().isBotUser()) {
            return;
        }
        if(!event.getMessage().getContent().startsWith(config.getPrefix())) {
            return;
        }
        if(event.getMessage().isPrivateMessage()) {
            return;
        }
        if(Main.rate.getRate() >= Main.config.getMaxRate()) {
            event.getChannel().sendMessage("現在、コマンドの処理数が上限に達しました。しばらくしてから再度実行してください");
            return;
        }

        String[] commands = event.getMessage().getContent().replace(config.getPrefix(), "").split(" ");

        Main.rate.setRate(Main.rate.getRate() + 1);

        switch (commands[0]) {
            case "help"  -> new Help().action(commands, event);
            case "ping"  -> new Ping().action(commands, event);
            case "rate"  -> new Rate().action(commands, event);
            case "ecchi" -> new Ecchi().action(commands, event);
            case "ero" -> new Ero().action(commands, event);
            case "hentai" -> new Hentai().action(commands, event);
            case "maid" -> new Maid().action(commands, event);
            case "milf" -> new Milf().action(commands, event);
            case "oppai" -> new Oppai().action(commands, event);
            case "uniform" -> new Uniform().action(commands, event);
        }

        Main.rate.setRate(Main.rate.getRate() - 1);
    }
}
