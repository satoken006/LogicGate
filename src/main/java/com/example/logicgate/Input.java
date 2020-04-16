package com.example.logicgate;

import lombok.Data;

@Data(staticConstructor = "of")
public class Input implements Signal{

    private final boolean value;

    public boolean getValue(){
        return this.value;
    }
}
