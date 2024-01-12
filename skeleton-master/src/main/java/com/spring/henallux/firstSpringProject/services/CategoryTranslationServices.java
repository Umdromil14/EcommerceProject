package com.spring.henallux.firstSpringProject.services;

import com.spring.henallux.firstSpringProject.dataAccess.dao.CategoriesTranslationDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.CategoriesTranslationDataAccess;
import com.spring.henallux.firstSpringProject.model.CategoryTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryTranslationServices {

    private final CategoriesTranslationDataAccess CategoriesDAO;

    @Autowired
    public CategoryTranslationServices(CategoriesTranslationDAO CategoriesDAO){
        this.CategoriesDAO = CategoriesDAO;
    }

    public ArrayList<CategoryTranslation> getAllCategories(String actualLanguage){
        return CategoriesDAO.findAllByLanguage(actualLanguage);
    }
}
