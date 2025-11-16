package com.hybridchatbotstats.controllers;

import com.hybridchatbotstats.request.ConversationCloseRequest;
import com.hybridchatbotstats.response.BaseResponse;
import com.hybridchatbotstats.services.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conversation-evaluation")
public class ConversationController {
    @Autowired
    ConversationService conversationService;

    @PostMapping("/create-conversation/{id}")
    public ResponseEntity<?> createConversation(@PathVariable("id") Integer id){
        try {
            BaseResponse<?> conversationResponse = conversationService.createConversation(id);
            return ResponseEntity.ok().body(conversationResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/close-conversation")
    public ResponseEntity<?> closeConversation(@Validated @RequestBody ConversationCloseRequest conversationCloseRequest){
        try {
            BaseResponse<?> conversationResponse = conversationService.closeConversation(conversationCloseRequest);
            return ResponseEntity.ok().body(conversationResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete-conversation/{id}")
    public ResponseEntity<?> deleteConversation(@PathVariable("id") Integer id){
        try {
            BaseResponse<?> conversationResponse = conversationService.deleteConversation(id);
            return ResponseEntity.ok().body(conversationResponse);
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/list-month-grades")
    public ResponseEntity<?> listMonthGrades(@RequestParam Integer id, @RequestParam String date) {
        try {
            BaseResponse<?> data = conversationService.listMonthGradeAvgGrade(id, date);
            return ResponseEntity.ok().body(data);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/list-week-grades")
    public ResponseEntity<?> listWeekGrades(@RequestParam Integer id, @RequestParam String date) {
        try {
            BaseResponse<?> data = conversationService.listWeekGradeAvgGrade(id, date);
            return ResponseEntity.ok().body(data);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
