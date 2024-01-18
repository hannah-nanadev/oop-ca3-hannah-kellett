/**
 *  Name: Hannah Kellett
 *  Class Group: GD2B
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CA3_Question1
{
    public static void runSimulation()
    {
        Deque<Integer> driveway = new ArrayDeque<>();
        Deque<Integer> street = new ArrayDeque<>();

        boolean running = true;
        while(running)
        {
            System.out.println(
                    "Driveway: " + driveway.toString()
                + "\nStreet: " + street.toString()
                + "\nWhat do you want to do?"
                + "\nType in a positive integer to add a car or a negative integer to remove it."
                + "\nType 'STOP' to stop."
            );

            Scanner input = new Scanner(System.in);

            String in = input.nextLine();
            if(in.equals("STOP"))
            {
                running = false;
                System.out.println("Simulation stopping. Thank you!");
            }

        }
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
