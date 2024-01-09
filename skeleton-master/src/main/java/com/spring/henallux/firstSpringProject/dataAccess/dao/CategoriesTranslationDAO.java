package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryTranslationEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.CategoriesTranslationRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.CategoryTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class CategoriesTranslationDAO implements CategoriesTranslationDataAccess {

    private CategoriesTranslationRepository categoriesRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategoriesTranslationDAO(CategoriesTranslationRepository categoriesRepository, ProviderConverter providerConverter){
        this.categoriesRepository = categoriesRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public ArrayList<CategoryTranslation> findAllByLanguage(String language) {
        ArrayList<CategoryTranslationEntity> categoryTranslationEntities = categoriesRepository.findAllByLanguage(language);
        ArrayList<CategoryTranslation> categories = new ArrayList<>();
        for(CategoryTranslationEntity categoryTranslationEntity : categoryTranslationEntities){
            CategoryTranslation categoryTranslation = providerConverter.categoryTranslationEntityToCategoryTranslationModel(categoryTranslationEntity);
            categories.add(categoryTranslation);
        }
        return categories;

    }


}
