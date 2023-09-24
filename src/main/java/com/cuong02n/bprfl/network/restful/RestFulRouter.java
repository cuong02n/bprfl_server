package com.cuong02n.bprfl.network.restful;

import com.cuong02n.bprfl.util.GsonUtil;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/bprfl/api")
public class RestFulRouter {

    @PostMapping("/register")
    public String register(@RequestBody String dataPrep) {
        JsonObject data = GsonUtil.fromJson(dataPrep, JsonObject.class);
        return "";
    }

    @PostMapping("/login")
    public String login(@RequestBody String dataPrep) {
        JsonObject data = GsonUtil.fromJson(dataPrep, JsonObject.class);
        return "";
    }

    // TODO
    @PostMapping("/get_quiz")
    public String getQuiz(@RequestBody String dataPrep) {
        JsonObject data = GsonUtil.fromJson(dataPrep, JsonObject.class);
    }
}
