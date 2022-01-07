package net.riyaya.Commands.Essentials;

import net.riyaya.Commands.Command;
import net.riyaya.Main;
import org.javacord.api.event.message.MessageCreateEvent;

public class Rate implements Command {

    @Override
    public void action(String[] args, MessageCreateEvent event) {
        final int ratePer = Main.rate.getRate() / Main.config.getMaxRate() * 100;
        if(ratePer < 25) {
            event.getChannel().sendMessage(":green_circle: 現在の処理数は" + Main.rate.getRate() + "です. 全体の" + ratePer + "%を消費しています.");
        }else if(ratePer < 50) {
            event.getChannel().sendMessage(":orange_circle: 現在の処理数は" + Main.rate.getRate() + "です. 全体の" + ratePer + "%を消費しています.");
        }else if(ratePer < 75) {
            event.getChannel().sendMessage(":red_circle: 現在の処理数は" + Main.rate.getRate() + "です. 全体の" + ratePer + "%を消費しています.");
        }
    }

    @Override
    public String description() {
        return "現在処理してるコマンドの数を表示します";
    }
}
