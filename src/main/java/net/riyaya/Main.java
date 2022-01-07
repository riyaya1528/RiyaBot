

package net.riyaya;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.riyaya.DataBase.Config;
import net.riyaya.Listener.MessageCreateEvent;
import net.riyaya.Utils.Logger;

import java.util.Timer;

public class Main {
    public static Config                config;
    public static JDABuilder            jdaBuilder;
    public static JDA                   jda;
    private static final Timer          time = new Timer();

    public static void main(String[] args) {
        config = new Config();
        config.load();

        if(config.getBotToken().equals("TOKEN")) {
            Logger.warn("Please change bot token in config.json");
            System.exit(0);
        }

        try {
            jdaBuilder = JDABuilder.createDefault(config.getBotToken())
                    .setActivity(Activity.listening(config.getPrefix() + "helpでヘルプを表示"));
            jda = jdaBuilder.build();
            jda.awaitReady();
            Logger.info("Successfully login discord bot");
        } catch (Exception e) {
            Logger.warn("Couldn't login discord bot");
            Logger.warn("Bot Token was wrong?");
            System.exit(0);
        }
        addListener();
    }

    private static void addListener() {
        jda.addEventListener(new MessageCreateEvent());
    }
}
