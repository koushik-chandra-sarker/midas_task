package com.example.midas_task.pojo.response;

import com.example.midas_task.controller.GenericResponseREST;
import com.example.midas_task.pojo.entity.Tutorial;

import java.util.ArrayList;
import java.util.List;

public class TutorialResponse extends GenericResponseREST {
    public List<TutorialIndividualResponse> tutorials;
    public TutorialResponse(List<Tutorial> tutorials) {
        this.tutorials = new ArrayList<>();
        for (Tutorial tutorial : tutorials) {
            this.tutorials.add(new TutorialIndividualResponse(tutorial));
        }
    }

    public TutorialResponse() {
        tutorials = new ArrayList<>();
    }
}
