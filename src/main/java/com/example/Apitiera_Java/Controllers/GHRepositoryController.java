package com.example.Apitiera_Java.Controllers;

import com.example.Apitiera_Java.Models.DTOs.ErrorResponse;
import com.example.Apitiera_Java.Models.DTOs.GHRepositoryResponse;
import com.example.Apitiera_Java.Services.GHRepositoryService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class GHRepositoryController {

    @Autowired
    GHRepositoryService ghRepositoryService;

    @GetMapping("/user/{username}")
    public ResponseEntity<?> GetUserRepositories(@PathVariable String username) {
        try {
            List<GHRepositoryResponse> repos =  ghRepositoryService.getAllGHRepository(username);
            return ResponseEntity.ok(repos);
        }catch (HttpClientErrorException e){
            e.printStackTrace();
            ErrorResponse err = new ErrorResponse(e.getStatusCode().value(),e.getMessage() );
            return ResponseEntity.status(e.getStatusCode()).body(err);
        }

    }

}
