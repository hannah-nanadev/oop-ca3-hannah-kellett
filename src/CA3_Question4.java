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

        //Push all tags to stack
        while(in.hasNext())
        {
            tags.push(in.next());
        }

        while(!tags.isEmpty())
        { //Go through stack - if a </> comes up before its <> add it to an arraylist until finding its <>
            String current = tags.pop();
            if(current.contains("/"))
            {
                unresolved.add(current);
            }
            else
            {
                String closed = current.replace("<", "</"); //Turn tag into closed tag to compare
                if(!unresolved.contains(closed)) //If converted tag has not already appeared, the string is invalid
                {
                    tags.empty();
                    isValid = false;
                }
                else //otherwise remove unresolved tag
                {
                    unresolved.remove(closed);
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
        //Main - take two files and check if they are valid or not
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
