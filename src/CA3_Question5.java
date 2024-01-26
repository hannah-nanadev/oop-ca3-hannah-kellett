import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name: Hannah Kellett
 *  Class Group: GD2B
 */

public class CA3_Question5 {

    public static void main(String[] args) {
        Queue<String> takingoff = new LinkedList<>();
        Queue<String> landing = new LinkedList<>();
        Queue<String> tasks = new LinkedList<>();

        boolean running = true;
        while (running) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter command\n>");
            String cmd = input.nextLine();

            running = parse(cmd, takingoff, landing, tasks);

        }
    }

    private static boolean parse(String input, Queue<String> takeoff,
                              Queue<String> landing, Queue<String> tasks) {
        Scanner read = new Scanner(input);
        String cmd = read.next();
        String arg;

        boolean run = true;

        switch (cmd) {
            case "takeoff":
                arg = read.next();
                queueTask(cmd, arg, takeoff, tasks);
                break;
            case "land":
                arg = read.next();
                queueTask(cmd, arg, landing, tasks);
                break;
            case "next":
                evalTask(tasks, takeoff, landing);
                break;
            case "quit":
                System.out.println("Ending simulation.");
                run = false;
                break;
            default:
                System.out.println("Invalid command. Please try again.");
                break;
        }

        return run;
    }

    private static void queueTask(String cmd, String arg, Queue<String> q, Queue<String> taskQueue) {
        q.add(arg);
        taskQueue.add(cmd);

        System.out.println("Plane " + arg + " added to queue " + cmd);
    }

    private static void evalTask(Queue<String> tasks, Queue<String> takeoff, Queue<String> landing)
    {
        if(!tasks.isEmpty())
        {
            String task = tasks.remove();
            String arg;

            switch (task) {
                case "takeoff":
                    arg = takeoff.remove();
                    System.out.println("Flight " + arg + " has taken off.");
                    break;
                case "land":
                    arg = landing.remove();
                    System.out.println("Flight " + arg + " has landed.");
                    break;
                default:
                    System.out.println("Invalid command in queue.\n" +
                            "This message should not appear. Please report the issue.");
                    break;
            }
        }
        else
        {
            System.out.println("No tasks in queue.");
        }
    }

}
