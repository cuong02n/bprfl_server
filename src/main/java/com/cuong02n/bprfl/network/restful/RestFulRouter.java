package com.cuong02n.bprfl.network.restful;

import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/bprfl")
public class RestFulRouter {

    @PostMapping("/register")
    public String register(JsonObject data) {
        return "";
    }



}
