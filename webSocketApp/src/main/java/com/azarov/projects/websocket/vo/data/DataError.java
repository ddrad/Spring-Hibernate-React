package com.azarov.projects.websocket.vo.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by AzarovD on 23.08.2016.
 */

public class DataError extends Data {

    protected ErrorCode errorCode;
    private String errorDescription;

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataError dataError = (DataError) o;

        if (errorDescription != null ? !errorDescription.equals(dataError.errorDescription) : dataError.errorDescription != null)
            return false;
        return errorCode == dataError.errorCode;

    }

    @Override
    public int hashCode() {
        int result = errorDescription != null ? errorDescription.hashCode() : 0;
        result = 31 * result + (errorCode != null ? errorCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataError{" +
                "errorDescription='" + errorDescription + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}