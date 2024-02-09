import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
/**
 *  Name: Hannah Kellett
 *  Class Group: GD2B
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
        int sharesTotal = 0;

        //Directions outside do while loop to avoid unnecessary clutter
        System.out.println("Syntax:\nbuy <quantity of shares> <price per share>" +
                "\nsell <quantity of shares> <price per share>");

            do {
            System.out.print("Enter command.\n>");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            { //Adds bundle of shares to queue
                int qty = in.nextInt();
                double price = in.nextDouble();

                shares.add(new Share(qty, price));

            }
            else if(command.equals("sell"))
            { //Removes a certain amount of shares from bundle(s) at head and calculates profit made
                int qty = in.nextInt();
                double price = in.nextDouble();

                double sellPrice = qty*price;
                if(qty<=sharesTotal||!shares.isEmpty())
                {
                    int sold = qty;
                    double profit;
                    double buyPrices = 0;

                    while(sold>0)
                    { //Go through queue peeking/reducing/removing bundles and calculating profit
                        int topQty = shares.peek().getQuantity();

                        if(sold<=topQty){
                            buyPrices = buyPrices+(sold*shares.peek().getPrice());
                            shares.peek().setQuantity(topQty-sold);
                            sold = 0;
                        }
                        else
                        {
                            buyPrices = buyPrices+(shares.peek().getCost());
                            sold = sold-shares.peek().getQuantity();
                            shares.remove();
                        }

                        if(shares.peek().getQuantity()==0)
                        {
                            shares.remove();
                        }
                    }

                    profit = sellPrice-buyPrices;
                    System.out.println("Earnings from selling shares: " + profit);

                }
                else{
                    System.out.println("You don't have that many shares.");
                }
            }

            //Calculate current number of shares
            sharesTotal = 0;
            for(int i = 0; i<shares.size(); i++)
            {
                sharesTotal = sharesTotal+shares.peek().getQuantity();
            }

        }while(!command.equalsIgnoreCase("quit"));
    }
}