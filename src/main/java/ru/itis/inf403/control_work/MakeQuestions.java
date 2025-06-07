package ru.itis.inf403.control_work;

import java.io.*;

public class MakeQuestions {
    public static void main(String[] args) {
        Questions questions = new Questions();
        questions.question1 = "Сколько коров по полю бежало?";
        questions.response1 = new String[]{"4 коровы", "5 коров", "6 коров"};
        questions.goodResponseIndex1 = 1;

        questions.question2 = "Какая рыба в океане плавает быстрее всех?";
        questions.response2 = new String[]{"Парусник", "Рыба-меч", "Рыба-клоун"};
        questions.goodResponseIndex2 = 0;

        questions.question3 = "Каков ответ на \"Главный вопрос жизни, Вселенной и вообще\"?";
        questions.response3 = new String[]{"52", "228", "42"};
        questions.goodResponseIndex3 = 2;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("questions.bin"))) {
            oos.writeObject(questions);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
