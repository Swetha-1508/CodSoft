import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        String[] questions = {
            "1. Who invented Java Programming?",
            "2. Which component is used to compile, debug and execute the java programs?",
            "3. Which one of the following is not a Java feature?",
            "4. Which of these cannot be used for a variable name in Java?",
            "5.What is the extension of java code files?",
            "6. Which environment variable is used to set the java path?",
            "7. Which of the following is not an OOPS concept in Java?",
            "8.Which of the following is a type of polymorphism in Java Programming?",
            "9. What is Truncation in Java?",
            "10. Which exception is thrown when java is out of memory?"
        };

        String[][] options = {
            {"A) Guido van Rossum",
             "B) James Gosling",
             "C) Dennis Ritchie",
             "D) Bjarne Stroustrup"},

             {"A) JRE",
              "B) JIT",
              "C) JDK",
              "D) JVM"},

            {"A) Object-oriented",
              "B) Use of pointers",
              "C) Portable",
             "D) Dynamic and Extensible"},

             {"A) identifier & keyword",
              "B) identifier",
              "C) keyword",
              "D) none of the mentioned"},

              {
               "A) .js",
               "B) .txt",
                "C) .class",
                "D) .java"},

                {"A) MAVEN_Path",
                 "B) JavaPATH",
                 "C) JAVA",
                 "D) JAVA_HOME"},
              {
                "A) Polymorphism",
                "B) Inheritance",
                "C) Compilation",
                "D) Encapsulation"},

            {    "A) Multiple polymorphism",
                 "B) Compile time polymorphism",
                 "C) Multilevel polymorphism",
                 "D) Execution time polymorphism"},

            {    "A) Floating-point value assigned to a Floating type",
                 "B) Floating-point value assigned to an integer type",
                 "C) Integer value assigned to floating type",
                 "D) Integer value assigned to floating type"},

            {   "A) MemoryError",
                "B) OutOfMemoryError",
                "C) MemoryOutOfBoundsException",
                "D) MemoryFullException"
            }    
                 
        };

        int[] answers = {1, 2, 1,2,3,3,2,1,1,1};

        for (int i = 0; i < questions.length; i++) {
            displayQuestion(questions[i], options[i]);
            String userAnswer = getUserAnswer(scanner);
            int userChoice = getUserChoice(userAnswer);
            score += checkAnswer(userChoice, answers[i], options[i]);
        }

        displayFinalScore(score, questions.length);
        scanner.close();
    }

    // Function to display a question and its options
    public static void displayQuestion(String question, String[] options) {
        System.out.println(question);
        for (String option : options) {
            System.out.println(option);
        }
    }

    // Function to get the user's answer
    public static String getUserAnswer(Scanner scanner) {
        System.out.print("Enter the option (A, B, C, D): ");
        return scanner.nextLine().toUpperCase();
    }

    // Function to convert the user's answer to a choice index
    public static int getUserChoice(String userAnswer) {
        return userAnswer.charAt(0) - 'A';
    }

    // Function to check if the user's answer is correct and update the score
    public static int checkAnswer(int userChoice, int correctAnswer, String[] options) {
        if (userChoice == correctAnswer) {
            System.out.println("Correct!\n");
            return 1;
        } else {
            System.out.println("Incorrect. The correct answer is: " + options[correctAnswer] + "\n");
            return 0;
        }
    }

    // Function to display the final score
    public static void displayFinalScore(int score, int totalQuestions) {
        System.out.println("Quiz completed! Your score: " + score + "/" + totalQuestions);
    }
}
