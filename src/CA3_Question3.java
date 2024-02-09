import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.util.ArrayList;
/**
 *  Name: Hannah Kellett
 *  Class Group: GD2B
 */

public class CA3_Question3
{
    public static TreeMap<String, ArrayList<Integer>> readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        TreeMap<String, ArrayList<Integer>> identifiers = new TreeMap<>();

        try {
            Scanner line = new Scanner(file);
            int lineNo = 1;

            while(line.hasNextLine())
            { //Take full line first to be scanned by another scanner (for line number)
                String current = line.nextLine();

                Scanner in = new Scanner(current);
                in.useDelimiter("[^A-Za-z0-9_]+"); //Delimiter to properly pick out identifiers

                while(in.hasNext())
                {
                    String id = in.next(); //Get next identifier in line

                    if(!identifiers.containsKey(id)) //Add entry to map if not there before adding line numbers
                    {
                        identifiers.put(id, new ArrayList<>());
                    }
                    identifiers.get(id).add(lineNo);
                }

                lineNo++;

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return identifiers;
    }

    public static void main(String[] args) throws FileNotFoundException {
        TreeMap<String, ArrayList<Integer>> identifiers = readFile("src/CA3_Question1.java");
        System.out.println(identifiers);

    }
}
