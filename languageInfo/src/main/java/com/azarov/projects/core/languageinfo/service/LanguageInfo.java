package com.azarov.projects.core.languageinfo.service;

/**
 * Created by AzarovD on 25.08.2016.
 */

public class LanguageInfo {

    private int languageInfoId;
    private String nativeLanguage;
    private String taughtLanguage1;
    private String taughtLanguage2;
    private String taughtLanguage3;
    private String learningLanguage1;
    private String learningLanguage2;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguageInfo that = (LanguageInfo) o;

        if (languageInfoId != that.languageInfoId) return false;
        if (nativeLanguage != null ? !nativeLanguage.equals(that.nativeLanguage) : that.nativeLanguage != null)
            return false;
        if (taughtLanguage1 != null ? !taughtLanguage1.equals(that.taughtLanguage1) : that.taughtLanguage1 != null)
            return false;
        if (taughtLanguage2 != null ? !taughtLanguage2.equals(that.taughtLanguage2) : that.taughtLanguage2 != null)
            return false;
        if (taughtLanguage3 != null ? !taughtLanguage3.equals(that.taughtLanguage3) : that.taughtLanguage3 != null)
            return false;
        if (learningLanguage1 != null ? !learningLanguage1.equals(that.learningLanguage1) : that.learningLanguage1 != null)
            return false;
        if (learningLanguage2 != null ? !learningLanguage2.equals(that.learningLanguage2) : that.learningLanguage2 != null)
            return false;
        return learningLanguage3 != null ? learningLanguage3.equals(that.learningLanguage3) : that.learningLanguage3 == null;

    }

    @Override
    public int hashCode() {
        int result = languageInfoId;
        result = 31 * result + (nativeLanguage != null ? nativeLanguage.hashCode() : 0);
        result = 31 * result + (taughtLanguage1 != null ? taughtLanguage1.hashCode() : 0);
        result = 31 * result + (taughtLanguage2 != null ? taughtLanguage2.hashCode() : 0);
        result = 31 * result + (taughtLanguage3 != null ? taughtLanguage3.hashCode() : 0);
        result = 31 * result + (learningLanguage1 != null ? learningLanguage1.hashCode() : 0);
        result = 31 * result + (learningLanguage2 != null ? learningLanguage2.hashCode() : 0);
        result = 31 * result + (learningLanguage3 != null ? learningLanguage3.hashCode() : 0);
        return result;
    }
}

