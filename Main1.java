import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main1 {
    static int n1 = 0;
    static int n2 = 0;
    static int result = 0;
    static boolean isRoman = false;

    public static int operation(int n1, int n2, String typeOfOperation) throws Exception {
        return switch (typeOfOperation) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            default -> throw new Exception();
        };
    }

    public static void main(String[] args) {
        System.out.println("Введите математическое выражение");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        ArrayList<String> inputArray = new ArrayList<>(Arrays.asList(inputString.split(" ")));
        try {
            if (inputArray.toArray().length != 3) {
                throw new Exception("Неверное математическое выражение");
            }
        } catch (Exception e) {
            System.out.println("Неверная математическая операция");
            System.exit(-1);
        }

        try {
            n1 = parseInt(inputArray.get(0));
            n2 = parseInt(inputArray.get(2));
        } catch (NumberFormatException e) {
            try {
                isRoman = true;
                n1 = Converter.toArabic(inputArray.get(0));
                n2 = Converter.toArabic(inputArray.get(2));
            } catch (Exception e1) {
                System.out.println("Используются одновременно разные системы счисления");
                System.exit(-1);
            }
        }
        try {
            if (n1 < 0 || n1 > 10 || n2 < 0 || n2 > 10) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Значения должны быть от 1 до 10.");
            System.exit(-1);
        }

        try {
            result = operation(n1, n2, inputArray.get(1));
        } catch (Exception e) {
            System.out.println("Неверная математическая операция");
            System.exit(-1);
        }
        try {
            printResult(result);
        } catch (Exception e) {
            System.out.println("В римской системе нет отрицательных чисел");
            System.exit(-1);
        }

    }


    public static void printResult(Integer result) throws Exception {
        if (isRoman) {
            if (result > 0) {
                System.out.println(Converter.toRoman(result));
            } else {
                throw new Exception();
            }
        } else {
            System.out.println(result);
        }
    }


}
