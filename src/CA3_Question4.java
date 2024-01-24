import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Hannah Kellett
 *  Class Group: GD2B
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException
    {
        File file = new File(filename);
        Scanner in = new Scanner(file);
        Stack<String> tags = new Stack<>();
        ArrayList<String> unresolved = new ArrayList<>();
        boolean isValid = true;

        while(in.hasNext())
        {
            tags.push(in.next());
        }

        while(!tags.isEmpty())
        {
            String current = tags.pop();
            if(current.contains("/"))
            {
                unresolved.add(current);
            }
            else
            {
                String closed = current.replace("<", "</");
                if(!unresolved.contains(closed))
                {
                    tags.empty();
                    isValid = false;
                }
                else
                {
                    unresolved.remove("closed");
                }
            }

        }
        return isValid;
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}
