package com.cuong02n.bprfl.network;

import com.google.gson.JsonObject;

public class JsonMaker {
    private JsonObject make(int pkgId, int errorCode) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", pkgId);
        jsonObject.addProperty("error", errorCode);
        return jsonObject;
    }
}
