package com.cuong02n.bprfl.mongodb;

import com.cuong02n.bprfl.util.FileUtil;
import com.cuong02n.bprfl.util.GsonUtil;
import com.google.gson.JsonObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnector {
    MongoClient client;
    MongoDatabase database;

    private MongoDBConnector(String filePath) {
        JsonObject data = GsonUtil.fromJson(FileUtil.getAllFile(filePath), JsonObject.class);
        String user = data.get("username").getAsString();
        String pass = data.get("password").getAsString();
        String host = data.get("host").getAsString();
        int port = data.get("port").getAsInt();
        String db = data.get("database").getAsString();

        client = MongoClients.create(String.format("mongodb://%s:%s@%s:%d", user, pass, host, port));
        database = client.getDatabase(db);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            client.close();
        }));
        database = client.getDatabase("bprfl");

    }

    public static void main(String[] args) {
        new MongoDBConnector("src/main/java/com/cuong02n/bprfl/mongodb/conf.json");
    }
}
