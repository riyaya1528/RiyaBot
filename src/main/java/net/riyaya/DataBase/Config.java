package net.riyaya.DataBase;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.riyaya.Utils.Logger;

import javax.security.auth.login.LoginException;
import java.nio.file.Paths;

public class Config {
    private static ObjectMapper mapper;
    private static String json;
    private static JsonNode jsonNode;
    private static ObjectNode objectNode;


    public void load() {
        mapper = new ObjectMapper();
        try {
            json = mapper.readTree(Paths.get("./config.json").toFile()).toString();
            jsonNode = mapper.readTree(json);
            objectNode = jsonNode.deepCopy();
        }catch (Exception e) {
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

    public void putInt(String path, int value) {
        objectNode.put(path, value);
    }

    public void putString(String path, String value) {
        objectNode.put(path, value);
    }

    public String getBotToken() {
        String token = objectNode.get("token").toString();
        token = token.substring(0, token.length()-1);
        token = token.substring(1);
        Logger.info(token);
        return token;
    }

    public JsonNode getConfig() {
        return jsonNode;
    }
}
