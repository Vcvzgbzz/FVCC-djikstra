//DSSP22_BreathFirst

package dijkstra;
import java.util.Scanner;

class Dijkstra {
    public static int totalVertex = 6;


    public Dijkstra() {

    }

    public static void setTotalVertex(int totalVertex) {
        Dijkstra.totalVertex = totalVertex;
    }






    int minDistance(int distance[], Boolean spSet[]) {
        int m = Integer.MAX_VALUE;
        int m_index = -1;

        for (int vx = 0; vx < totalVertex; vx++) {
            if (spSet[vx] == false && distance[vx] <= m) {
                m = distance[vx];
                m_index = vx;
            }
        }

        return m_index;

    }

    // print utility
    void printSolution(int distance[], int n) {
        System.out.println("The shortest distance from source"
                + " to all other vertices");
        for (int i = 0; i < n; i++) {
            System.out.println("To " + i + " the shortest distance is "
                    + distance[i]);

            // "); 
        }

        System.out.println("\n----------\n");
    }

    void dijkstra(int graph[][], int s) {
        int distance[] = new int[totalVertex];
        Boolean spSet[] = new Boolean[totalVertex];

        for (int i = 0; i < totalVertex; i++) {
            distance[i] = Integer.MAX_VALUE;
            spSet[i] = false;
        }

//Distance to source to itself is 0
        distance[s] = 0;

//compute the shortest distance
        for (int c = 0; c < totalVertex - 1; c++) {
            int ux = minDistance(distance, spSet);
            spSet[ux] = true;

            //visit the neighbors
            for (int vx = 0; vx < totalVertex; vx++) {
                if (!spSet[vx]
                        && graph[ux][vx] != -1
                        && distance[ux] != Integer.MAX_VALUE
                        && distance[ux] + graph[ux][vx] < distance[vx]) {
                    distance[vx] = distance[ux] + graph[ux][vx];
                }
            }
        }

        printSolution(distance, totalVertex);

    }

}

public class djikstra {
    static Scanner myScan = new Scanner(System.in);
    static int node;
    public static void main(String[] args) {

        //arr[x][y] -1 means there is no edge that connects the noex x and y directly
        // first box node position
        // weights from that node
        try{
            System.out.println("What node would you like to start from? (0-5) FIRST DIAGRAM");
            node = myScan.nextInt();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }



        int grp[][] = new int[][]{
                {-1,1,-1,-1,-1,8}, //node 0
                {1,-1,1,8,-1,-1},
                {-1,1,-1,7,-1,1},
                {-1,8,7,-1,1,-1},
                {-1,-1,-1,1,-1,1},
                {8,-1,1,-1,1,-1} //node 5
        };

        Dijkstra obj = new Dijkstra();

        obj.dijkstra(grp, node);



        try{

            System.out.println("What node would you like to start from? (0-6) SECOND DIAGRAM");
            node = myScan.nextInt();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        int grp2[][] = new int[][]{
                {-1,6,-1,-1,-1,8,2}, //node 0
                {6,-1,1,-1,-1,-1,3},
                {-1,1,-2,7,3,-1,-1}, //node 2
                {-1,-1,7,-1,1,-1,-1},
                {-1,-1,-3,1,-1,1,4},//node 4
                {8,-1,-2,-1,1,-1,-1},
                {2,3,-1,-1,4,-1,-1}


        };

        Dijkstra obj2 = new Dijkstra();
        obj2.setTotalVertex(7);
        obj2.dijkstra(grp2, node);
    }

}


