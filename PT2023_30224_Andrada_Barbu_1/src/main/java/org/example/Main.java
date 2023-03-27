package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView(model);
        CalculatorController controller = new CalculatorController(model, view);
    }
}