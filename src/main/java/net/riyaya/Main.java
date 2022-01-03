package net.riyaya;

import net.riyaya.DataBase.Config;
import net.riyaya.Utils.BotAvatarChanger;
import net.riyaya.Utils.Logger;
import net.riyaya.Utils.MessageCreateEvent;
import net.riyaya.Utils.TextStatusChanger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.util.Timer;

public class Main {
    public  static Config       config;
    public  static DiscordApi   api;
    private static final Timer        time = new Timer();

    public static void main(String[] args) {

        config = new Config();
        config.load();

        try {
            api = new DiscordApiBuilder()
                    .setToken(config.getBotToken())
                    .login().join();
            Logger.info("Successfully login discord bot");
        } catch (Exception e) {
            Logger.warn("Couldn't login discord bot");
            Logger.warn("Bot Token was wrong?");
            System.exit(0);
        }

        time.scheduleAtFixedRate(new TextStatusChanger(), 3000, config.getStatusChangeDelaySec() * 1000);
        time.scheduleAtFixedRate(new BotAvatarChanger(), 3000, config.getAvatarChangeDelaySec() * 1000);
        api.addMessageCreateListener(MessageCreateEvent::messageCreateEvent);
    }
}
