package com.example.midas_task.pojo.entity;

import com.example.midas_task.pojo.request.TutorialRequest;

import javax.persistence.*;

@Entity
@Table(name = "tutorial")
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "title", nullable = false)
    public String title;

    @Column(name = "description", nullable = false)
    public String description;

    @Column(name = "published", nullable = false)
    public Boolean published;

    public Tutorial() {
    }
    public Tutorial(TutorialRequest tutorialRequest) {
        this.title = tutorialRequest.title;
        this.description = tutorialRequest.description;
        this.published = tutorialRequest.published;
    }
}
