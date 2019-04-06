import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        DraftClass test = new DraftClass();
        test.generateDraftClass(150);
        System.out.println(test.toString());
    }
}
