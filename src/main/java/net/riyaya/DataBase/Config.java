package net.riyaya.DataBase;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.riyaya.Utils.Logger;

import java.nio.file.Paths;

public class Config {
    private static ObjectMapper mapper;
    private static String       json;
    private static JsonNode     jsonNode;
    private static ObjectNode   objectNode;

    private static String       token, prefix, avatarDir;
    private static int          maxAvatar, statusChangeDelaySec, avatarChangeDelaySec;
    private static String[]     statusActivity;


    public void load() {
        mapper = new ObjectMapper();
        try {
            json                = mapper.readTree(Paths.get("./config.json").toFile()).toString();
            jsonNode            = mapper.readTree(json);
            objectNode          = jsonNode.deepCopy();

            token               = objectNode.get("token").asText();
            prefix              = objectNode.get("prefix").asText();
            avatarDir           = objectNode.get("avatar_dir").asText();
            maxAvatar           = objectNode.get("max_avatar_num").asInt();
            statusChangeDelaySec= objectNode.get("status_change_delay_sec").asInt();
            avatarChangeDelaySec= objectNode.get("avatar_change_delay_sec").asInt();
            statusActivity      = jsonNode.get("status_activity").toString()
                                .replace("[", "")
                                .replace("]", "")
                                .replace('"' , ' ')
                                .replace(" ", "")
                                .replace("{help_command}", prefix + "help")
                                .split(",");
        }catch (Exception e) {
            Logger.warn(e.toString());
            Logger.warn("Couldn't load config.json");
        }
    }

    public void save() {
        try {
            mapper.writeValue(Paths.get("./config.json").toFile(), objectNode);
        }catch (Exception e) {
            Logger.warn("Couldn't save config.json");
        }
    }

    public String getBotToken() {
        Logger.info("The Bot Token is " + token);
        return token;
    }

    public String getPrefix() {
        return prefix;
    }

    public String[] getStatusActivity() {
        return statusActivity;
    }

    public String getAvatarDir() {
        return avatarDir;
    }

    public int getMaxAvatar() {
        return maxAvatar;
    }

    public int getStatusChangeDelaySec() {
        return statusChangeDelaySec;
    }

    public int getAvatarChangeDelaySec() {
        return avatarChangeDelaySec;
    }
}