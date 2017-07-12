package com.azarov.projects.core.token.test.service.util;

import com.azarov.projects.core.token.service.TokenData;
import com.azarov.projects.core.token.service.TokenDataStatus;
import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.List;

/**
 * Created by AzarovD on 24.08.2016.
 */

public class TokenServiceFactory {

    public static TokenData fullTokenData(DateTime dt) {
        TokenData tokenData = buildTokenData(dt);
        tokenData.setStatus(TokenDataStatus.ACTIVE);
        tokenData.setRemoveAfterExpiration(true);
        return tokenData;
    }

    public static TokenData buildTokenData(DateTime dt) {
        TokenData tokenData = buildTokenData();
        tokenData.setExpirationTime(dt);
        return tokenData;
    }

    public static TokenData buildTokenData() {
        TokenData tokenData = new TokenData();
        tokenData.setAlias("alias_0000000001");
        tokenData.setData("Привет всем!");
        return tokenData;
    }

    public static Parameters builDataSet() {
        return buildParameters("00000000000000000000000001", "00000000000000000000000002");
    }

    public static Parameters buildParameters(String arg1, String arg2) {
        Parameters parameters = new Parameters();

        Parameter data = new Parameter();
        data.setName("arg_1");
        data.setValue(arg1);

        Parameter data2 = new Parameter();
        data2.setName("arg_2");
        data2.setValue(arg2);

        parameters.getParameters().add(data);
        parameters.getParameters().add(data2);
        return parameters;
    }

    public static List<Integer> getTokenIds() {
        return Arrays.asList(buildTokenData().getTokenId());
    }

}
