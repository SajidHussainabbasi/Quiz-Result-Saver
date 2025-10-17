/*
🧠 Quiz Result Saver
Concepts: Writing & Reading, Exception Handling

Create a quiz program that:

Asks 5 multiple-choice questions.

Saves results to a file (results.txt) like:

User: Sam
Score: 4/5
Handle all file I/O exceptions gracefully.

Use try-with-resources for writing the results file.


 */
public class Main {
    public static void main(String[] args) {
        System.out.println("===== 🧠 QUIZ RESULT SAVER =====");
        System.out.println("Answer 5 questions and save your results!");
        System.out.println("==================================");

        Quiz quiz = new Quiz();
        quiz.startQuiz();

        System.out.println("👋 Thanks for playing!,Good Bye\nMade By Sajid Hussain");
    }
}
