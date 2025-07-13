package org.lv1;

import java.util.Scanner;

public class Main {
    //계산기 만들고 깃 하는 법을 익혔습니다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result;
        String state = "";

        while (!state.equals("exit")) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNumber = sc.nextInt();
            sc.nextLine();
            if (firstNumber < 0) {
                System.out.println("양의 정수만 입력가능합니다.");
                continue;
            }
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt();
            sc.nextLine();

            if (secondNumber < 0) {
                System.out.println("양의 정수만 입력가능합니다.");
                continue;
            }
            if (operator == '+') {
                result = firstNumber + secondNumber;
            } else if (operator == '-') {
                result = firstNumber - secondNumber;
            } else if (operator == '*') {
                result = firstNumber * secondNumber;
            } else if (operator == '/') {
                if (secondNumber == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    continue;
                }
                result = (double) firstNumber / secondNumber;
            } else {
                System.out.println("올바른 연산자를 입력해주세요.");
                continue;
            }
            System.out.println("결과: " + result);
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료 그외 속행)");
            state = sc.next();
        }
    }
}
