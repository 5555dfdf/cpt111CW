package controllers;

import xjtlu.cpt111.assignment.quiz.model.Option;
import xjtlu.cpt111.assignment.quiz.model.Question;
import xjtlu.cpt111.assignment.quiz.util.IOUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizController {
    private List<Question> questionslist = new ArrayList<>();

    private static final String RESOURCES_PATH = "src/main/resources/";
    private static final String QUESTIONS_BANK_PATH = "src\\resources\\questionsBank";


    public  void loadQuestions() {
        String filename = RESOURCES_PATH + "questions.xml";
        filename = QUESTIONS_BANK_PATH + "questions.xml";
        filename = QUESTIONS_BANK_PATH;


        try {
            System.out.println("===\n=== read questions - started\n===");
            Question[] questions = IOUtilities.readQuestions(filename);
            if (null == questions || questions.length == 0) {
                System.out.println("Questions is empty!");
            } else {
                int numQuestions = 0;
                for (Question question : questions) {
                    questionslist.add(question);
                    System.out.println("Question #" + (++numQuestions) + " " + question.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("===\n=== read questions - complete\n===");
        }

    }

    public void showMainMenu() {
        if (questionslist.isEmpty()) {
            System.out.println("无题库数据，请检查文件路径！");
            return;
        }

        System.out.println("1. 开始测验");
        System.out.println("2. 查看排行榜");
        System.out.println("请选择：");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            startQuiz();
        } else if (choice == 2) {
            showLeaderboard();
        } else {
            System.out.println("无效选择！");
        }
    }

    private void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int numQuestions = 0;

        for (Question question : questionslist) {
            System.out.println("问题 " + (++numQuestions) + ": " + question.getQuestionStatement());
            Option[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            int userAnswer = scanner.nextInt();
            if ((options[userAnswer - 1]).isCorrectAnswer()) {
                score++;
            }
        }
        System.out.println("测验完成！您的得分是：" + score);
    }

    private void showLeaderboard() {
        System.out.println("排行榜功能未实现！");
    }


}
