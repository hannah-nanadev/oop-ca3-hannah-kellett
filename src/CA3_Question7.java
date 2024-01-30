import java.util.*;
/**
 *  Name: Hannah Kellett
 *  Class Group: GD2B
 */
public class CA3_Question7
{
    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args) {

        Map<String, Queue<Share>> shares = new HashMap<>();

        Scanner in = new Scanner(System.in);
        String command="";
        do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to buy shares here

                if(!shares.containsKey(company)) //Make new entry for company if not present before adding share to queue
                {
                    shares.put(company, new LinkedList<>());
                }
                shares.get(company).add(new Share(qty, price));


            }
            else if(command.equals("sell"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to sell shares and calculate profit here

                //First, check number of shares company has
                int sharesTotal = 0;
                for(int i = 0; i<shares.size(); i++)
                {
                    sharesTotal = sharesTotal+shares.get(company).peek().getQuantity();
                }

                //Following code adapted from question 7
                double sellPrice = qty*price;
                if(qty<=sharesTotal||!shares.get(company).isEmpty())
                {
                    int sold = qty;
                    double profit;
                    double buyPrices = 0;

                    while(sold>0)
                    {
                        int topQty = shares.get(company).peek().getQuantity();

                        if(sold<=topQty){
                            buyPrices = buyPrices+(sold*shares.get(company).peek().getPrice());
                            shares.get(company).peek().setQuantity(topQty-sold);
                            sold = 0;
                        }
                        else
                        {
                            buyPrices = buyPrices+(shares.get(company).peek().getCost());
                            sold = sold-shares.get(company).peek().getQuantity();
                            shares.get(company).remove();
                        }

                        if(shares.get(company).peek().getQuantity()==0)
                        {
                            shares.get(company).remove();
                        }
                    }

                    profit = sellPrice-buyPrices;
                    System.out.println("Earnings from selling shares for " + company + ": " + profit);

                }
                else{
                    System.out.println(company + " does not have that many shares.");
                }

            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}
