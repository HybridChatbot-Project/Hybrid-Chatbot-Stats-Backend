package com.hybridchatbotstats.controllers;

import com.hybridchatbotstats.response.BaseResponse;
import com.hybridchatbotstats.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping("/list")
    public ResponseEntity<?> listResults() {
        try {
            BaseResponse<?> listado = resultService.listResults();
            return ResponseEntity.ok().body(listado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
