package org.example.util.field;


public class RequestParameter {
    public RequestParameter(String clientFilterName, String value) {
        this.clientFilterName = clientFilterName;
        this.value = value;
    }

    public final String clientFilterName;
    public final String value;
}
