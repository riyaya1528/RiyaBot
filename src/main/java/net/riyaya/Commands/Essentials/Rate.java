package net.riyaya.Commands.Essentials;

import net.riyaya.Commands.Command;
import net.riyaya.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Rate implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        final int ratePer = Main.rate.getRate() / Main.config.getMaxRate() * 100;
        if(ratePer < 25) {
            event.getChannel().sendMessage(":green_circle: 現在の処理数は" + Main.rate.getRate() + "です. 全体の" + ratePer + "%を消費しています.").queue();
        }else if(ratePer < 50) {
            event.getChannel().sendMessage(":orange_circle: 現在の処理数は" + Main.rate.getRate() + "です. 全体の" + ratePer + "%を消費しています.").queue();
        }else if(ratePer < 75) {
            event.getChannel().sendMessage(":red_circle: 現在の処理数は" + Main.rate.getRate() + "です. 全体の" + ratePer + "%を消費しています.").queue();
        }
    }

    @Override
    public String description() {
        return "現在処理してるコマンドの数を表示します";
    }
}
