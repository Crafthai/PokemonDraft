import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //create the pokedex and run it with however many pokes you want to draft
        Pokedex draft = new Pokedex("DraftClass.txt");

        System.out.println(draft.generateDraftClass(30));
    }
}
