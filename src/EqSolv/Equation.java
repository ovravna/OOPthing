package EqSolv;

//import java.util.*;

import java.util.ArrayList;

public class Equation {
    String variable;
    ArrayList<Integer> eqMatrix;

    public Equation(String variable) {
        this.variable = variable;
    }

    public Equation(String variable, int value) {
        this.variable = variable;
        System.out.println(value);
        this.eqMatrix.add(value);
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public void setEqMatrix(ArrayList<Integer> eqMatrix) {
        this.eqMatrix = eqMatrix;
    }

    public void setValue(int value) {
        this.eqMatrix.add(value);
    }

    public ArrayList<Integer> getEqMatrix() {
        return eqMatrix;
    }

    public String getVariable() {
        return variable;
    }
}
