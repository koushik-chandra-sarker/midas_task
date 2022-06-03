package com.example.midas_task.repository;


import com.example.midas_task.pojo.entity.Tutorial;
import com.example.midas_task.utils.SearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class CustomTutorialRepositoryImpl implements CustomTutorialRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Tutorial> getTutorialBySearchParams(SearchParams searchParams) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Tutorial> query = cb.createQuery(Tutorial.class);
            // From
            Root<Tutorial> root = query.from(Tutorial.class);
            query.select(root);

            Predicate basePredicate = cb.conjunction();
            Predicate titlePredicate = cb.like(cb.lower(root.get("title")), "%" + searchParams.getTitle().trim().toLowerCase() + "%");
//            Predicate titlePredicate = cb.like(cb.lower(root.get("title")), "%" + "test-1" + "%");
            basePredicate = cb.and(basePredicate, titlePredicate);
            if (searchParams.published != null){
                basePredicate = cb.and(basePredicate, cb.equal(root.get("published"), searchParams.published));
            }


            query.where(basePredicate);

            List<Tutorial> result = entityManager.createQuery(query).getResultList();
            return result;


        } catch (Exception e) {
            throw e;
        }
    }
}
