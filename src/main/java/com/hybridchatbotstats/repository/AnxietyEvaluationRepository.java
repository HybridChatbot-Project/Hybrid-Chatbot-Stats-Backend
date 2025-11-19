package com.hybridchatbotstats.repository;

import com.hybridchatbotstats.models.AnxietyEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnxietyEvaluationRepository extends JpaRepository<AnxietyEvaluation,Integer> {
    List<AnxietyEvaluation> findByUserIdAndIsActive(Integer userId, Integer isActive);
}
