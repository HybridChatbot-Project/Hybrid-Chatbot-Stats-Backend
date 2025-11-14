package com.hybridchatbotstats.controllers;

import com.hybridchatbotstats.request.AnxietyEvaluationRequest;
import com.hybridchatbotstats.response.BaseResponse;
import com.hybridchatbotstats.services.AnxietyEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anxiety-evaluation")
public class AnxietyEvaluationController {
    @Autowired
    AnxietyEvaluationService anxietyEvaluationService;

    @PostMapping("/create-anxietyevaluation")
    public ResponseEntity<?> createAnxietyEvaluation(@Validated @RequestBody AnxietyEvaluationRequest anxietyEvaluationRequest) {
        try {
            BaseResponse<?> data =  anxietyEvaluationService.createAnxietyEvaluation(anxietyEvaluationRequest);
            return ResponseEntity.ok().body(data);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/list-by-user/{id}")
    public ResponseEntity<?> listEvaluationsByUserId (@PathVariable("id") Integer id){
        try {
            BaseResponse<?> listado =  anxietyEvaluationService.listEvaluationsByUserId(id);
            return ResponseEntity.ok().body(listado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/list-month-grades")
    public ResponseEntity<?> listMonthGrades(@RequestParam Integer id, @RequestParam String date){
        try {
          BaseResponse<?> info = anxietyEvaluationService.listMonthGradeAvgGrade(id, date);
          return ResponseEntity.ok().body(info);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/list-week-grades")
    public ResponseEntity<?> listWeekGrades(@RequestParam Integer id, @RequestParam String date){
        try {
            BaseResponse<?> info = anxietyEvaluationService.listWeekGradeAvgGrade(id, date);
            return ResponseEntity.ok().body(info);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
