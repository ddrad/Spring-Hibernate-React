package com.azarov.projects.core.languageinfo.datalayer.entity;

import javax.persistence.*;

/**
 * Created by AzarovD on 25.08.2016.
 */

@Entity
@Table(name = "language_info")
public class LanguageInfoEntity {
    @Id
    @Column(name = "language_info_id")
    @SequenceGenerator(name = "language_info_id_seq", sequenceName = "language_info_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language_info_id_seq")
    private int languageInfoId;

    @Column(name = "native", nullable = false)
    private String nativeLanguage;
    @Column(name = "taught_language_1", nullable = true)
    private String taughtLanguage1;
    @Column(name = "taught_language_2", nullable = true)
    private String taughtLanguage2;
    @Column(name = "taught_language_3", nullable = true)
    private String taughtLanguage3;
    @Column(name = "learning_language_1", nullable = true)
    private String learningLanguage1;
    @Column(name = "learning_language_2", nullable = true)
    private String learningLanguage2;
    @Column(name = "learning_language_3", nullable = true)
    private String learningLanguage3;

    public int getLanguageInfoId() {
        return languageInfoId;
    }

    public void setLanguageInfoId(int languageInfoId) {
        this.languageInfoId = languageInfoId;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public String getTaughtLanguage1() {
        return taughtLanguage1;
    }

    public void setTaughtLanguage1(String taughtLanguage1) {
        this.taughtLanguage1 = taughtLanguage1;
    }

    public String getTaughtLanguage2() {
        return taughtLanguage2;
    }

    public void setTaughtLanguage2(String taughtLanguage2) {
        this.taughtLanguage2 = taughtLanguage2;
    }

    public String getTaughtLanguage3() {
        return taughtLanguage3;
    }

    public void setTaughtLanguage3(String taughtLanguage3) {
        this.taughtLanguage3 = taughtLanguage3;
    }

    public String getLearningLanguage1() {
        return learningLanguage1;
    }

    public void setLearningLanguage1(String learningLanguage1) {
        this.learningLanguage1 = learningLanguage1;
    }

    public String getLearningLanguage2() {
        return learningLanguage2;
    }

    public void setLearningLanguage2(String learningLanguage2) {
        this.learningLanguage2 = learningLanguage2;
    }

    public String getLearningLanguage3() {
        return learningLanguage3;
    }

    public void setLearningLanguage3(String learningLanguage3) {
        this.learningLanguage3 = learningLanguage3;
    }
}

