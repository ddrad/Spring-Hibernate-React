package com.azarov.projects.core.token.test.service.converter;

import com.azarov.projects.core.token.datalayer.entity.TokenDataEntity;
import com.azarov.projects.core.token.service.TokenData;
import com.azarov.projects.core.token.service.TokenDataStatus;
import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by AzarovD on 24.08.2016.
 */

class TokenConverterFactory {

    static TokenData createTokenData() {
        TokenData tokenData = new TokenData();
        tokenData.setAlias("alias");
        tokenData.setData(1);
        tokenData.setExpirationTime(new DateTime(getDate()));
        tokenData.setStatus(TokenDataStatus.ACTIVE);
        tokenData.setRemoveAfterExpiration(true);
        tokenData.setTokenId(123123);
        return tokenData;
    }


    static TokenDataEntity createTokenDataEntity() {
        TokenDataEntity tokenDataEntity = new TokenDataEntity();
        tokenDataEntity.setAlias("alias");
        tokenDataEntity.setData(new byte[0]);
        tokenDataEntity.setExpirationTime(getDate());
        tokenDataEntity.setId(123123);
        tokenDataEntity.setStatus(TokenDataStatus.ACTIVE);
        tokenDataEntity.setRemoveAfterExpiration(true);
        return tokenDataEntity;
    }

    private static Date getDate() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2015);
        c.set(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR, 10);
        c.set(Calendar.MINUTE, 15);
        c.set(Calendar.SECOND, 20);
        c.set(Calendar.MILLISECOND, 100);
        return c.getTime();
    }

    static List<TokenDataEntity> createTokenDataEntities() {
        return Arrays.asList(createTokenDataEntity());
    }

    public static List<TokenData> createTokenDatas() {
        return Arrays.asList(createTokenData());
    }
}
