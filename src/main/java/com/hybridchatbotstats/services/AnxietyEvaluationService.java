package com.hybridchatbotstats.services;

import com.hybridchatbotstats.models.AnxietyEvaluation;
import com.hybridchatbotstats.models.Result;
import com.hybridchatbotstats.repository.AnxietyEvaluationRepository;
import com.hybridchatbotstats.repository.NativeQueryRepository;
import com.hybridchatbotstats.repository.ResultRepository;
import com.hybridchatbotstats.request.AnxietyEvaluationRequest;
import com.hybridchatbotstats.response.BaseResponse;
import com.hybridchatbotstats.response.AverageStaticsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AnxietyEvaluationService {
    @Autowired
    AnxietyEvaluationRepository anxietyEvaluationRepository;

    @Autowired
    NativeQueryRepository nativeQueryRepository;

    @Autowired
    ResultRepository resultRepository;

    public BaseResponse<?> createAnxietyEvaluation(AnxietyEvaluationRequest anxietyEvaluationRequest) {
        AnxietyEvaluation newAnxietyEvaluation = new AnxietyEvaluation();
        Result newResult = resultRepository.getById(anxietyEvaluationRequest.getResultId());
        newResult.setId(anxietyEvaluationRequest.getResultId());
        newAnxietyEvaluation.setGrade(anxietyEvaluationRequest.getGrade());
        newAnxietyEvaluation.setCreateDate(LocalDateTime.now());
        newAnxietyEvaluation.setResult(newResult);
        newAnxietyEvaluation.setIsActive(1);
        anxietyEvaluationRepository.save(newAnxietyEvaluation);
        return  new BaseResponse<>(200, "Ok", Optional.of(newAnxietyEvaluation));
    }

    public BaseResponse<?> listEvaluationsByUserId(Integer userId){
        List<AnxietyEvaluation> data =  anxietyEvaluationRepository.findByUserIdAndIsActive(userId, 1);
        return new BaseResponse<>(200, "Ok", Optional.of(data));
    }

    public BaseResponse<?> listMonthGradeAvgGrade(Integer userId, String date){
        List<Object[]> data = nativeQueryRepository.averageMonthGradeEvaluation(userId, date);
        if (data.isEmpty()){
            throw new RuntimeException("No data found");
        }
        List<AverageStaticsResponse> dataCleaned = data.stream().map(x->new AverageStaticsResponse(((Date) x[0]).toLocalDate().atStartOfDay() ,(BigDecimal) x[1])).toList();
        return new BaseResponse<>(200, "Ok", Optional.of(dataCleaned));
    }

    public BaseResponse<?> listWeekGradeAvgGrade(Integer userId, String date){
        List<Object[]> data = nativeQueryRepository.averageWeekGradeEvaluation(userId, date);
        if (data.isEmpty()){
            throw new RuntimeException("No data found");
        }
        List<AverageStaticsResponse> dataCleaned = data.stream().map(x-> new AverageStaticsResponse(((Date) x[0]).toLocalDate().atStartOfDay() ,(BigDecimal) x[1])).toList();
        return new BaseResponse<>(200, "Ok", Optional.of(dataCleaned));
    }
}
