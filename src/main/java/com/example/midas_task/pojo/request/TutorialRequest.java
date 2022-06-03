package com.example.midas_task.pojo.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TutorialRequest implements Serializable {

    @NotNull(message = "Title is required")
    public String title;

    public String description;

    @Min(value = 0, message = "Published must be 0 or 1")
    @Max(value = 1, message = "Published must be 0 or 1")
    public Boolean published;

}
