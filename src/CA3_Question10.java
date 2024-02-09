import com.sun.source.tree.Tree;

import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Map;
import java.util.PriorityQueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *  Name: Hannah Kellett
 *  Class Group: GD2B
 */
public class CA3_Question10
{
    public static void main(String[] args) {
        File file = new File("citymap.txt");
        Map<String, TreeSet<DistanceTo>> connections = readConnections(file);

        try
        {
            Scanner input = new Scanner(file);
            String from = input.next();

            //Create and initialise priority queue
            PriorityQueue<DistanceTo> queue = new PriorityQueue<>();
            queue.add(new DistanceTo(from, 0));

            Map<String, Integer> shortestKnownDistance = new TreeMap<>();

            //Algorithm to add elements to shortestKnownDistance
            while(!queue.isEmpty())
            {
                DistanceTo current = queue.poll();
                String cTarget = current.getTarget();
                if(!shortestKnownDistance.containsKey(cTarget))
                {
                    //Add new target to map
                    shortestKnownDistance.put(cTarget, current.getDistance());

                    if(connections.get(cTarget)!=null) //Make sure list of connections isn't null
                    { //Connections are stored one-way to prevent the algorithm looping in on itself here
                        for(int i = 0; i<connections.get(cTarget).size(); i++)
                        {
                            DistanceTo dConn = connections.get(cTarget).pollFirst();
                            queue.add(new DistanceTo(dConn.getTarget(), dConn.getDistance() + current.getDistance()));
                        }
                    }
                }
            }

            System.out.println(shortestKnownDistance);
        }catch(IOException e)
        {
            System.out.println("File not found.");
        }

    }

    public static Map<String, TreeSet<DistanceTo>> readConnections(File file)
    {
        Map<String, TreeSet<DistanceTo>> map = new TreeMap<>();

        try
        {
            Scanner in = new Scanner(file);
            String c1;
            String c2;
            int dist;

            while(in.hasNext())
            {
                c1 = in.next();
                c2 = in.next();
                dist = Integer.parseInt(in.next());

                if(!map.containsKey(c1))
                {
                    map.put(c1, new TreeSet<>());
                }
                map.get(c1).add(new DistanceTo(c2, dist));
            }

        } catch(IOException e)
        {
            System.out.println("File not found.");
        }

        return map;
    }
}
