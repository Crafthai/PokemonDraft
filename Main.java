import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        boolean reroll = true;
        Scanner scan = new Scanner(System.in);
        DraftClass test = new DraftClass();
        System.out.println("How many pokemon do you want to generate? Max 400");
        int numPokemon = scan.nextInt();
        while(numPokemon > 400){
            System.out.println("Max 400");
            numPokemon = scan.nextInt();

        }
        test.generateDraftClass(numPokemon);
        System.out.println(test.toString());

        while(reroll){
            System.out.println("if you would like to reroll one, print the number here. Otherwise" +
                    " enter \"0\"");
            int rerollNum = scan.nextInt() -1;
            if(rerollNum != -1){
                test.reroll(rerollNum);
            } else {
                reroll = false;
            }
            System.out.println(test.toString());
        }
    }
}
