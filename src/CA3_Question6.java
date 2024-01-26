import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
/**
 *  Name: Hannah Kellett
 *  Class Group:
 */
public class CA3_Question6
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {

        Queue<Share> shares = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        String command="";
            do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();

                shares.add(new Share(qty, price));

            }
            else if(command.equals("sell"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();

                double totalPrice = qty*price;
                double profit;

                int topQty = shares.peek().getQuantity();

                if(topQty<=qty)
                {
                    
                }
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}