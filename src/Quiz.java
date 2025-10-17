import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Quiz {
    private Question[] questions;
    private int score = 0;
    private String userName;

    public Quiz() {
        // Initialize 5 sample questions
        questions = new Question[] {
                new Question("1️⃣ What is the capital of France?",
                        new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 'C'),
                new Question("2️⃣ Which planet is known as the Red Planet?",
                        new String[]{"Earth", "Mars", "Venus", "Jupiter"}, 'B'),
                new Question("3️⃣ Who wrote 'Romeo and Juliet'?",
                        new String[]{"Charles Dickens", "William Shakespeare", "Mark Twain", "Leo Tolstoy"}, 'B'),
                new Question("4️⃣ What is 5 + 7?",
                        new String[]{"10", "11", "12", "13"}, 'C'),
                new Question("5️⃣ What is the largest ocean on Earth?",
                        new String[]{"Atlantic Ocean", "Indian Ocean", "Pacific Ocean", "Arctic Ocean"}, 'C')
        };
    }

    public void startQuiz() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        userName = sc.nextLine();

        for (Question q : questions) {
            q.displayQuestion();
            System.out.print("Your answer (A/B/C/D): ");
            char answer = sc.nextLine().trim().toUpperCase().charAt(0);

            if (q.checkAnswer(answer)) {
                score++;
            }
        }

        System.out.println("\n🎉 Quiz completed!");
        System.out.println("User: " + userName);
        System.out.println("Score: " + score + "/" + questions.length);

        saveResult();
    }

    private void saveResult() {
        try (FileWriter writer = new FileWriter("results.txt", true)) {
            writer.write("User: " + userName + "\n");
            writer.write("Score: " + score + "/" + questions.length + "\n");
            writer.write("-------------------------\n");
            System.out.println("✅ Result saved successfully to results.txt");
        } catch (IOException e) {
            System.out.println("❌ Error saving results: " + e.getMessage());
        }
    }
}
