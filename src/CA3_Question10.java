import com.sun.source.tree.Tree;

import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *  Name: Hannah Kellett
 *  Class Group: GD2B
 */
public class CA3_Question10
{
    public static void main(String[] args) {
        Map<String, TreeSet<DistanceTo>> connections = genConnections();
    }

    public static Map<String, TreeSet<DistanceTo>> genConnections()
    {
        Map<String, TreeSet<DistanceTo>> map = new HashMap<>();

        //Super scuffed but don't know how to do it better
        map.put("Pendleton", new TreeSet<>());
        map.get("Pendleton").add(new DistanceTo("Pierre", 2));
        map.get("Pendleton").add(new DistanceTo("Pueblo", 8));
        map.get("Pendleton").add(new DistanceTo("Phoenix", 4));

        map.put("Pierre", new TreeSet<>());
        map.get("Pierre").add(new DistanceTo("Pendleton", 2));
        map.get("Pierre").add(new DistanceTo("Pueblo", 3));

        map.put("Pueblo", new TreeSet<>());
        map.get("Pueblo").add(new DistanceTo("Pendleton", 8));
        map.get("Pueblo").add(new DistanceTo("Pierre", 3));
        map.get("Pueblo").add(new DistanceTo("Phoenix", 3));
        map.get("Pueblo").add(new DistanceTo("Peoria", 3));

        map.put("Phoenix", new TreeSet<>());
        map.get("Phoenix").add(new DistanceTo("Pendleton", 4));
        map.get("Phoenix").add(new DistanceTo("Pueblo", 3));
        map.get("Phoenix").add(new DistanceTo("Peoria", 4));
        map.get("Phoenix").add(new DistanceTo("Pittsburgh", 10));
        map.get("Phoenix").add(new DistanceTo("Pensacola", 5));

        map.put("Peoria", new TreeSet<>());
        map.get("Peoria").add(new DistanceTo("Pueblo", 3));
        map.get("Peoria").add(new DistanceTo("Pittsburgh", 5));
        map.get("Peoria").add(new DistanceTo("Phoenix", 4));

        map.put("Pittsburgh", new TreeSet<>());
        map.get("Pittsburgh").add(new DistanceTo("Peoria", 5));
        map.get("Pittsburgh").add(new DistanceTo("Pensacola", 4));
        map.get("Pittsburgh").add(new DistanceTo("Princeton", 2));

        map.put("Pensacola", new TreeSet<>());
        map.get("Pensacola").add(new DistanceTo("Phoenix", 5));
        map.get("Pensacola").add(new DistanceTo("Pittsburgh", 4));
        map.get("Pensacola").add(new DistanceTo("Princeton", 5));

        map.put("Princeton", new TreeSet<>());
        map.get("Princeton").add(new DistanceTo("Pittsburgh", 2));
        map.get("Princeton").add(new DistanceTo("Pensacola", 4));

        return map;
    }
}
