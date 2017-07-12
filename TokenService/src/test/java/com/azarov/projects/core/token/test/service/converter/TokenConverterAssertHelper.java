package com.azarov.projects.core.token.test.service.converter;

import com.azarov.projects.core.token.datalayer.entity.TokenDataEntity;
import com.azarov.projects.core.token.service.TokenData;
import org.junit.Assert;

/**
 * Created by AzarovD on 24.08.2016.
 */

class TokenConverterAssertHelper {

    static void assertEquals(TokenDataEntity expectedEntity, TokenDataEntity tokenDataEntity) {
        Assert.assertNotNull(tokenDataEntity);
        Assert.assertEquals(expectedEntity.getAlias(), tokenDataEntity.getAlias());
        Assert.assertArrayEquals(expectedEntity.getData(), tokenDataEntity.getData());
        Assert.assertEquals(expectedEntity.getExpirationTime(), tokenDataEntity.getExpirationTime());
        Assert.assertEquals(expectedEntity.getId(), tokenDataEntity.getId());
        Assert.assertEquals(expectedEntity.isRemoveAfterExpiration(), tokenDataEntity.isRemoveAfterExpiration());
        Assert.assertEquals(expectedEntity.getStatus(), tokenDataEntity.getStatus());
    }

    static void assertEquals(TokenData expectedTokenData, TokenData tokenData) {
        Assert.assertNotNull(tokenData);
        Assert.assertEquals(expectedTokenData.getAlias(), tokenData.getAlias());
        Assert.assertEquals(expectedTokenData.getData(), tokenData.getData());
        Assert.assertEquals(expectedTokenData.getStatus(), tokenData.getStatus());
        Assert.assertEquals(expectedTokenData.getExpirationTime(), tokenData.getExpirationTime());
        Assert.assertEquals(expectedTokenData.getTokenId(), tokenData.getTokenId());
        Assert.assertEquals(expectedTokenData.isRemoveAfterExpiration(), tokenData.isRemoveAfterExpiration());

    }
}
