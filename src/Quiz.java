import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Quiz {
    private Question[] questions;
    private int score = 0;
    private String userName;

    public Quiz() {
        // Initialize 5 sample questions
        questions = new Question[]{
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

    // === MENU SYSTEM ===
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== 🧠 QUIZ MENU ======");
            System.out.println("1️⃣ Start New Quiz");
            System.out.println("2️⃣ View All Results");
            System.out.println("3️⃣ Exit");
            System.out.print("Choose an option: ");
            while (!sc.hasNextInt()) {
                System.out.print("⚠️ Please enter a valid number (1-3): ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> startQuiz();
                case 2 -> showAllResults(); // 👈 Show results option
                case 3 -> System.out.println("👋 Exiting... Goodbye!");
                default -> System.out.println("⚠️ Invalid choice! Try again.");
            }
        } while (choice != 3);
    }

    // === QUIZ LOGIC ===
    public void startQuiz() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        userName = sc.nextLine();

        score = 0;

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

    // === SAVE RESULT TO FILE ===
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

    // === DISPLAY ALL SAVED RESULTS ===
    private void showAllResults() {
        File file = new File("results.txt");

        if (!file.exists()) {
            System.out.println("📁 No results found yet!");
            return;
        }

        System.out.println("\n====== 📜 ALL QUIZ RESULTS ======");
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading results: " + e.getMessage());
        }
    }
}
