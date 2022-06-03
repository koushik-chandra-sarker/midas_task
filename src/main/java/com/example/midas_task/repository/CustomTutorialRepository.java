package com.example.midas_task.repository;


import com.example.midas_task.pojo.entity.Tutorial;
import com.example.midas_task.utils.SearchParams;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomTutorialRepository{

    List<Tutorial> getTutorialBySearchParams(SearchParams searchParams);
}
