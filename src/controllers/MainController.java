package controllers;

public class MainController {
    private UserController userController;
    private QuizController quizController;


    public MainController() {

        userController = new UserController();
        quizController = new QuizController();
    }

    public void start() {


        userController.loadUsers();
        quizController.loadQuestions();

        System.out.println("欢迎使用测验系统！");
        userController.login();
        quizController.showMainMenu();
    }
}
