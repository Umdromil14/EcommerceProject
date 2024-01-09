package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.CategoryTranslation;
import java.util.ArrayList;


public interface CategoriesTranslationDataAccess {

    ArrayList<CategoryTranslation> findAllByLanguage(String actualLanguage);
}
