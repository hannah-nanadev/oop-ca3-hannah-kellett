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
        //Initialise stacks
        Deque<Integer> driveway = new ArrayDeque<>();
        Deque<Integer> street = new ArrayDeque<>();

        //Menu loop
        boolean running = true;
        while(running)
        {
            System.out.println(
                    "Driveway: " + driveway.toString()
                + "\nWhat do you want to do?"
                + "\nType in a positive integer to add a car or a negative integer to remove it."
                + "\nType 'STOP' to stop."
            );

            Scanner input = new Scanner(System.in);

            String in = input.nextLine();
            if(in.equals("STOP")) //End loop if "STOP" - otherwise attempt to cast to int and do operation on stack
            {
                running = false;
                System.out.println("Simulation stopping. Thank you!");
            }
            else
            {
                int op;

                try{ //Tries to cast input to integer, catches error if it fails
                    op = Integer.parseInt(in);

                    if(validateOperation(op)) //Check if input is 0 before trying to run operation
                    {
                        runOperation(op, driveway, street);
                    }

                }
                catch(Exception e)
                {
                    System.out.println("Invalid input. Please try again.");
                }
            }


        }
    }

    public static boolean validateOperation(int operation)
    {
        if(operation==0)
        {
            System.out.println("Invalid input. Please try again.");
            return false;
        }
        else return true;
    }

    public static void runOperation(int operation, Deque<Integer> main, Deque<Integer> temp)
    {
        if(operation>0) //Add car to main stack
        {
            main.push(operation);
        }
        else //Try to remove car from main stack if it's there, moving other cars to temp stack to make way
        {

            operation = Math.abs(operation); //Make operation positive

            if(main.contains(operation)) //Check if main stack contains requested element before shuffling anything
            {
                boolean running = true;
                while(running)
                {
                    if(main.peek()==operation) //If requested element is on top, pop it.
                    {
                        System.out.println("Removed " + main.pop() + " from driveway");
                        running = false;
                    }
                    else //Otherwise, pop element and push it to temp
                    {
                        System.out.println("Moved " + main.peek() + " to street");
                        temp.push(main.pop());
                    }

                }

                while(!temp.isEmpty()) //If elements had to be moved to temp, move them back to main
                {
                    System.out.println("Moved " + temp.peek() + " back to driveway");
                    main.push(temp.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
