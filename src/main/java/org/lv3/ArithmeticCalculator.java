package org.lv3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private List<Double> results = new ArrayList<>();
    private double num1;
    private double num2;
    private OperatorEnum operatorEnum;
    private double result;

    public double calculate() {
        if (operatorEnum.operatorChar == '+') {
            result = num1 + num2;
        } else if (operatorEnum.operatorChar == '-') {
            result = num1 - num2;
        } else if (operatorEnum.operatorChar == '*') {
            result = num1 * num2;
        } else if (operatorEnum.operatorChar == '/') {
            if (num2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                return result;
            }
            result = num1 / num2;
        } else {
            System.out.println("올바른 연산자가 아닙니다.");
            return result;
        }
        return result;
    }

    public void setResults(double result) { //리스트에 저장 븐리
        System.out.println("결과: " + result);
        results.add(result);
    }

    public void setOperator(char operator) {
        OperatorEnum foundOperator = null;
        for (OperatorEnum op : OperatorEnum.values()) {
            if (op.getOperatorChar() == operator) {
                foundOperator = op;
                break;
            }
        }
        this.operatorEnum = foundOperator;
    }

    public boolean isValidOperator() {
        return this.operatorEnum != null;
    }

    public List<Double> getResults() {
        return results;
    }

    public void setResults(List<Double> results) {
        this.results = results;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {

        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public char getOperator() {
        if (operatorEnum != null) {
            return operatorEnum.getOperatorChar();
        }
        throw new IllegalStateException("연산자가 설정되지 않았습니다.");
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
            System.out.println("가장 오래된 연산 결과가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 연산 결과가 없습니다.");
        }
    }
}
