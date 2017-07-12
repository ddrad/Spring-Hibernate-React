package com.azarov.projects.core.token.test.service.util;

import com.azarov.projects.core.token.service.TokenData;
import junit.framework.Assert;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by AzarovD on 24.08.2016.
 */

public class TokenServiceAssert {

    public static void assertEntitiesEquals(TokenData entityExpected, TokenData entityActual) {
        Assert.assertEquals(entityExpected.getAlias(), entityActual.getAlias());
        Assert.assertEquals(entityExpected.getExpirationTime(), entityActual.getExpirationTime());
    }

    public static void assertTrackingEntities(Object expectedObject, Object actualObject) {
        List<Parameter> expected = ((Parameters) expectedObject).getParameters();
        List<Parameter> actual = ((Parameters) actualObject).getParameters();
        for (Parameter entityExpected : expected) {
            boolean isFound = false;
            for (Parameter entityActual : actual) {
                if (entityExpected.getName().equals(entityActual.getName())) {
                    assertEquals(entityExpected.getValue(), entityActual.getValue());
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                throw new AssertionError();
            }
        }
    }

    public static void failedAssertTrackingEntities(Object expectedObject, Object actualObject) {
        List<Parameter> expected = ((Parameters) expectedObject).getParameters();
        List<Parameter> actual = ((Parameters) actualObject).getParameters();
        for (Parameter entityExpected : expected) {
            boolean isFound = false;
            for (Parameter entityActual : actual) {
                if (entityExpected.getName().equals(entityActual.getName())) {
                    assertFalse(entityExpected.getValue().equals(entityActual.getValue()));
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                throw new AssertionError();
            }
        }
    }

    public static void isTrue(boolean b) {
        Assert.assertTrue(b);
    }

}
