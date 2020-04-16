package com.example.logicgate;

import java.util.List;
import java.util.function.Function;

public enum GateProperty {

    AND((inputs) -> {
        return Output.of(inputs.get(0).getValue() && inputs.get(1).getValue());
    }, 2),

    OR((inputs) -> {
        return Output.of(inputs.get(0).getValue() || inputs.get(1).getValue());
    }, 2),

    NOT((inputs) -> {
        return Output.of(!inputs.get(0).getValue());
    }, 1);

    private final Function<List<Signal>, Output> filter;

    private final int numOfInputs;

    GateProperty(Function<List<Signal>, Output> filter, int numOfInputs) {
        this.filter = filter;
        this.numOfInputs = numOfInputs;
    }

    public Function<List<Signal>, Output> getFilter() {
        return this.filter;
    }

    public int getNumOfInputs() {
        return this.numOfInputs;
    }
}
