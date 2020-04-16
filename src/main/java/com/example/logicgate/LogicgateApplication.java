package com.example.logicgate;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LogicgateApplication {

    public static void main(String[] args) {

        for (int i = 0; i < 16; i++) {

            boolean[] signals = new boolean[]{
                    (i / 8) % 2 == 1, // 今の段階では %2 は無くてもOK
                    (i / 4) % 2 == 1,
                    (i / 2) % 2 == 1,
                    i % 2 == 1
            };

            List<Signal> inputs1 = Arrays.asList(Input.of(signals[0]), Input.of(signals[1]));
            List<Signal> inputs2 = Arrays.asList(Input.of(signals[2]), Input.of(signals[3]));

            Gate gate1 = Gate.builder()
                    .gateProperty(GateProperty.AND)
                    .inputs(inputs1)
                    .build();

            Gate gate2 = Gate.builder()
                    .gateProperty(GateProperty.AND)
                    .inputs(inputs2)
                    .build();

            Gate gate3 = Gate.builder()
                    .gateProperty(GateProperty.OR)
                    .inputs(Arrays.asList(
                            gate1.getOutput(),
                            gate2.getOutput()
                    ))
                    .build();

            StringBuilder resultLog = new StringBuilder();

            for (boolean signal : signals) {
                String margin = signal ? "  |" : " |";
                resultLog.append(" ").append(signal).append(margin);
            }

            resultLog.append("| ").append(gate3.getOutput().getValue());
            System.out.println(resultLog);
        }

    }

}
