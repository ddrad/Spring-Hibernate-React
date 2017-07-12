package com.azarov.projects.websocket.vo.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by AzarovD on 23.08.2016.
 */
public class DataSuccess extends Data {

    @JsonProperty("api_token")
    private String apiToken;
    @JsonProperty("api_token_expiration_date")
    private String apiTokenExpirationDate;

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getApiTokenExpirationDate() {
        return apiTokenExpirationDate;
    }

    public void setApiTokenExpirationDate(String apiTokenExpirationDate) {
        this.apiTokenExpirationDate = apiTokenExpirationDate;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataSuccess dataSuccess = (DataSuccess) o;

        if (apiToken != null ? !apiToken.equals(dataSuccess.apiToken) : dataSuccess.apiToken != null) return false;
        return apiTokenExpirationDate != null ? apiTokenExpirationDate.equals(dataSuccess.apiTokenExpirationDate) : dataSuccess.apiTokenExpirationDate == null;

    }

    @Override
    public int hashCode() {
        int result = apiToken != null ? apiToken.hashCode() : 0;
        result = 31 * result + (apiTokenExpirationDate != null ? apiTokenExpirationDate.hashCode() : 0);
        return result;
    }
}
