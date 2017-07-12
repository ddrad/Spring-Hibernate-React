package com.azarov.projects.core.token.test.service;

import com.azarov.projects.core.token.datalayer.dao.TokenDataDao;
import com.azarov.projects.core.token.datalayer.entity.TokenDataEntity;
import com.azarov.projects.core.token.service.TokenData;
import com.azarov.projects.core.token.service.TokenDataStatus;
import com.azarov.projects.core.token.service.TokenService;
import com.azarov.projects.core.token.service.convert.TokenDataConverter;
import com.azarov.projects.core.token.service.error.Error;
import com.azarov.projects.core.token.service.impl.TokenServiceImpl;
import com.azarov.projects.core.token.service.util.KryoSerializer;
import com.azarov.projects.core.token.test.service.util.Parameters;
import com.azarov.projects.core.token.test.service.util.TokenServiceAssert;
import com.azarov.projects.core.token.test.service.util.TokenServiceFactory;
import com.google.common.base.Charsets;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by AzarovD on 24.08.2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class TokenServiceTest {

    @Mock
    private TokenDataDao tokenDataDao;

    private TokenDataConverter converter;
    private KryoSerializer serializer;
    private TokenService tokenService;

    private static final int TOKEN_ID = 123456789;
    private static final String ARGUMENT_1 = "000000000000000000000000001";
    private static final String ARGUMENT_2 = "000000000000000000000000002";
    private static final String ALIAS = "alias_0000000001";


    @Before
    public void init() {
        tokenService = new TokenServiceImpl();
        converter = new TokenDataConverter();
        serializer = new KryoSerializer();
        ReflectionTestUtils.setField(tokenService, "tokenDataDao", tokenDataDao);
        ReflectionTestUtils.setField(tokenService, "tokenDataConverter", converter);
        ReflectionTestUtils.setField(tokenService, "serializer", serializer);
        ReflectionTestUtils.setField(converter, "serializer", serializer);
    }

    @Test
    public void generateNewTokenService() {
        DateTime dt = DateTime.now().plusMinutes(30);
        TokenData tokenExpected = TokenServiceFactory.buildTokenData(dt);

        TokenDataEntity entity = converter.convertToEntity(tokenExpected);
        entity.setId(TOKEN_ID);

        String data = Base64.encode(entity.getData());
        when(tokenDataDao.findByAlias(anyString())).thenReturn(null);
        when(tokenDataDao.createTokenDataEntity(any(TokenDataEntity.class))).thenReturn(entity);

        TokenData tokenActual = tokenService.generateToken(ALIAS, TokenServiceFactory.builDataSet(), dt, true);
        TokenServiceAssert.assertEntitiesEquals(tokenExpected, tokenActual);
        TokenServiceAssert.assertTrackingEntities(tokenExpected.getData(), tokenActual.getData());
    }

    @Test
    public void testGenerateTokenWithEmptyAlias() {
        try {
            tokenService.generateToken("", null, null, true);
        } catch (RuntimeException e) {
            assertEquals(Error.ALIAS_IS_NULL.name(), e.getMessage());
        }
    }

    @Test
    public void updateExistTokenService() {
        DateTime dt = DateTime.now();

        TokenDataEntity entity = converter.convertToEntity(TokenServiceFactory.buildTokenData(dt));
        entity.setId(TOKEN_ID);

        TokenData tokenExpected = converter.convertFromEntity(entity);

        //change data
        Parameters newData = TokenServiceFactory.buildParameters(ARGUMENT_1, ARGUMENT_2);
        TokenData updToken = converter.convertFromEntity(entity);
        updToken.setData(newData);
        updToken.setExpirationTime(dt);
        TokenDataEntity updEntity = converter.convertToEntity(updToken);

        when(tokenDataDao.findByAlias(anyString())).thenReturn(entity);
        when(tokenDataDao.createTokenDataEntity(any(TokenDataEntity.class))).thenReturn(entity);
        when(tokenDataDao.updateTokenDataEntity(any(TokenDataEntity.class))).thenReturn(updEntity);

        TokenData tokenActual = tokenService.generateToken(ALIAS, newData, dt, true);

        TokenServiceAssert.assertEntitiesEquals(tokenExpected, tokenActual);
        TokenServiceAssert.failedAssertTrackingEntities(tokenExpected.getData(), tokenActual.getData());
    }


    @Test
    public void getTokenByIdTest() {
        DateTime dt = DateTime.now();
        TokenDataEntity entity = converter.convertToEntity(TokenServiceFactory.buildTokenData(dt));
        entity.setId(TOKEN_ID);

        when(tokenDataDao.findByAlias(anyString())).thenReturn(null);
        when(tokenDataDao.createTokenDataEntity(any(TokenDataEntity.class))).thenReturn(entity);
        when(tokenDataDao.findById(anyInt())).thenReturn(entity);

        TokenData newToken = tokenService.generateToken(ALIAS, TokenServiceFactory.builDataSet(), dt, true);
        TokenData tokenActual = tokenService.getTokenDataById(newToken.getTokenId());

        TokenData tokenExpected = converter.convertFromEntity(entity);
        TokenServiceAssert.assertEntitiesEquals(tokenExpected, tokenActual);
        TokenServiceAssert.assertTrackingEntities(tokenExpected.getData(), tokenActual.getData());
    }

    @Test
    public void testGetTokenDataByIdNull() {
        when(tokenDataDao.findById(anyInt())).thenReturn(null);
        try {
            tokenService.getTokenDataById(anyInt());
        } catch (RuntimeException e) {
            assertEquals(Error.TOKEN_DATA_IS_NOT_FOUND.name(), e.getMessage());
        }
    }

    @Test
    public void testRemoveTokenByAlias() {
        DateTime dt = DateTime.now();
        TokenData tokenExpected = TokenServiceFactory.buildTokenData(dt);
        tokenService.removeByAlias(tokenExpected.getAlias());
        verify(tokenDataDao).removeTokenDataByAlias(tokenExpected.getAlias());
    }

    @Test
    public void testRemoveByAliasNoEntity() {
        tokenService.removeByAlias("alias");
        verify(tokenDataDao).removeTokenDataByAlias("alias");
    }

    @Test
    public void testRemoveTokenById() {
        tokenService.removeById(TOKEN_ID);
        verify(tokenDataDao).removeTokenDataById(TOKEN_ID);
    }

    @Test
    public void testRemoveExpiredTokenData() {
        tokenService.removeExpiredTokenData();
        verify(tokenDataDao).removeExpiredTokenData();
    }

    @Test
    public void testUpdateTokenStatusForEmptyList() {
        tokenService.updateTokenStatus(Collections.<Integer>emptyList(), TokenDataStatus.EXPIRED);
        verify(tokenDataDao, times(0)).updateTokenDataEntities(anyList(), any(TokenDataStatus.class));
    }

    @Test
    public void testUpdateTokenStatus() {
        tokenService.updateTokenStatus(TokenServiceFactory.getTokenIds(), TokenDataStatus.EXPIRED);
        ArgumentCaptor<List> listCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<TokenDataStatus> typeCaptor = ArgumentCaptor.forClass(TokenDataStatus.class);
        verify(tokenDataDao).updateTokenDataEntities(listCaptor.capture(), typeCaptor.capture());
        assertEquals(1, listCaptor.getValue().size());
        assertEquals(TokenDataStatus.EXPIRED, typeCaptor.getValue());
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateMissingToken() {
        when(tokenDataDao.findById(anyInt())).thenReturn(null);
        tokenService.updateToken(new TokenData());
    }

    @Test
    public void testUpdateTokenData() {
        TokenDataEntity entity = new TokenDataEntity();
        TokenData tokenData = TokenServiceFactory.fullTokenData(DateTime.now());
        when(tokenDataDao.findById(anyInt())).thenReturn(entity);
        tokenService.updateToken(tokenData);
        assertTokensEqual(tokenData, entity);
    }

    private void assertTokensEqual(TokenData data, TokenDataEntity entity) {
        assertEquals(data.getAlias(), entity.getAlias());
        assertArraysEqual(serializer.serialize(data.getData()), entity.getData());
        assertEquals(data.getExpirationTime().toDate(), entity.getExpirationTime());
        assertEquals(data.getStatus(), entity.getStatus());
        assertEquals(data.getTokenId(), entity.getId());
    }

    private void assertArraysEqual(byte[] expected, byte[] actual) {
        String expectedData = new String(expected, Charsets.UTF_8);
        String actualData = new String(actual, Charsets.UTF_8);
        assertEquals(expectedData, actualData);
    }
}
