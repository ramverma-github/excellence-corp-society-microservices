package com.excellence.society.corp.controlller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContributionController {

    @PostMapping("/contribution/add")
    public ResponseEntity<String> addContribution(@RequestBody String contributionData) {
        String response = "Hello";
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }
}
