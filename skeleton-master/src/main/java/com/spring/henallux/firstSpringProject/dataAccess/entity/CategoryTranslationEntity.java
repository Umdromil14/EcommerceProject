package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TRANSLATION")
public class CategoryTranslationEntity {

    @Id
    @Column(name="Id")
    private Integer id;

    @Column(name="Language")
    private String language;

    @Column(name="Label")
    private String label;

    @Column(name="category")
    private String category;

    public CategoryTranslationEntity() {
    }
    public CategoryTranslationEntity(Integer id, String language, String label, String category) {
        this.id = id;
        this.language = language;
        this.label = label;
        this.category = category;
    }

    //region Getters and Setters
    public String getLanguage() {
        return language;
    }

    public String getCategory() {
        return category;
    }

    public String getLabel() {
        return label;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    //endregion
}
