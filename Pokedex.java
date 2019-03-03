import java.io.*;
import java.util.*;

public class Pokedex {

    private ArrayList<String> pokedex = new ArrayList<String>(); // - the ArrayList with all pokemon
    private Random rand = new Random();                     // - the random generator to create the draft class
    private int poke;                                       // - also part of the random generator
    private StringBuilder draftClass = new StringBuilder(); // - StringBuilder to change the draft class if needed

    /**
     * constructor that takes @param file and lists all pokemon
     * @throws FileNotFoundException just incase
     */
    Pokedex(String file) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(file));

        //while there are pokemon to be added to the list, add them to the list
        while(scan.hasNextLine()){
            pokedex.add(scan.nextLine());
        }
    }

    /**
     * @param amount the amount of pokemon you want generated
     * @return the list of pokemon
     */
    String generateDraftClass(int amount){

        for(int i = 0; i < amount; i++){
            //generate a random number and then get the pokemon that corresponds to that number from
            //the ArrayList
            poke = rand.nextInt(pokedex.size());
            draftClass.append("\n").append(i + 1).append(". #").append(pokedex.get(poke));
        }

        return draftClass.toString();
    }

    /**
     * @return String of all possible pokemon to be drafted
     */
    @Override
    public String toString(){
        String printed = "";
        for(int i = 0; i < pokedex.size(); i++){
            printed = printed + pokedex.get(i) + "\n";
        }
        return printed;
    }
}
