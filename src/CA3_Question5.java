import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name: Hannah Kellett
 *  Class Group: GD2B
 */

public class CA3_Question5
{

    public static void main(String[] args)
    {
        Queue<String> takingoff = new LinkedList<>();
        Queue<String> landing = new LinkedList<>();
        Queue<String> tasks = new LinkedList<>();

        boolean running = true;
        while(running)
        {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter command\n>");
            String cmd = input.nextLine();

            if(validate(cmd))
            {
                System.out.println("Command is valid.");
            }
            else
            {
                System.out.println("Invalid command. Try again.");
            }

        }
    }

    private static ArrayList<String> validCmds()
    {
        ArrayList<String> val = new ArrayList<>(Arrays.asList("takeoff", "land", "next", "quit"));
        return val;
    }

    private static boolean validate(String input)
    {
        Scanner read = new Scanner(input);
        String cmd = read.next();

        if(validCmds().contains(cmd))
        {
            return true;
        } else return false;
    }

    private static void parse(String input)
    {
        Scanner read = new Scanner(input);
        String cmd = read.next();
        String arg = read.next();

        switch(cmd)
        {
            case "takeoff":
                break;
            case "land":
                break;
            case "next":
                break;
            case "quit":
                break;
        }

    }
}
