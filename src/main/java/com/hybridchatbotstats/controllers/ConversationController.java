package com.hybridchatbotstats.controllers;

import com.hybridchatbotstats.models.Conversation;
import com.hybridchatbotstats.request.ConversationRequest;
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

    @PostMapping("/create-conversation")
    public ResponseEntity<?> createConversation(@Validated @RequestBody ConversationRequest conversationRequest){
        try {
            BaseResponse<?> conversationResponse = conversationService.createConversation(conversationRequest);
            return ResponseEntity.ok().body(conversationResponse);
        } catch (Exception e) {
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
