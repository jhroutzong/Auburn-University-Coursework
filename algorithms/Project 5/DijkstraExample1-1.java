    // Java Program shows the implementation Dijkstra's Algorithm  
    // Using the Priority Queue  
      
    // import statement  
    import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.IOException;
//import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.lang.Math;
import java.io.*;
      
    // Main class DijkstraExample1  
    public class DijkstraExample1  
    {  
      
    // Member variables of the class  
    private int distance[];  
    private Set<Integer> settld;  
    private PriorityQueue<Node> pQue;  
      
    // Total count of the vertices  
    private int totalNodes;  
    List<List<Node> > adjacent;  
      
    // Constructor of the class  
    public DijkstraExample1(int totalNodes)  
    {  
      
    this.totalNodes = totalNodes;  
    distance = new int[totalNodes];  
    settld = new HashSet<Integer>();  
    pQue = new PriorityQueue<Node>(totalNodes, new Node());  
    }  
      
    public void dijkstra(List<List<Node> > adjacent, int s)  
    {  
    this.adjacent = adjacent;  
      
    for (int j = 0; j < totalNodes; j++)  
    {  
    // initializing the distance of every node to infinity (a large number)  
    distance[j] = Integer.MAX_VALUE;  
    }  
      
    // Adding the source node to pQue  
    pQue.add(new Node(s, 0));  
      
    // distance of the source is always zero  
    distance[s] = 0;  
      
    while (settld.size() != totalNodes)   
    {  
      
    // Terminating condition check when  
    // the priority queue contains zero elements, return  
    if (pQue.isEmpty())  
    {  
    return;  
    }  
      
    // Deleting the node that has the minimum distance from the priority queue  
    int ux = pQue.remove().n;  
      
    // Adding the node whose distance is   
    // confirmed  
    if (settld.contains(ux))  
    {  
    continue;  
    }  
      
    // We don't have to call eNeighbors(ux)  
    // if ux is already present in the settled set.  
    settld.add(ux);  
      
    eNeighbours(ux);  
    }  
    }  
      
    private void eNeighbours(int ux)  
    {  
      
    int edgeDist = -1;  
    int newDist = -1;  
      
    // All of the neighbors of vx  
    for (int j = 0; j < adjacent.get(ux).size(); j++)   
    {  
    Node vx = adjacent.get(ux).get(j);  
      
    // If the current node hasn't been already processed  
    if (!settld.contains(vx.n))   
    {  
        edgeDist = vx.price;  
        newDist = distance[ux] + edgeDist;  
      
        // If the new distance is lesser in the cost  
        if (newDist < distance[vx.n])  
        {  
            distance[vx.n] = newDist;  
        }  
      
        // Adding the current node to the priority queue pQue  
        pQue.add(new Node(vx.n, distance[vx.n]));  
    }  
    }  
    }  
      static String extractInt(String str)
   {
      str = str.replaceAll("[^\\d]", " ");
      str = str.trim();
      str = str.replaceAll(" +", " ");
      if (str.equals("")) {
         return "-1"; }
      return str;
   }

    // Main method  
    public static void main(String[] args) throws IOException, FileNotFoundException, IndexOutOfBoundsException
    {  
      System.out.println("Please enter the name of the text file you're wishing to enter");
      Scanner scan = new Scanner(System.in);
      Scanner scanner = new Scanner(new File(scan.next()));
      String z = scanner.next();
      int a = Integer.parseInt(z);
      a++;
      scanner.nextLine();
    int totalNodes = a;  
    
      
    // representation of the connected edges   
    // using the adjacency list   
    // by declaration of the List class object  
      
    // Declaring and object of the type List<Node>  
    List<List<Node> > adjacent = new ArrayList<List<Node>>();  
      
    // Initialize list for every node  
    for (int i = 0; i < totalNodes; i++) {  
        List<Node> itm = new ArrayList<Node>();  
        adjacent.add(itm);  
    }  
      
    // adding the edges  
    // The statement adjacent.get(0).add(new Node(1, 3)); means  
    // to travel from node 0 to 1, one has to cover 3 units of distance  
    // it does not mean one has to travel from 1 to 0  
    // To travel from 1 to 0, we have to add the statement   
    // adjacent.get(1).add(new Node(0, 3));  
    // Note that the distance is the same i.e., 3 units in both the cases.  
    // Similarly, we have added other edges too.  
     
      while (scanner.hasNext()) {
         String sa = scanner.nextLine();
         String f = extractInt(sa);
         String[] t = f.split(" ");
         int[] iValues = new int[t.length];
         
         for (int index = 0; index < t.length; index++) {
            String sValue = t[index];
            iValues[index] = Integer.parseInt(t[index]);
            
         }
         
         int counter = 1;
         int zip = iValues.length;
         for (int i = 1; i < zip; i = i + 2) {
         if (counter == iValues.length) {
         int[] newArr = Arrays.copyOf(iValues, iValues.length + 1);
                iValues = newArr; }
         int v = iValues[0];
         int x = iValues[i];
         int y = iValues[i + 1];
         adjacent.get(v).add(new Node(x, y));
         counter = counter + 2;
          }
          }
          
     
    
      
    // creating an object of the class DijkstraExample1  
    DijkstraExample1 obj = new DijkstraExample1(totalNodes);  
    // for (int s = 0; s < a; s = s++) {
    int s = 0;
    obj.dijkstra(adjacent, s);  
    
    File filename = new File("outputShortestPaths.txt");
    FileWriter fw = new FileWriter(filename);

    
    fw.write("The source for our program by default is " + s + "\n");
    fw.write("To change the source node, change it by editing line 186 of DijkstraExample1. \n");
      for (int j = 0; j < obj.distance.length; j++)  
    {  
        fw.write("The distance from " + s + " to " + j + " is " + obj.distance[j] + "!\n");  
    }  

    fw.close();
    
    
    // Printing the shortest path to all the nodes  
    // from the source node  
    // System.out.println("The shortest path from the node :");  
      
     }  
     }
    
      
    // The Node class implementing the Comparator interface  
    // The object of this class represents a node of the graph  
    class Node implements Comparator<Node>   
    {  
      
    // Member variables of the Node class  
    public int n;  
    public int price;  
      
    // Constructors of this class  
      
    // Constructor 1  
    public Node()   
    {  
          
    }  
      
    // Constructor 2  
    public Node(int n, int price)  
    {  
    this.n = n;  
    this.price = price;  
    }  
      
    @Override   
    public int compare(Node n1, Node n2)  
    {  
      
    if (n1.price < n2.price)  
    {  
    return -1;  
    }  
    if (n1.price > n2.price)  
    {  
    return 1;  
    }  
      
    return 0;  
    }  
    }  
    