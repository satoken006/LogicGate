package com.example.logicgate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public enum GateProperty {
    AND((input1, input2)->{ return input1 && input2; }, 2),
    OR((input1, input2)->{ return input1 || input2; }, 2),
    NOT((input1, input2)->{ return !input1; }, 1);

    private BiPredicate<Boolean, Boolean> filter;

    private int numOfInputs;

    GateProperty(BiPredicate<Boolean, Boolean> filter, int numOfInputs){
        this.filter = filter;
        this.numOfInputs = numOfInputs;
    }

    public BiPredicate<Boolean, Boolean> getFilter(){
        Predicate<Boolean> a = (good)->{return !good;};
        return this.filter;
    }

    public int getNumOfInputs() {
        return this.numOfInputs;
    }
}
