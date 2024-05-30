//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class HuffApplication {
    static Scanner kbd;

    public HuffApplication() {
    }

    public static void main(String[] args) {
        String str = "";
        HuffTree tree = null;
        System.out.println("This is the Huffman Coding Application!");
        System.out.println("\nPlease input a Series of Characters.");
        System.out.print("Enter a phrase/sentence/paragraph: ");
        str = kbd.nextLine();

        while(true) {
            while(true) {
                try {
                    System.out.println("\nWhat shall we do now? ");
                    System.out.println("|--------------------------------|");
                    System.out.println("| 1. Convert the given input to Huffman Code");
                    System.out.println("| 2. Convert a Huffman Code to Text");
                    System.out.println("| 3. Exit");
                    System.out.println("--------------------------------");
                    int choice = enterChoice(1, 3);
                    switch (choice) {
                        case 1:
                            try {
                                TextUtility tu = new TextUtility(str);
                                ArrayList<Character> chars = tu.getCharacters();
                                ArrayList<Integer> freq = tu.getFrequency();
                                System.out.println();
                                tree = new HuffTree(chars, freq);
                                tree.printTable();
                                System.out.printf("%n%s%.2f%n", "% Savings = ", tree.computePercentageOfSavings());
                                System.out.printf("%s%s%n", "Huffman Code = ", tree.toHuffCodeEquivalent(str, 'x'));
                                System.out.printf("%s%s%n", "Text = ", tree.toTextEquivalent(tree.toHuffCodeEquivalent(str, 'a')));
                                System.out.println();
                                System.out.println("Huffman Tree (In order):");
                                tree.inorderTraversal();
                            } catch (Exception var7) {
                                System.out.println("Please input series of characters first");
                            }

                            enterKeyToContinue();
                            break;
                        case 2:
                            if (str == "") {
                                System.out.println("Please input series of characters first");
                                break;
                            }

                            System.out.println("\nPlease input a Huffman Code separated by space.");
                            System.out.print("Enter a Huffman Code: ");
                            str = kbd.nextLine();
                            if (!str.contains(" ") && !isCodeValid(tree, str)) {
                                System.out.println("Invalid Huffman Code! Make sure the Huffman code is separated by space");
                            } else {
                                System.out.printf("%s%s%n", "Text: ", tree.toTextEquivalent(str));
                            }

                            enterKeyToContinue();
                            break;
                        case 3:
                            System.out.println("Closing application...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid input, ensure to enter a correct choice..");
                    }
                } catch (Exception var8) {
                    System.out.println("There is an error, input cannot be converted. Try it again.");
                }
            }
        }
    }

    public static boolean isCodeValid(HuffTree t, String s) {
        Iterator var2 = t.leafNodes.iterator();

        HuffNode n;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            n = (HuffNode)var2.next();
        } while(!n.getCode().equals(s));

        return true;
    }

    public static int enterChoice(int min, int max) {
        int temp = 0;

        do {
            try {
                System.out.print("> ");
                temp = Integer.parseInt(kbd.nextLine());
                if (temp < min || temp > max) {
                    System.out.println("Invalid choice. Please ensure that you enter a number from " + min + " to " + max + ".");
                }
            } catch (NumberFormatException var4) {
                System.out.println("Invalid input, input another number.");
            }
        } while(temp < min || temp > max);

        return temp;
    }

    private static void enterKeyToContinue() {
        System.out.print("Press Enter key to continue...");

        try {
            System.in.read();
        } catch (Exception var1) {
            Exception e = var1;
            e.printStackTrace();
        }

    }

    static {
        kbd = new Scanner(System.in);
    }
}
