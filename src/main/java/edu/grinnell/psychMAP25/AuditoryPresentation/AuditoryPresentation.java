package edu.grinnell.psychMAP25.AuditoryPresentation;

import java.util.List;
import java.util.Scanner;

public class AuditoryPresentation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which sequence set would you like to use?");
        System.out.println("Enter 1 for SequenceBank");
        System.out.println("Enter 2 for SequenceBank2");
        String choice = scanner.nextLine().trim();

        List<Sequence> sequences;
        if (choice.equals("2")) {
            sequences = SequenceBank2.getAllSequences();
        } else {
            sequences = SequenceBank.getAllSequences();  // default to SequenceBank
        }

        for (Sequence seq : sequences) {
            seq.play();
            try {
                Thread.sleep(5000); // pause between sequences
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("✅ Done playing all sequences.");
    }
}
