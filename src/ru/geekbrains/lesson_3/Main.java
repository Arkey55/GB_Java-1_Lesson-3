package ru.geekbrains.lesson_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Выберите игру 1 или 2:");
        chooseGame();


    }
    static void chooseGame(){
        Scanner sc = new Scanner(System.in);
        int game = sc.nextInt();
        if (game == 1){
            new GuessGameOne();
        }
        else if(game == 2){
            new GuessGameTwo();
        } else {
            System.out.println("Такой игры нет, выберите 1 или 2:");
            chooseGame();
        }
    }
}
