package com.hybridchatbotstats.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NativeQueryRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public List<Object[]> averageMonthGradeEvaluation(Integer id, String fechainicio) {
        String sql = "SELECT * FROM hybridchatbotstats.averageMonthGradeEvaluation(:id, :fechainicio)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("fechainicio", fechainicio);
        return query.getResultList();
    }

    @Transactional
    public List<Object[]> averageWeekGradeEvaluation(Integer id, String fechainicio) {
        String sql = "SELECT * FROM hybridchatbotstats.averageWeekGradeEvaluation(:id, :fechainicio)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("fechainicio", fechainicio);
        return query.getResultList();
    }

    @Transactional
    public List<Object[]> averageMonthGradeConversation(Integer id, String fechainicio) {
        String sql = "SELECT * FROM hybridchatbotstats.averageMonthGradeConversation(:id, :fechainicio)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("fechainicio", fechainicio);
        return query.getResultList();
    }

    @Transactional
    public List<Object[]> averageWeekGradeConversation(Integer id, String fechainicio) {
        String sql = "SELECT * FROM hybridchatbotstats.averageWeekGradeConversation(:id, :fechainicio)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("fechainicio", fechainicio);
        return query.getResultList();
    }
}
