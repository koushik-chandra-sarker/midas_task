package com.example.midas_task.services;

import com.example.midas_task.controller.GenericResponseREST;
import com.example.midas_task.pojo.entity.Tutorial;
import com.example.midas_task.pojo.request.TutorialRequest;
import com.example.midas_task.pojo.response.TutorialIndividualResponse;
import com.example.midas_task.pojo.response.TutorialResponse;
import com.example.midas_task.repository.TutorialRepository;
import com.example.midas_task.utils.SearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {
    @Autowired
    TutorialRepository tutorialRepository;

    public void createTutorial(TutorialRequest tutorialRequest) {
        Tutorial tutorial = new Tutorial(tutorialRequest);
        tutorialRepository.save(tutorial);
    }

    public TutorialResponse getAllTutorial() {
        List<Tutorial> tutorial = tutorialRepository.findAll();
        return new TutorialResponse(tutorial);
    }

    public TutorialIndividualResponse getTutorial(Integer id) {
        Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id);
        if (tutorialOptional.isPresent()) {
            Tutorial tutorial = tutorialOptional.get();
            return new TutorialIndividualResponse(tutorial);
        } else return new TutorialIndividualResponse();
    }

    public Boolean updateTutorial(Integer id, TutorialRequest tutorialRequest) {
        Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id);
        if (tutorialOptional.isPresent()) {
            Tutorial tutorial = tutorialOptional.get();
            tutorial.title = tutorialRequest.title;
            tutorial.description = tutorialRequest.description;
            tutorial.published = tutorialRequest.published;
            tutorialRepository.save(tutorial);
            return true;
        }
        return false;
    }

//    delete tutorial
    public Boolean deleteTutorial(Integer id) {
        Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id);
        if (tutorialOptional.isPresent()) {
            tutorialRepository.delete(tutorialOptional.get());
            return true;
        }
        return false;
    }

//    delete all tutorial
    public void deleteAllTutorial() {
        tutorialRepository.deleteAll();
    }

    public TutorialResponse searchTutorial(SearchParams searchParam) {
        List<Tutorial> tutorial = tutorialRepository.getTutorialBySearchParams(searchParam);

        if (tutorial.size() > 0) {
            return new TutorialResponse(tutorial);
        } else return new TutorialResponse();


    }

//    create criteria for search

}
