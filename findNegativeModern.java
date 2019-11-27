package com.company.lesson6.homeworks;

import java.util.Random;
import java.util.Scanner;

public class findNegativeModern {

    //метод спрашивает хотите создать массив случайных чисел или ввести числа с клавиатуры
    public static String selectLoadArr() {
        System.out.println("Вы хотите создать массив случайных чисел или ввести числа с клавиатуры? Y/N");
        Scanner scanner = new Scanner(System.in);
        String change = scanner.next();
        return change;

    }


    public static int InputFirst() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Заполните массив случайными числами, укажите диапазон двумя числами!!");
        System.out.println("enter first number: ");
        int min = scanner.nextInt();
        return min;
    }

    public static int InputSecond() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter second number: ");
        int max = scanner.nextInt();
        return max;
    }

    public static int testInput(int min, int max) {
        int testOk = 0;
        if (min == -10 && max == 10) {
            testOk = 1;
        } else {
            testOk = 2;
        }
        return testOk;
    }

    //создание массива случайных чисел
    public static int[] loadArray(int min, int max) {
        Random random = new Random();
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {

            arr[i] = random.nextInt((max - min) + 1) + min;
            System.out.println((i + 1) + " item = " + arr[i]);
        }
        return arr;
    }

    // подсчет негативных чисел в массиве
    public static int countNegative(int arr[]) {
        int countNegative = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                countNegative++;

            }
        }
        return countNegative;
    }

    //    просмотр массива вывод индекса негативного числа
    public static int[] listArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 0) {
                System.out.print(i + ", ");
            }
        }
        return arr;
    }

    //    ввод массива с клавиатуры
    public static int[] loadArrFromScanner() {

        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Введиете " + (i + 1) + " 'элемет");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void showArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
    }

    public static void main(String[] args) {
//        запрос и ввод двух граничных чисел

//       вибор метода ввода массіва
        String change = findNegativeModern.selectLoadArr();

        switch (change) {
//  создание массива случайных чисел и просчет негативных чисел в массиве и вывод индексов негативных чисел
            case "y":
                int min = findNegativeModern.InputFirst();
                int max = findNegativeModern.InputSecond();
//        проверка на соответстие условию
                int StatusTest = findNegativeModern.testInput(min, max);
//        System.out.println(StatusTest);
//        создание массива в случае прохода теста либо вывод error message
                if (StatusTest == 1) {
                    int[] newArray1 = findNegativeModern.loadArray(min, max);
                    System.out.print("index of negative numbers: ");
                    int[] newArray2 = findNegativeModern.listArray(newArray1);
                    int countNegative = findNegativeModern.countNegative(newArray1);
                    System.out.println(" ");

                    System.out.println("Count of negative numbers =  " + countNegative);
                } else {
                    System.out.println("You enter wrong numbers");
                }
                break;
// создание массива чисел вручную
            case "n":
                int[] arrScanner = findNegativeModern.loadArrFromScanner();
                findNegativeModern.showArr(arrScanner);
                break;
            default:
                System.out.println("вы сделали неправильный выбор массив не будет создан");
        }


    }
}
