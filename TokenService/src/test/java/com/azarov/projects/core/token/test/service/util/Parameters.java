package com.azarov.projects.core.token.test.service.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzarovD on 24.08.2016.
 */
public class Parameters {
    private List<Parameter> parameters;

    public List<Parameter> getParameters() {
        if (parameters == null || parameters.isEmpty()) {
            parameters = new ArrayList<Parameter>();
        }
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}

class Parameter {
    private String name;
    private Object value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parameter parameter = (Parameter) o;

        if (name != null ? !name.equals(parameter.name) : parameter.name != null) return false;
        return value != null ? value.equals(parameter.value) : parameter.value == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}