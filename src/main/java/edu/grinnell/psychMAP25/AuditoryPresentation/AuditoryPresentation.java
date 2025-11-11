package edu.grinnell.psychMAP25.AuditoryPresentation;

import java.util.List;
import java.util.Scanner;

public class AuditoryPresentation {

    public static void clearConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Sequence> sequences = null;
        String choice = "";

        // Keep prompting until valid input
        while (true) {
            System.out.println("Which sequence set would you like to use?");
            System.out.println("Enter a for Condition A");
            System.out.println("Enter b for Condition B");
            choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("b")) {
                clearConsole();
                sequences = SequenceBank2.getAllSequences();
                break;
            } else if (choice.equals("a")) {
                clearConsole();
                sequences = SequenceBank.getAllSequences();
                break;
            } else {
                clearConsole();
                System.out.println("Invalid input. Please enter 'a' or 'b'.\n");
            }
        }

        System.out.println("Playing Sounds!");

        for (Sequence seq : sequences) {
            seq.play();
            try {
                Thread.sleep(5000); // pause between sequences
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Done playing all sequences.");
    }
}
