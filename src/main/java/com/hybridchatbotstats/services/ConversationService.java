package com.hybridchatbotstats.services;

import com.hybridchatbotstats.models.Conversation;
import com.hybridchatbotstats.repository.ConversationRepository;
import com.hybridchatbotstats.repository.NativeQueryRepository;
import com.hybridchatbotstats.request.ConversationCloseRequest;
import com.hybridchatbotstats.response.AverageStaticsResponse;
import com.hybridchatbotstats.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private NativeQueryRepository nativeQueryRepository;

    public BaseResponse<?> createConversation(Integer userId) {
        Conversation newConversation = new Conversation();
        newConversation.setUserId(userId);
        newConversation.setCreateDate(LocalDateTime.now());
        newConversation.setIsActive(1);
        newConversation.setIsClosed(false);
        conversationRepository.save(newConversation);
        return new BaseResponse<>(200, "Ok", Optional.of(newConversation));
    }

    public BaseResponse<?> closeConversation(ConversationCloseRequest conversationCloseRequest) {
        Conversation modified = conversationRepository.findById(conversationCloseRequest.getConversationId()).orElse(null);
        if (modified == null) {
            throw new RuntimeException("conversation not found");
        }
        modified.setIsClosed(true);
        modified.setUserComment(conversationCloseRequest.getUserComment());
        modified.setGrade(conversationCloseRequest.getGrade());
        conversationRepository.save(modified);
        return new BaseResponse<>(200, "Ok", Optional.of(modified));
    }

    public BaseResponse<?> deleteConversation(Integer conversationId) {
        conversationRepository.deleteById(conversationId);
        return new BaseResponse<>(200, "Ok", Optional.of("Borrado exitoso"));
    }

    public BaseResponse<?> listMonthGradeAvgGrade(Integer userId, String date){
        List<Object[]> data = nativeQueryRepository.averageMonthGradeConversation(userId, date);
        if (data.isEmpty()){
            throw new RuntimeException("No data found");
        }
        List<AverageStaticsResponse> dataCleaned = data.stream().map(x-> new AverageStaticsResponse(((Date) x[0]).toLocalDate().atStartOfDay(), (BigDecimal) x[1])).toList();
        return new BaseResponse<>(200, "Ok", Optional.of(dataCleaned));
    }

    public BaseResponse<?> listWeekGradeAvgGrade(Integer userId, String date){
        List<Object[]> data = nativeQueryRepository.averageWeekGradeConversation(userId, date);
        if (data.isEmpty()){
            throw new RuntimeException("No data found");
        }
        List<AverageStaticsResponse> dataCleaned = data.stream().map(x-> new AverageStaticsResponse(((Date) x[0]).toLocalDate().atStartOfDay(), (BigDecimal) x[1])).toList();
        return new BaseResponse<>(200, "Ok", Optional.of(dataCleaned));
    }
}
