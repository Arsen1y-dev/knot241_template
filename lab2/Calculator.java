package lab2;

import java.util.Scanner;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Ошибка: Деление на ноль недопустимо.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("Введите первое число (или введите 'exit' для выхода): ");
            String input = sc.next();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из калькулятора. До свидания!");
                break;
            }

            double a = Double.parseDouble(input);

            System.out.println("Введите операцию (+, -, *, /): ");
            String operation = sc.next();

            System.out.println("Введите второе число: ");
            double b = sc.nextDouble();

            double result = 0;

            switch (operation) {
                case "+":
                    result = calculator.add(a, b);
                    break;
                case "-":
                    result = calculator.subtract(a, b);
                    break;
                case "*":
                    result = calculator.multiply(a, b);
                    break;
                case "/":
                    try {
                        result = calculator.divide(a, b);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
            }

            System.out.println("Результат: " + result);
        }

        sc.close();
    }
}