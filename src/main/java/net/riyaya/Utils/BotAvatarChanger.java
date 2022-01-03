package net.riyaya.Utils;

import net.riyaya.DataBase.Config;
import net.riyaya.Main;

import java.io.File;
import java.util.TimerTask;

public class BotAvatarChanger extends TimerTask {
    private static int now = 0;
    private static final Config config = Main.config;

    public void run() {
        if(now == config.getMaxAvatar()) {
            now = 0;
        }
        try {
            File gif = new File(config.getAvatarDir().replace("{num}", String.valueOf(now)));
            Main.api.updateAvatar(gif);
        }catch (Exception e) {
            Logger.warn(e.toString());
        }
        now = now + 1;
    }
}
