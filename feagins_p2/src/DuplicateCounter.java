import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DuplicateCounter {
    public Map < String, Integer > wordCounter = new HashMap<String, Integer>();
    //public ArrayList<String> stringList = new ArrayList<String>();

    public void count(String dataFile) {
        FileInputStream reader = null;
        Scanner inFS = null;
        String temp;
        int tempTotal;

        try {
            reader = new FileInputStream(dataFile);
            inFS = new Scanner(reader);
            while (inFS.hasNext()) {
                temp = inFS.next();
                //System.out.println(temp);
                if (wordCounter.get(temp) == null) {
                    wordCounter.put(temp, 1);
                    //System.out.println("if " + temp);
                }
                else {
                    tempTotal = wordCounter.get(temp);
                    tempTotal++;
                    wordCounter.put(temp, tempTotal);
                    //System.out.println("else " + temp + " " + tempTotal);
                }
            }
        }
        catch (Exception except){
            System.out.println("Error in count method");
        }
        finally {
            inFS.close();
        }
    }
    public void write(String outputFile) throws FileNotFoundException{
        File checkFile = new File(outputFile);
        if (checkFile.exists()) {
            PrintWriter writer = new PrintWriter(outputFile);
            try {
                for (Map.Entry<String, Integer> word : wordCounter.entrySet()) {
                    writer.println(word.getKey() + " " + word.getValue());
                }
            }
            catch (Exception except) {
                System.out.println("Error in write method 1");
            }
            finally {
                writer.close();
            }
        }
        else {
            File newFile = new File(outputFile);
            PrintWriter writer = new PrintWriter(newFile);
            try {

                for (Map.Entry<String, Integer> word : wordCounter.entrySet()) {
                    writer.println(word.getKey() + " " + word.getValue());
                }
            }
            catch (Exception except) {
                System.out.println("Error in write method 2");
            }
            finally {
                writer.close();
                wordCounter.clear();
            }
        }
    }
}
