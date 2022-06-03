package com.example.midas_task.controller;

import com.example.midas_task.pojo.request.TutorialRequest;

import com.example.midas_task.services.TutorialService;
import com.example.midas_task.utils.ResponseSenderService;
import com.example.midas_task.utils.SearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialRest {

    @Autowired
    ResponseSenderService responseSenderService;

    @Autowired
    TutorialService tutorialService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public DeferredResult<ResponseEntity<GenericResponseREST>> createTutorial(@RequestBody @Valid TutorialRequest tutorialRequest) throws InterruptedException {
        DeferredResult<ResponseEntity<GenericResponseREST>> deferredResult = new DeferredResult<>();
        tutorialService.createTutorial(tutorialRequest);
        responseSenderService.ok(deferredResult, "Tutorial created successfully");
        return deferredResult;
    }

//    get all tutorial

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public DeferredResult<ResponseEntity<GenericResponseREST>> getAllTutorial() {
        DeferredResult<ResponseEntity<GenericResponseREST>> deferredResult = new DeferredResult<>();
        responseSenderService.ok(deferredResult, "Tutorials fetched successfully", tutorialService.getAllTutorial());
        return deferredResult;
    }

//    get one tutorial

    @RequestMapping(value = {"/{id}", "/{id}/"}, method = RequestMethod.GET)
    public DeferredResult<ResponseEntity<GenericResponseREST>> getTutorial(@PathVariable Integer id) {
        DeferredResult<ResponseEntity<GenericResponseREST>> deferredResult = new DeferredResult<>();
        responseSenderService.ok(deferredResult, "Tutorial fetched successfully", tutorialService.getTutorial(id));
        return deferredResult;
    }

//    update tutorial

    @RequestMapping(value = {"/{id}", "/{id}/"}, method = RequestMethod.PUT)
    public DeferredResult<ResponseEntity<GenericResponseREST>> updateTutorial(@PathVariable Integer id, @RequestBody @Valid TutorialRequest tutorialRequest) throws IOException {
        DeferredResult<ResponseEntity<GenericResponseREST>> deferredResult = new DeferredResult<>();
        if (tutorialService.updateTutorial(id, tutorialRequest)) {
            responseSenderService.ok(deferredResult, "Tutorial updated successfully");
        } else {
            responseSenderService.ok(deferredResult, "Tutorial not found");
        }
        return deferredResult;
    }

//        delete tutorial

    @RequestMapping(value = {"/{id}", "/{id}/"}, method = RequestMethod.DELETE)
    public DeferredResult<ResponseEntity<GenericResponseREST>> deleteTutorial(@PathVariable Integer id) {
        DeferredResult<ResponseEntity<GenericResponseREST>> deferredResult = new DeferredResult<>();
        if (tutorialService.deleteTutorial(id)) {
            responseSenderService.ok(deferredResult, "Tutorial deleted successfully");
        } else {
            responseSenderService.ok(deferredResult, "Tutorial not found");
        }
        return deferredResult;
    }

//        delete all tutorial

    @RequestMapping(value = {"/", ""}, method = RequestMethod.DELETE)
    public DeferredResult<ResponseEntity<GenericResponseREST>> deleteAllTutorial() {
        DeferredResult<ResponseEntity<GenericResponseREST>> deferredResult = new DeferredResult<>();
        tutorialService.deleteAllTutorial();
        responseSenderService.ok(deferredResult, "Tutorials deleted successfully");
        return deferredResult;
    }


//        search tutorial by searchparma

        @RequestMapping(value = {"/search", "/search/"}, method = RequestMethod.GET)
        public DeferredResult<ResponseEntity<GenericResponseREST>> searchTutorial(SearchParams searchParam) {
            DeferredResult<ResponseEntity<GenericResponseREST>> deferredResult = new DeferredResult<>();
            responseSenderService.ok(deferredResult, "Tutorials fetched successfully", tutorialService.searchTutorial(searchParam));
            return deferredResult;
        }

}
