package ru.antonenko.MySecondTestAppSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.antonenko.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.antonenko.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.antonenko.MySecondTestAppSpringBoot.model.Request;
import ru.antonenko.MySecondTestAppSpringBoot.model.Response;
import ru.antonenko.MySecondTestAppSpringBoot.service.UnsupportedCodeService;
import ru.antonenko.MySecondTestAppSpringBoot.service.ValidationService;

import javax.validation.Valid;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;

@RestController
public class MyController {

    private final ValidationService validationService;
    private final UnsupportedCodeService unsupportedCodeService;

    @Autowired
    public MyController(ValidationService validationService, UnsupportedCodeService unsupportedCodeService){
        this.validationService = validationService;
        this.unsupportedCodeService = unsupportedCodeService;
    }
    
    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();
        try {
            unsupportedCodeService.isValid(request.getUid());
        } catch (UnsupportedCodeException e) {
            response.setCode("failed");
            response.setErrorCode("UnsupportedCodeException");
            response.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            validationService.isValid(bindingResult);
        } catch (ValidationFailedException e){
            response.setCode("failed");
            response.setErrorCode("ValidationException");
            response.setErrorMessage("Ошибка валидации");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            response.setCode("failed");
            response.setErrorCode("UnknownException");
            response.setErrorMessage("Произошла непредвиденная ошибка");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}