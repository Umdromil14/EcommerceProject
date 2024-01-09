package com.spring.henallux.firstSpringProject.JUnit;

import com.spring.henallux.firstSpringProject.dataAccess.dao.CategoriesTranslationDAO;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryTranslationEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.CategoriesTranslationRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.CategoryTranslation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class CategoryTranslationServicesTest {

    private CategoriesTranslationDAO categoriesTranslationDAO;

    @Mock
    private CategoriesTranslationRepository categoriesTranslationRepository;

    @BeforeEach
    void setUp() {
        categoriesTranslationDAO = new CategoriesTranslationDAO(categoriesTranslationRepository, new ProviderConverter());
    }

    @Test
    void getAllCategoriesByLanguage() {
        ArrayList<CategoryTranslationEntity> mockedCategoriesByLanguage = new ArrayList<>();
        mockedCategoriesByLanguage.add(new CategoryTranslationEntity(1,"EN","Beverages","Beverages"));
        mockedCategoriesByLanguage.add(new CategoryTranslationEntity(4,"EN","Office automation","Office automation"));
        mockedCategoriesByLanguage.add(new CategoryTranslationEntity(7,"EN","Snacks","Snacks"));
        mockedCategoriesByLanguage.add(new CategoryTranslationEntity(10,"EN","Construction","Construction"));
        mockedCategoriesByLanguage.add(new CategoryTranslationEntity(13,"EN","Furniture","Furniture"));
        when(categoriesTranslationRepository.findAllByLanguage("EN")).thenReturn(mockedCategoriesByLanguage);
        ArrayList<CategoryTranslation> resultsCategories = new ArrayList<>();
        resultsCategories.add(new CategoryTranslation(1,"EN","Beverages","Beverages"));
        resultsCategories.add(new CategoryTranslation(4,"EN","Office automation","Office automation"));
        resultsCategories.add(new CategoryTranslation(7,"EN","Snacks","Snacks"));
        resultsCategories.add(new CategoryTranslation(10,"EN","Construction","Construction"));
        resultsCategories.add(new CategoryTranslation(13,"EN","Furniture","Furniture"));
        ArrayList<CategoryTranslation> categories = categoriesTranslationDAO.findAllByLanguage("EN");
        for (int i = 0; i < categories.size(); i++) {
            assertThat(categories.get(i).getLanguage()).isEqualTo(resultsCategories.get(i).getLanguage());
            assertThat(categories.get(i).getCategory()).isEqualTo(resultsCategories.get(i).getCategory());
            assertThat(categories.get(i).getLabel()).isEqualTo(resultsCategories.get(i).getLabel());
        }

    }
}