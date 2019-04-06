import java.util.*;
import java.io.*;

public class DraftClass {

    private final int numPokemon = 807;
    private String[] allPokemon = new String[numPokemon];
    private String[] draftClass;
    private Random rand = new Random();
    private int max = 806;
    /**
     * constructor which fills the array with all 807 pokemon from a text file
     * @throws FileNotFoundException
     */
    DraftClass() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Pokedex"));

        int i = 0;
        while(scan.hasNext()){
            allPokemon[i] = scan.nextLine();
            i++;
        }
    }

    /**
     * generates a draft class of pokemon
     * @param numProspects the amount of pokemon you want to be drafted
     */
    void generateDraftClass(int numProspects){
        int[] numList;
        draftClass = new String[numProspects];
        numList = this.randomClass(numProspects);

        for(int i = 0; i < numProspects; i++){
            draftClass[i] = allPokemon[numList[i]];
        }

    }

    /**
     * rerolls a specific pokemon
     * @param target the poke you want rerolled
     */
    void reroll(int target){
        //todo
    }

    /**
     * generates an array of random numbers without duplicating
     * any numbers until the draft is complete
     *
     * @param numProspects the number of random numbers to generate
     *                     which is equal to the amount of pokemon
     *                     in the draft class
     * @return an array of integers to select the pokemon
     */
    private int[] randomClass(int numProspects){
        int[] fullList = new int[numPokemon];
        int[] returnThis = new int[numProspects];
        int temp;
        int tempRandom;

        for(int i = 0; i < numPokemon; i++){
            fullList[i] = i;
        }

        for(int j = 0; j < numProspects; j++){
            temp = fullList[max];
            tempRandom = rand.nextInt(max);
            fullList[max] = fullList[tempRandom];
            fullList[tempRandom] = temp;
            max--;
        }

        int i = 0;
        for(int k = (numPokemon-1)-numProspects; k < numPokemon-1; k++){
            returnThis[i] = fullList[k];
            i++;
        }

        return returnThis;
    }

    @Override
    public String toString(){
        StringBuilder listOfPokes = new StringBuilder();

        for(int i = 0; i < draftClass.length; i++){
            if(i < 9){
                listOfPokes.append("\n").append("00").append(i + 1).append(".) ").append(draftClass[i]);
            } else if(i < 99){
                listOfPokes.append("\n").append("0").append(i + 1).append(".) ").append(draftClass[i]);
            } else {
                listOfPokes.append("\n").append(i + 1).append(".) ").append(draftClass[i]);
            }
        }
        return listOfPokes.toString();
    }

}
