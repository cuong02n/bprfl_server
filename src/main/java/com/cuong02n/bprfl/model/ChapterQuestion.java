package com.cuong02n.bprfl.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ChapterQuestion {
    final int chapter;
    final String question;
    final String[] answer;
    final int trueAnswerIndex;

    public ChapterQuestion(JsonObject jsonObject) {
        this.question = jsonObject.get("question").getAsString();
        JsonArray arr = jsonObject.get("answer").getAsJsonArray();
        this.chapter = jsonObject.get("chapter").getAsInt();
        answer = new String[arr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i).getAsString();
        }
        this.trueAnswerIndex = jsonObject.get("true_ans").getAsInt();
    }
}
