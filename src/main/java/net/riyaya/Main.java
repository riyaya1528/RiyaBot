package net.riyaya;

import net.riyaya.DataBase.Config;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelMemberJoinEvent;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelMemberLeaveEvent;

import java.nio.charset.MalformedInputException;

public class Main {
    private static Config config;
    private static DiscordApi api;

    public static void main(String[] args) {

        config = new Config();
        config.load();

        api = new DiscordApiBuilder()
                .setToken(config.getBotToken())
                .login().join();

        api.addServerVoiceChannelMemberJoinListener(Main::MJL);
        api.addServerVoiceChannelMemberLeaveListener(Main::MLL);

    }

    private static void MJL(ServerVoiceChannelMemberJoinEvent event) {
        if(event.getUser().isBot()) {
            return;
        }
        if(!String.valueOf(event.getUser().getId()).equals("430337593561841674")) {
            return;
        }
        if (event.getChannel().isConnected(event.getApi().getClientId())) {
            return;
        }
        event.getChannel().connect().join();
    }

    private static void MLL(ServerVoiceChannelMemberLeaveEvent event) {
        if (event.getChannel().isConnected(event.getApi().getClientId())) {
            return;
        }
    }



}
