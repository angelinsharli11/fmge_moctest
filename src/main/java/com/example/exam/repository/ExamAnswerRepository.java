package com.example.exam.repository;

import com.example.exam.model.ExamAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ExamAnswerRepository extends JpaRepository<ExamAnswer, Long> {

    @Modifying
    @Query("DELETE FROM ExamAnswer ea WHERE ea.examResult.exam.id = :examId")
    void deleteByExamId(@Param("examId") Long examId);
}