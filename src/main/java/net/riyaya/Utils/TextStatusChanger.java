package net.riyaya.Utils;

import net.dv8tion.jda.api.entities.Activity;
import net.riyaya.DataBase.Config;
import net.riyaya.Main;

import java.util.TimerTask;

public class TextStatusChanger extends TimerTask {
    private static int now = 0;
    private static final Config config = Main.config;

    public void run() {
        if(now == config.getStatusActivity().length) {
            now = 0;
        }
        Main.jdaBuilder.setActivity(Activity.of(Activity.ActivityType.LISTENING, config.getStatusActivity()[now]));
        now = now + 1;
    }
}
