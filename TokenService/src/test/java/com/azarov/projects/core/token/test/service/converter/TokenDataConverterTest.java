package com.azarov.projects.core.token.test.service.converter;

import com.azarov.projects.core.token.datalayer.entity.TokenDataEntity;
import com.azarov.projects.core.token.service.TokenData;
import com.azarov.projects.core.token.service.convert.TokenDataConverter;
import com.azarov.projects.core.token.service.util.KryoSerializer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by AzarovD on 24.08.2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class TokenDataConverterTest {

    @Mock
    private KryoSerializer serializer = mock(KryoSerializer.class);

    @InjectMocks
    private TokenDataConverter converter = new TokenDataConverter();

    @Test
    public void testConvertToEntity() throws Exception {
        when(serializer.serialize(anyObject())).thenReturn(new byte[0]);
        TokenDataEntity tokenDataEntity = converter.convertToEntity(TokenConverterFactory.createTokenData());
        TokenDataEntity expectedEntity = TokenConverterFactory.createTokenDataEntity();
        TokenConverterAssertHelper.assertEquals(expectedEntity, tokenDataEntity);
    }

    @Test
    public void testConvertFromEntity() throws Exception {
        when(serializer.deserialize(any(byte[].class))).thenReturn(1);
        TokenData tokenData = converter.convertFromEntity(TokenConverterFactory.createTokenDataEntity());
        TokenData expectedTokenData = TokenConverterFactory.createTokenData();
        TokenConverterAssertHelper.assertEquals(expectedTokenData, tokenData);
    }

    @Test
    public void testConvertFromEntities() {
        when(serializer.deserialize(any(byte[].class))).thenReturn(1);
        List<TokenData> tokenDatas = converter.convertFromEntities(TokenConverterFactory.createTokenDataEntities());
        Assert.assertEquals(1, tokenDatas.size());
    }

    @Test
    public void testConvertFromEntitiiesEmptyList() {
        Assert.assertTrue(converter.convertFromEntities(Collections.<TokenDataEntity>emptyList()).isEmpty());
    }

    @Test
    public void testConvertToEntities() {
        when(serializer.serialize(anyObject())).thenReturn(new byte[0]);
        List<TokenDataEntity> tokenDataEntities = converter.convertToEntities(TokenConverterFactory.createTokenDatas());
        Assert.assertEquals(1, tokenDataEntities.size());
    }
}