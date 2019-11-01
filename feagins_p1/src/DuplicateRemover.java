import java.io.*;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DuplicateRemover {
    public ArrayList<String> uniqueWords2 = new ArrayList<String>();
    public int numUniqueWords;
    public HashSet<String> uniqueWords;
    public int index = 0;
    //public HashMap<Integer, String> uniqueWords;

    public void remove(String dataFile) {
        FileInputStream reader = null;
        Scanner inFS = null;
        HashSet<String> uWords = new HashSet<String>();
        String temp = "abc";
        try {
            reader = new FileInputStream(dataFile);
            inFS = new Scanner(reader);
            while (inFS.hasNext()) {
                temp = inFS.next();
                uWords.add(temp);
                this.uniqueWords2.add(temp);
                index++;
            }
        }
        catch(Exception except) {
            //System.out.println("Problem reading dataFile.");
        }
        finally {
            inFS.close();
        }
        this.numUniqueWords = index;
        //this.numUniqueWords = uWords.size();
        this.uniqueWords = uWords;
        }
                                                    //^^^^^^^^^DONE^^^^^^^^^

    public void write(String outputFile) throws FileNotFoundException {
        File checkFile = new File(outputFile);
        if (checkFile.exists()) {
            //System.out.println("File exists");
            PrintWriter writer = new PrintWriter(outputFile);
            try {
                for (int i = 0; i < numUniqueWords; i++) {
                    if (uniqueWords.contains(uniqueWords2.get(i))) {
                        writer.println(uniqueWords2.get(i));
                        this.uniqueWords.remove(uniqueWords2.get(i));
                    }
                }
                writer.close();
            }
            catch(Exception except) {
                //System.out.println("Problem writing to file");
            }
        }
        else {
            //System.out.println("File does not exist\nCreating....");
            File newFile = new File(outputFile);
            PrintWriter writer = new PrintWriter(newFile);
            try {
                for (int i = 0; i < numUniqueWords; i++) {
                    if (uniqueWords.contains(uniqueWords2.get(i))) {
                        writer.println(uniqueWords2.get(i));
                        this.uniqueWords.remove(uniqueWords2.get(i));
                    }
                }
                writer.close();
            }
            catch(Exception except) {
                //System.out.println("Problem writing to  file");
            }
            finally {
                uniqueWords.clear();
                uniqueWords2.clear();

            }
        }



    }
    public void main(String[] args) {
        //write("unique_words.txt");
    }
}
