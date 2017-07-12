package com.azarov.projects.core.languageinfo.service.convert;

import com.azarov.projects.core.languageinfo.datalayer.entity.LanguageInfoEntity;
import com.azarov.projects.core.languageinfo.service.LanguageInfo;
import org.springframework.stereotype.Service;

/**
 * Created by AzarovD on 25.08.2016.
 */

@Service("languageInfoConvert")
public class LanguageInfoConvert {

    public LanguageInfo toLanguageInfo(LanguageInfoEntity entity) {
        LanguageInfo languageInfo = new LanguageInfo();
        languageInfo.setLanguageInfoId(entity.getLanguageInfoId());
        languageInfo.setNativeLanguage(entity.getNativeLanguage());
        languageInfo.setTaughtLanguage1(entity.getTaughtLanguage1());
        languageInfo.setTaughtLanguage2(entity.getTaughtLanguage2());
        languageInfo.setTaughtLanguage3(entity.getTaughtLanguage3());
        languageInfo.setLearningLanguage1(entity.getLearningLanguage1());
        languageInfo.setLearningLanguage2(entity.getLearningLanguage2());
        languageInfo.setLearningLanguage3(entity.getLearningLanguage3());
        return languageInfo;
    }

    public LanguageInfoEntity toLanguageInfoEntity(LanguageInfo languageInfo) {
        LanguageInfoEntity infoEntity = new LanguageInfoEntity();
        infoEntity.setLanguageInfoId(languageInfo.getLanguageInfoId());
        infoEntity.setNativeLanguage(languageInfo.getNativeLanguage());
        infoEntity.setTaughtLanguage1(languageInfo.getTaughtLanguage1());
        infoEntity.setTaughtLanguage2(languageInfo.getTaughtLanguage2());
        infoEntity.setTaughtLanguage3(languageInfo.getTaughtLanguage3());
        infoEntity.setLearningLanguage1(languageInfo.getLearningLanguage1());
        infoEntity.setLearningLanguage2(languageInfo.getLearningLanguage2());
        infoEntity.setLearningLanguage3(languageInfo.getLearningLanguage3());
        return infoEntity;
    }
}
