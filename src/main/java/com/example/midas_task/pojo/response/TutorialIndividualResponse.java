package com.example.midas_task.pojo.response;

import com.example.midas_task.controller.GenericResponseREST;
import com.example.midas_task.pojo.entity.Tutorial;

public class TutorialIndividualResponse extends GenericResponseREST {
    public Integer id;
    public String title;
    public String description;
    public Boolean published;

    public TutorialIndividualResponse() {
    }
    public TutorialIndividualResponse(Tutorial tutorial) {
        this.id = tutorial.id;
        this.title = tutorial.title;
        this.description = tutorial.description;
        this.published = tutorial.published;
    }
}
