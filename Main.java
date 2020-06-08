import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        DraftClass test = new DraftClass();
        System.out.println("How many pokemon do you want to generate");
        test.generateDraftClass(scan.nextInt());
        System.out.println(test.toString());
    }
}
