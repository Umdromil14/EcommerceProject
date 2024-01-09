package com.spring.henallux.firstSpringProject.model;

import java.io.Serializable;

public class CategoryTranslation {

    private Integer id;

    private String language;
    private String label;
    private String category;

    public CategoryTranslation() {
    }

    public CategoryTranslation(Integer id, String language, String label, String category) {
        this.id = id;
        this.language = language;
        this.label = label;
        this.category = category;
    }

    //region Getters and Setters

    public Integer getId() {
        return id;
    }
    public String getCategory() {
        return category;
    }

    public String getLabel() {
        return label;
    }

    public String getLanguage() {
        return language;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    //endregion
}
