import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Hannah Kellett
 *  Class Group: GD2B
 */
public class CA3_Question8 {

    /*
        Reads in an equation from the user
        in reverse Polish notation
     */
    public static void main(String[] args) {
        //Initialisation
        String equation;
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter equation with a space between each number/operator");
        equation = in.nextLine().trim();

        //Reading and calculation
        Stack<Integer> results = new Stack<>();
        Scanner read = new Scanner(equation);

        while(read.hasNext())
        {
            String val = read.next();

            //Try to parse as int and push to stack, otherwise perform operation
            try
            {
                results.push(Integer.parseInt(val));
            }
            catch(Exception e)
            {
                int a = results.pop();
                int b = results.pop();

                switch(val)
                {
                    case "+":
                        results.push(a+b);
                        break;
                    case "-":
                        results.push(a-b);
                        break;
                    case "*":
                        results.push(a*b);
                        break;
                    case "/":
                        results.push(a/b);
                        break;
                    default:
                        System.out.println("Ignoring invalid operation " + val);
                }
            }

        }

        System.out.println(results);

    }
}
