package ru.geekbrains.lesson_3;

import java.util.Random;
import java.util.Scanner;

/**
 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
 * "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
 * "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
 *
 * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
 * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
 * Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
 * apple – загаданное
 * apricot - ответ игрока
 * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
 * Для сравнения двух слов посимвольно, можно пользоваться:
 * String str = "apple";
 * str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
 * Играем до тех пор, пока игрок не отгадает слово
 * Используем только маленькие буквы
 */
class GuessGameTwo {

    GuessGameTwo() {
        startGame();
    }

    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
            "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private static String guessedWord;
    private static Scanner scanner = new Scanner(System.in);

    private static void startGame(){
        System.out.println("Угадайте загаданное слово!");
        guessedWord = words[new Random().nextInt(words.length)];
//        System.out.println(guessedWord);
        checkUserWord();
    }

    private static void checkUserWord(){
        String userWord = scanner.nextLine();
        compareWords(guessedWord, userWord);
    }
    private static void compareWords(String guessedWord, String userWord){
        if (guessedWord.equals(userWord)){
            System.out.println("Поздравляем, вы угадали!");
        } else {
            System.out.println("Неверно, повторите попытку!");
            createSharp(guessedWord, userWord);
        }
    }
    private static void createSharp(String guessedWord, String userWord){
        String[] sharp = {"#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"};
        for (int i = 0; i < guessedWord.length(); i++) {
            if (guessedWord.charAt(i) == userWord.charAt(i)) {
                sharp[i] = String.valueOf(userWord.charAt(i));
            }
        }
        for (int i = 0; i < sharp.length; i++) {
            System.out.print(sharp[i]);
        }

        System.out.println("");
        checkUserWord();
    }
}
