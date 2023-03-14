package org.example;

import org.example.Trie.Trie;
import org.example.util.ConfigLoader;
import org.example.util.DataLoader;
import org.example.util.Timer;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        DataLoader dataLoader = new DataLoader();
        int searchedColumn = new ConfigLoader().getUserColumn(args);

        Trie trie = new Trie(dataLoader.getDataByColumn(searchedColumn));

        String userRequest = getUserRequest();
        while(!(userRequest.equals("!quit"))) {

            Timer timer = new Timer();
            timer.start();

            List<String> trieSuggest = trie.suggest(userRequest);
            timer.stop();

            if(!trieSuggest.isEmpty()) {
                for (String line : trieSuggest) {
                    System.out.println(line);
                }
                System.out.println("--------------------------");
                System.out.println("Количество совпадений: " + (trieSuggest.size()));
                System.out.println("Времени на поиск потрачено: " + (timer.getRangeTime()) + "мс");
                System.out.println("--------------------------");
            }
            else {
                System.out.println("Совпадений не найдено");
            }
            userRequest = getUserRequest();
        }
        System.exit(0);
    }

    static String getUserRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку или !quit, чтобы выйти");
        String input = scanner.nextLine();
        while (input.isEmpty()) {
            System.out.println("Пустой запрос");
            input = scanner.nextLine();
        }
        return input;
    }
}