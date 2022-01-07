

package net.riyaya;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.riyaya.DataBase.Config;
import net.riyaya.DataBase.Rate;
import net.riyaya.Listener.MessageCreateEvent;
import net.riyaya.Utils.Logger;
import net.riyaya.Utils.TextStatusChanger;

import java.util.Timer;

public class Main {
    public static Config                config;
    public static JDABuilder            jdaBuilder;
    public static JDA                   jda;
    public static Rate                  rate;
    private static final Timer          time = new Timer();

    public static void main(String[] args) {
        config = new Config();
        config.load();

        rate = new Rate();
        rate.setRate(0);

        try {
            jdaBuilder = JDABuilder.createDefault(config.getBotToken());
            jda = jdaBuilder.build();
            jda.awaitReady();
            Logger.info("Successfully login discord bot");
        } catch (Exception e) {
            Logger.warn("Couldn't login discord bot");
            Logger.warn("Bot Token was wrong?");
            System.exit(0);
        }

        time.scheduleAtFixedRate(new TextStatusChanger(), 3000, config.getStatusChangeDelaySec() * 1000);
        addListener();
    }

    private static void addListener() {
        jda.addEventListener(new MessageCreateEvent());
    }
}
