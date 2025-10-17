/*
🧠 Quiz Result Saver with Menu
Concepts: Writing & Reading, Exception Handling

Features:
- 5 Multiple-choice questions
- Saves results to results.txt
- Lets user view all saved results
- Graceful file I/O exception handling
- Uses try-with-resources
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("===== 🧠 QUIZ RESULT SAVER =====");
        System.out.println("Answer 5 questions and save your results!");
        System.out.println("==================================");

        Quiz quiz = new Quiz();
        quiz.displayMenu(); // 👈 Main menu: Start / View Results / Exit

        System.out.println("👋 Thanks for playing! ");
        System.out.println("   Made by Sajid Hussain ❤️");
    }
}
