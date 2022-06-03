package com.example.midas_task.repository;


import com.example.midas_task.pojo.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> , CustomTutorialRepository{
}
