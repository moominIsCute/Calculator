package org.lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        String state = "";

        while (!state.equals("exit")) {
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요:");
                try {
                    double inputNum1 = sc.nextDouble();
                    sc.nextLine();
                    if (inputNum1 < 0) {
                        System.out.println("양의 정수만 입력가능합니다.");
                    } else {
                        calculator.setNum1(inputNum1);
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("유효한 숫자를 입력해주세요. 문자를 입력할 수 없습니다.");
                    sc.nextLine();
                }
            }

            while (true) {
                System.out.print("사칙연산 기호를 입력하세요: ");
                char currentOperatorInput = sc.next().charAt(0);
                sc.nextLine();

                calculator.setOperator(currentOperatorInput);
                if (calculator.isValidOperator()) {
                    break;
                } else {
                    System.out.println("올바른 연산자를 입력해주세요.");
                }
            }

            while (true) {
                System.out.print("두 번째 숫자를 입력하세요:");
                try {
                    double inputNum2 = sc.nextDouble();
                    sc.nextLine();
                    if (inputNum2 < 0) {
                        System.out.println("양의 정수만 입력가능합니다.");
                    } else if (calculator.getOperator() == '/' && inputNum2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다. 숫자를 다시 입력하세요.");
                    } else {
                        calculator.setNum2(inputNum2);
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("유효한 숫자를 입력해주세요. 문자를 입력할 수 없습니다.");
                    sc.nextLine();
                }
            }


            double result = calculator.calculate();
            calculator.setResults(result);

            System.out.println("저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제를 할까요? (yes 입력시 삭제 그외 속행) ");
            String delete = sc.nextLine();
            //sc.nextLine();
            if (delete.equalsIgnoreCase("yes")) {
                calculator.removeResult();
                System.out.println("현재 저장된 결과: " + calculator.getResults());
            } else {
                System.out.println("현재 저장된 결과: " + calculator.getResults());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료 그외 속행)");
            state = sc.next();
            sc.nextLine();
        }
    }
}
