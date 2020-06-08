import java.util.*;
import java.io.*;

public class DraftClass {

    private int numPokemon;
    private String[] allPokemon;
    private String[] draftClass;
    private Random rand = new Random();
    private int max;
    private String format;
    /**
     * constructor which fills the array with all 807 pokemon from a text file
     * @throws FileNotFoundException
     */
    DraftClass() throws FileNotFoundException {
        Scanner name = new Scanner(System.in);
        System.out.println("select format, 1 for all pokemon, 2 for sword/shield VGC");
        String statement = name.next();
        switch(statement){
            case "1": format = "Pokedex";
            numPokemon = 807;
            break;
            case "2": format = "Gen8VGC";
            System.out.println("Do you want alternate forms? Default form is Galarian for Galarian Pokemon. Default" +
                    " for Pokemon with Alolan forms are their normal forms. type 1 for additional forms, " +
                    "or type 2 for no additional forms");
            statement = name.next();
            if(statement.equals("1")){
                numPokemon = 234;
            } else {
                numPokemon = 226;
            }
            break;
            default: System.out.println("you really let me down");
            numPokemon = 10000;
            break;
        }
        max = numPokemon-1;
        allPokemon = new String[numPokemon];
        Scanner scan = new Scanner(new File(format));

        int i = 0;
        while(scan.hasNext()){
            if(i == 226 & statement.equals("2")){
                break;
            }
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
