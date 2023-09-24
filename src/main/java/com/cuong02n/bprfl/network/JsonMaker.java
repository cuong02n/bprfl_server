package com.cuong02n.bprfl.network;

import com.google.gson.JsonObject;

public class JsonMaker {
    private JsonObject make(int pkgId, int errorCode) {
        return make(pkgId, errorCode, "");
    }

    private JsonObject make(int pkgId, int errorCode, String errorMessage) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", pkgId);
        jsonObject.addProperty("error", errorCode);
        return jsonObject;
    }

    private JsonObject make(int pkgId, JsonObject data) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("pid", pkgId);
        jsonObject.add("data", data);
        return jsonObject;
    }
}
