import com.sun.source.tree.Tree;

import java.util.TreeSet;
import java.util.HashMap;
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
        Map<String, TreeSet<DistanceTo>> connections = readConnections();
    }

    public static Map<String, TreeSet<DistanceTo>> readConnections()
    {
        File file = new File("citymap.txt");
        Map<String, TreeSet<DistanceTo>> map = new HashMap<>();

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
