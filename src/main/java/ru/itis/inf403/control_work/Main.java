package ru.itis.inf403.control_work;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game();

        System.out.println("Введите своё имя: ");
        game.gamer = sc.next();
        Questions questions;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("questions.bin"))) {
            questions = (Questions) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int rating = 0;

        System.out.println(questions.question1);
        for (int i = 0; i < questions.response1.length; i++) {
            System.out.println((i+1) + ". " + questions.response1[i]);
        }
        int answer1 = sc.nextInt();
        if (answer1 == questions.goodResponseIndex1 + 1) rating++;

        System.out.println(questions.question2);
        for (int i = 0; i < questions.response2.length; i++) {
            System.out.println((i+1) + ". " + questions.response2[i]);
        }
        int answer2 = sc.nextInt();
        if (answer2 == questions.goodResponseIndex2 + 1) rating++;

        System.out.println(questions.question3);
        for (int i = 0; i < questions.response3.length; i++) {
            System.out.println((i+1) + ". " + questions.response3[i]);
        }
        int answer3 = sc.nextInt();
        if (answer3 == questions.goodResponseIndex3 + 1) rating++;

        game.rating = rating;
        game.gameDate = new Date();

        Rating allRating = new Rating();

        File file = new File("rating.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                allRating = (Rating) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        allRating.games.add(game);
        System.out.println("Отлично! Ваш результат: " + game.rating + ".");
        System.out.println("Вот так теперь выглядит таблица результатов:");

        allRating.games.stream().sorted().forEach(System.out::println);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("rating.bin"))) {
            oos.writeObject(allRating);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
