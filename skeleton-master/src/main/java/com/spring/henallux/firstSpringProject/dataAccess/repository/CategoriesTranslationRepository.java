package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryTranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Locale;

@Repository
public interface CategoriesTranslationRepository extends JpaRepository<CategoryTranslationEntity, Integer> {

    ArrayList<CategoryTranslationEntity> findAllByLanguage(String language);
}
