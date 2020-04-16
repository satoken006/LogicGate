package com.example.logicgate;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Gate {

    private final GateProperty gateProperty;

    private final List<Signal> inputs;

    private Output output;

    private Gate(GateProperty gateProperty, List<Signal> inputs, Output output) {
        this.gateProperty = gateProperty;
        this.inputs = inputs;
        this.output = this.gateProperty.getFilter().apply(inputs);
    }

}
