package com.example.logicgate;

import lombok.Data;

import java.util.function.BiPredicate;

@Data
public class Gate {

    private BiPredicate<Boolean, Boolean> filter;
    private boolean inputs[];
    private boolean output;

    public Gate(GateProperty property){
        this.filter = property.getFilter();
    }

    public void setInputs(boolean[] inputs) {
        this.inputs = inputs;
        this.calOutput();
    }

    public void calOutput(){
        this.output = this.filter.test(inputs[0], inputs[1]);
    }

    public boolean getOutput() {
        return output;
    }
}
