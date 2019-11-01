import java.util.Scanner;
import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile;
        String outputFile;
        inputFile = "problem2.txt";
        outputFile = "unique_word_counts.txt";

        DuplicateCounter start = new DuplicateCounter();
        start.count(inputFile);
        start.write(outputFile);

    }
}
