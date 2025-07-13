package org.lv3;

public enum OperatorEnum {
    ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/');

    final char operatorChar;

    OperatorEnum(char operatorChar) {
        this.operatorChar = operatorChar;
    }

    char getOperatorChar() {
        return operatorChar;
    }
}
