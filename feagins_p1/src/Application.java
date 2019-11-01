import java.io.FileNotFoundException;
import java.util.Scanner;
public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile;
        String outputFile;
        inputFile = "problem1.txt";
        //outputFile = "unique_words.txt";
        outputFile = "unique_words.txt";

        //Scanner scnr = new Scanner(System.in);
        //System.out.println("problem file: ");
        //inputFile = scnr.next();
        //System.out.println("fixed file: ");
        //outputFile = scnr.next();

        DuplicateRemover start = new DuplicateRemover();
        start.remove(inputFile);
        //System.out.println("Starting output process MAIN");
        start.write(outputFile);


    }
}
