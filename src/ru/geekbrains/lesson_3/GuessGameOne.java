package ru.geekbrains.lesson_3;

import java.util.Random;
import java.util.Scanner;

/**
 * Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
 * При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
 * После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */

class GuessGameOne {

    GuessGameOne(){
        startGame();
    }

    private static Scanner scanner = new Scanner(System.in);
    private static int count;
    private static int guessNumber;
    private static int userGuess;

    private static void startGame(){
        count = 3;
        guessNumber = new Random().nextInt(10);
        System.out.println("Угадайте число от 0 до 9, у Вас 3 попытки!");
        checkUserGuess();
    }

    private static void checkUserGuess(){
        userGuess = scanner.nextInt();
        compareNumber();
    }

    private static void compareNumber(){
        if(userGuess > guessNumber){
            System.out.println("Меньше!");
            count--;
            checkCount();
            checkUserGuess();
        } else if (userGuess < guessNumber){
            System.out.println("Больше!");
            count--;
            checkCount();
            checkUserGuess();
        } else {
            System.out.println("Поздравляем, Вы угадали!");
        }
    }
    private static void checkCount(){
        if (count == 0){
            System.out.println("Попытки закончились. Повторить игру? \n1 - да / 0 - нет");
            Scanner sc = new Scanner(System.in);
            int userAnswer = sc.nextInt();
            if (userAnswer == 1){
                startGame();
            } else {
                System.out.println("Удачи в следующий раз!");
                System.exit(0);
            }
        }
    }
}
