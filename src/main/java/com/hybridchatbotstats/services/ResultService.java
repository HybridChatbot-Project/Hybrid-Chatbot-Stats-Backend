package com.hybridchatbotstats.services;

import com.hybridchatbotstats.models.Result;
import com.hybridchatbotstats.repository.ResultRepository;
import com.hybridchatbotstats.response.BaseResponse;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public BaseResponse<?> listResults() {
        List<Result> data = resultRepository.findByIsActive(1);
        return new BaseResponse<>(200, "Ok", Optional.of(data));
    }
}
