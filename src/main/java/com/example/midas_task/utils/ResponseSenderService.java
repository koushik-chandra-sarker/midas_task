package com.example.midas_task.utils;

import com.example.midas_task.controller.GenericResponseREST;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class ResponseSenderService {

    public void ok(DeferredResult<ResponseEntity<GenericResponseREST>> result, String eTag) {
        ok(result, eTag, new GenericResponseREST());
    }

    public void ok(DeferredResult<ResponseEntity<GenericResponseREST>> result, String eTag, GenericResponseREST genericResponseREST) {
        genericResponseREST.message = "Success";
        ResponseEntity<GenericResponseREST> responseEntity = new ResponseEntity<>(genericResponseREST, HttpStatus.OK);
        result.setResult(responseEntity);
    }

    public void ok(DeferredResult<ResponseEntity<GenericResponseREST>> result, String eTag,
                   GenericResponseREST responseBody, HttpHeaders headers) {
        ResponseEntity<GenericResponseREST> response = new ResponseEntity<>(responseBody, headers, HttpStatus.OK);
        result.setResult(response);
    }



}
